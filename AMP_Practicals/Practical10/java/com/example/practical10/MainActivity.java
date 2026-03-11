package com.example.practical10;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

// Practical 10: Media API - Play/Pause an MP3 file
// Steps:
//   1. Create folder: res/raw/
//   2. Download an mp3 file, rename it to sample_audio.mp3
//   3. Drag and drop it into the res/raw/ folder
public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    Button btnPlay, btnPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.sample_audio);
        btnPlay  = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);

        btnPlay.setOnClickListener(v -> {
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
            }
        });

        btnPause.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
