package com.example.myoncoappbeta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    /**
     * Activité vide pour mise en place de Fragment*/

    private static final String TAG = "Hello";

    //Déclaration de la base de données
    public static MyAppDatabseClass databse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Suppression de la barre d'activité pour personnalisation
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        //Déclaration de la base de données
        databse = Room.databaseBuilder(getApplicationContext(),MyAppDatabseClass.class,"database").allowMainThreadQueries().build();



        setContentView(R.layout.activity_main);


    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,"on start "+getLocalClassName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG,"on stop "+getLocalClassName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG,"on pause "+getLocalClassName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,"on resume "+getLocalClassName());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG,"on restart "+getLocalClassName());
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"on destroy "+getLocalClassName());
    }

}