package com.example.makeyourfoodkartik;

import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class TandooriChickenActivity extends AppCompatActivity {

    ImageButton TANDOORI_CHICKEN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tandoori_chicken);

        TANDOORI_CHICKEN = findViewById(R.id.imageButton);

        TANDOORI_CHICKEN.setOnClickListener(v -> {
            // Get the root LinearLayout (parent of everything inside ScrollView)
            LinearLayout rootLayout = (LinearLayout) TANDOORI_CHICKEN.getParent().getParent();

            // Create a new VideoView
            VideoView videoView = new VideoView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    600 // fixed height for now; adjust as needed
            );
            layoutParams.setMargins(0, 30, 0, 30);
            videoView.setLayoutParams(layoutParams);

            // Set up the video URI with your clip.mp4
            Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.clip);
            videoView.setVideoURI(videoUri);

            // Add media controls
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);

            // Add the VideoView below the button dynamically
            int index = rootLayout.indexOfChild((ViewGroup) TANDOORI_CHICKEN.getParent());
            rootLayout.addView(videoView, index + 1); // Insert right after RelativeLayout with button

            // Start the video
            videoView.start();

            // Optional: disable the button after playing once
            TANDOORI_CHICKEN.setEnabled(false);

            // Optional: hide the video when playback ends
            videoView.setOnCompletionListener(mp -> {
                videoView.setVisibility(ViewGroup.GONE);
                TANDOORI_CHICKEN.setEnabled(true); // Re-enable button after video ends
            });
        });
    }
}
