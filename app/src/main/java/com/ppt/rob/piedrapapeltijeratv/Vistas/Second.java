package com.ppt.rob.piedrapapeltijeratv.Vistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ppt.rob.piedrapapeltijeratv.R;
import com.ppt.rob.piedrapapeltijeratv.libre.FirebaseHelper;

public class Second extends AppCompatActivity {

    FirebaseHelper helper = FirebaseHelper.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        helper.getDataReference().child("play").setValue("0");
        helper.getDataReference().child("codigo").setValue("123456");

    }
}
