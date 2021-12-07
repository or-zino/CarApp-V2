package com.example.myapp;
import android.support.v7.app.AppCompatActivity;


import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.Chronometer;
import android.os.Bundle;

public class MainActivityNoButton extends AppCompatActivity {

    private Accelerometer accelerometer;
    private Gyroscope gyroscope;
    public static Chronometer chronometer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        Constants.SCREEN_WIDTH = dm.widthPixels;
        Constants.SCREEN_HEIGHT = dm.heightPixels;
        setContentView(R.layout.activity_main_no_button);

        chronometer2 = findViewById(R.id.chronometer2);
        chronometer2.start();


        accelerometer = new Accelerometer(this);
        gyroscope = new Gyroscope(this);

        accelerometer.setListener(new Accelerometer.Listener() {
            @Override
            public void onTranslation(float tx, float ty, float tz) {
                if(tx > 1.0f) {
                    if(GameView.car.getX() > Constants.SCREEN_WIDTH/8){
                        GameView.car.setX((GameView.car.getX())-(Constants.SCREEN_WIDTH/6));
                    }

                }
                else if(tx < -1.0f){
                    if(!(GameView.car.getX() > (Constants.SCREEN_WIDTH)-Constants.SCREEN_WIDTH/4)) {
                        GameView.car.setX(((GameView.car.getX())) + (Constants.SCREEN_WIDTH / 6));
                    }
                }
            }
        });

        gyroscope.setListener(new Gyroscope.Listener() {
            @Override
            public void onRotation(float rx, float ry, float rz) {
                if(rz > 1.0f){
                    if(GameView.car.getX() > Constants.SCREEN_WIDTH/8){
                        GameView.car.setX((GameView.car.getX())-(Constants.SCREEN_WIDTH/6));
                    }
                    else if(rx < -1.0f){
                        if(!(GameView.car.getX() > (Constants.SCREEN_WIDTH)-Constants.SCREEN_WIDTH/4)) {
                            GameView.car.setX(((GameView.car.getX())) + (Constants.SCREEN_WIDTH / 6));
                        }
                    }
                }
            }
        });


    }
}