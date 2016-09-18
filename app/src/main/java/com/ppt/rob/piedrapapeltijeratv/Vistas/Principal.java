package com.ppt.rob.piedrapapeltijeratv.Vistas;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.VideoView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.ppt.rob.piedrapapeltijeratv.R;
import com.ppt.rob.piedrapapeltijeratv.libre.FirebaseHelper;

public class Principal extends AppCompatActivity {
    Principal thisActivity;
    VideoView videoView;
    FirebaseHelper helper = FirebaseHelper.getInstance();

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

        final DatabaseReference h=helper.getPlay();
        String uriPath = "android.resource://"+getPackageName()+"/raw/video";
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                if(!thisActivity.isFinishing()){
                    videoView.start();
                }
            }
        });
        videoView.start();
        //Firebase
        h.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue().toString().equals("1")){
                Intent i = new Intent(thisActivity, Second.class);
                startActivity(i);
                    finish();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }
}
