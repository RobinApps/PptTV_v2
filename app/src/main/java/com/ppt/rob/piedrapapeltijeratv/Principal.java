package com.ppt.rob.piedrapapeltijeratv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Principal extends AppCompatActivity {
//En esta Activity mostra un video full pantalla vertical, y en la parte inferior aparesca el código generado aleatoriamente despues de cada juego
    //y que al momento de recibir una conexión de algun jugador cambie de activity para iniciar el juego
    //tambien create el servicio para que inicie la app al momento de iniciar el dispositivo movil
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }
}
