package com.ppt.rob.piedrapapeltijeratv;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

public class Principal extends AppCompatActivity {
    Principal thisActivity;
    VideoView videoView;
//En esta Activity mostra un video full pantalla vertical, y en la parte inferior aparesca el código generado aleatoriamente despues de cada juego
    //y que al momento de recibir una conexión de algun jugador cambie de activity para iniciar el juego
    //tambien create el servicio para que inicie la app al momento de iniciar el dispositivo movil.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        thisActivity = this;
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // ----------------------Hide code
        try{getActionBar().hide();}catch(Exception e){}
        // ----------------------/Hide code
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        videoView = (VideoView)findViewById(R.id.videoView);

        String uriPath = "android.resource://"+getPackageName()+"/raw/video";
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                if(!thisActivity.isFinishing()){
                    /*Intent intent = new Intent(thisActivity, Main.class);
                    thisActivity.startActivity(intent);
                    thisActivity.finish();*/
                    videoView.start();
                }
            }
        });
        videoView.start();

    }
}
