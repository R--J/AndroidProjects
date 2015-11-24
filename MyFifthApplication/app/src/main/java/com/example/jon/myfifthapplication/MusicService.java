package com.example.jon.myfifthapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MusicService extends Service {

    public MediaPlayer mp;

    public void initMp() {
        mp = new MediaPlayer();
        try {
            mp.setDataSource("/data/You.mp3");
            Log.e("init", "ok");
            mp.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MusicService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("Tag", "service create");
        initMp();
    }

    public class MyBinder extends Binder {
        MusicService getService() {
            return MusicService.this;
        }
    }

    public final IBinder binder = new MyBinder();

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return binder;
    }

    public void playOrPause() {
        if (mp.isPlaying()) {
            mp.pause();
        } else {
            mp.start();
        }
    }

    public void stop() {
        if (mp != null) {
            mp.stop();
            try {
                mp.prepare();
                mp.seekTo(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy() {
        mp.stop();
        mp.release();
        super.onDestroy();
    }
}
