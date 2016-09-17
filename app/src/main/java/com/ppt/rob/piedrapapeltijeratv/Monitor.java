package com.ppt.rob.piedrapapeltijeratv;

/**
 * Created by Huberto on 16/09/2016.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.ppt.rob.piedrapapeltijeratv.Vistas.Principal;

public class Monitor extends BroadcastReceiver{
    public void onReceive(Context context,Intent intent) {
        Intent i = new Intent(context, Principal.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}