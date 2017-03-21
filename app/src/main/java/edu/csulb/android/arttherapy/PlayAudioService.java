package edu.csulb.android.arttherapy;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class PlayAudioService extends Service {
    public static boolean boolIsServiceCreated = false;
    MediaPlayer player;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        boolIsServiceCreated = true;
        player = MediaPlayer.create(getApplicationContext(), R.raw.eraser);
    }
    @Override
    public void onDestroy() {
        player.stop();
        player.release();
        player = null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        player.setLooping(false);
        // We want this service to continue running until it is explicitly
        // stopped, so return sticky.
        return START_STICKY;
    }

}
