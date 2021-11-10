package com.example.myapp;


import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bl, br;

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
        MediaPlayer music = MediaPlayer.create(MainActivity.this, R.raw.music);
        music.start();






        bl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(GameView.car.getX() > Constants.SCREEN_WIDTH/3){
            GameView.car.setX((GameView.car.getX())-(Constants.SCREEN_WIDTH/3));
                }

            }
        });

        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(GameView.car.getX() > Constants.SCREEN_WIDTH/2)) {
                    GameView.car.setX(((GameView.car.getX())) + (Constants.SCREEN_WIDTH / 3));
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