package com.ppt.rob.piedrapapeltijeratv.libre;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Rob on 17/09/2016.
 */
public class FirebaseHelper {
    private DatabaseReference dataReference;

    private final static String USERS_PATH = "users";
    private final static String COD_PATH= "codigo";
    private final static String PLAY_PATH= "play";
    private static int cod=0;
   



    private static class SingletonHolder { //tener una sola instancia en toda la aplicacion**
        private static final FirebaseHelper INSTANCE = new FirebaseHelper();
    }

    public static FirebaseHelper getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public FirebaseHelper(){
        dataReference = FirebaseDatabase.getInstance().getReference();
    }

    public DatabaseReference getDataReference() {
        return dataReference;
    }

    public DatabaseReference getCodActual(){
        DatabaseReference codReference = null;
        //  final int cod = 0;
        //  final boolean listo=false;
        codReference = dataReference.getRoot().child(COD_PATH);


        return codReference;
    }

    public DatabaseReference getPlay() {
        DatabaseReference Reference = null;
        Reference = dataReference.getRoot().child(PLAY_PATH);


        return Reference;
    }
}
