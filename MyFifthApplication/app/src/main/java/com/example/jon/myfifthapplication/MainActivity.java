package com.example.jon.myfifthapplication;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class MainActivity extends Activity implements View.OnClickListener {

    private MusicService musicService;
    private TextView playingState;
    private TextView playingTime;
    private SeekBar seekBar;
    private Button playButton;
    private Button stopButton;
    private Button quitButton;

    private SimpleDateFormat time = new SimpleDateFormat("m:ss");

    Handler handler = new Handler();

    Runnable r = new Runnable() {
        @Override
        public void run() {
            try {
                if (musicService.mp.isPlaying()) {
                    playingState.setText("Playing");
                } else {
                    playingState.setText("Pausing");
                }
                playingTime.setText(time.format(musicService.mp.getCurrentPosition()) + "/" + time.format(musicService.mp.getDuration()));
                seekBar.setMax(musicService.mp.getDuration());
                seekBar.setProgress(musicService.mp.getCurrentPosition());
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser) {
                            musicService.mp.seekTo(seekBar.getProgress());
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                handler.postDelayed(r, 100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            musicService = ((MusicService.MyBinder) service).getService();
            if (musicService == null) {
                Log.e("TAG", "music null");
            }
            handler.post(r);
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    private void bindServiceConnection() {
        Intent intent = new Intent(MainActivity.this, MusicService.class);
        startService(intent);
        bindService(intent, sc, this.BIND_AUTO_CREATE);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.playButton:
                musicService.playOrPause();
                break;
            case R.id.stopButton:
                musicService.stop();
                seekBar.setProgress(0);
                break;
            case R.id.quitButton:
                handler.removeCallbacks(r);
                unbindService(sc);
                try {
                    System.exit(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("TAG", "create");
        bindServiceConnection();
        playingState = (TextView)findViewById(R.id.playingState);
        playingTime = (TextView)findViewById(R.id.playingTime);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        playButton = (Button)findViewById(R.id.playButton);
        stopButton = (Button)findViewById(R.id.stopButton);
        quitButton = (Button)findViewById(R.id.quitButton);
        playButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
        quitButton.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        Log.e("TAG", "destroy");
        unbindService(sc);
        super.onDestroy();
    }
}
