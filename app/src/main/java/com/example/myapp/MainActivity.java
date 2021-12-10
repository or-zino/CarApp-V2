package com.example.myapp;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button bl, br;
    public static ImageView bheart1, bheart2, bheart3;
    public static TextView coinCounter1;
    public static ImageView explode;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        Constants.SCREEN_WIDTH = dm.widthPixels;
        Constants.SCREEN_HEIGHT = dm.heightPixels;
        setContentView(R.layout.activity_main);
        bl = (Button)findViewById(R.id.btnL);
        br = (Button)findViewById(R.id.btnR);
        GameView.chronometer = findViewById(R.id.chronometer);
        GameView.chronometer.start();
        bheart1 = (ImageView) findViewById(R.id.bheart1);
        bheart2 = (ImageView) findViewById(R.id.bheart2);
        bheart3 = (ImageView) findViewById(R.id.bheart3);
        coinCounter1 = (TextView) findViewById(R.id.coinCounter1);
        explode = (ImageView) findViewById(R.id.boom1);
        explode.setX(2000);



        bl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(GameView.car.getX() > Constants.SCREEN_WIDTH/8){
                    GameView.car.setX((GameView.car.getX())-(Constants.SCREEN_WIDTH/6));
                }

            }
        });

        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(GameView.car.getX() > (Constants.SCREEN_WIDTH)-Constants.SCREEN_WIDTH/4)) {
                    GameView.car.setX(((GameView.car.getX())) + (Constants.SCREEN_WIDTH / 6));
                }

            }
        });



//        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, GameActivity.class));
//
//            }
//        });
    }


}