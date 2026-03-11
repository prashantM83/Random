package com.example.slip3service;

import android.app.Service;
import android.content.Intent;
import android.media.RingtoneManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import androidx.annotation.Nullable;

// Program 1: Background Service to play ringtone/music
// Uses the default device ringtone — no external file needed.
// To use a custom file: place sample_music.mp3 in res/raw/ and use
//   player = MediaPlayer.create(this, R.raw.sample_music);
public class MusicService extends Service {

    MediaPlayer player;

    @Override
    public void onCreate() {
        super.onCreate();
        // Use default ringtone (works without any res/raw file)
        Uri ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        player = MediaPlayer.create(this, ringtoneUri);
        if (player != null) player.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (player != null && !player.isPlaying()) player.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.stop();
            player.release();
            player = null;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
