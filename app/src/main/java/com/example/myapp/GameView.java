package com.example.myapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Handler;
import android.provider.SyncStateContract;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GameView extends View {

    public static Car car;
    public static Obstacle obs1,obs2;
    public static int sumAbs = 10;
    ArrayList<Bitmap> arrObs = new ArrayList<>();
    private Handler handler;
    private Runnable r;
    public static int lives = 3;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initCar();
        initObstacle1();
        initObstacle2();




        handler = new Handler();
        r = new Runnable() {
            @Override
            public void run() {
                invalidate();

            }
        };
    }


    public void initObstacle1() {
        obs1 = new Obstacle();
        obs1.setWidth(200 * Constants.SCREEN_WIDTH / 1080);
        obs1.setHeight(200 * Constants.SCREEN_HEIGHT / 1920);
        obs1.setX(Constants.randomX()/2 + Constants.SCREEN_WIDTH /2);
        obs1.setY(100 * Constants.SCREEN_HEIGHT / 1920);
        obs1.setSpeed();
        arrObs.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.rock));
        obs1.setArrBms(arrObs);


    }
    public void initObstacle2() {
        obs2 = new Obstacle();
        obs2.setWidth(200 * Constants.SCREEN_WIDTH / 1080);
        obs2.setHeight(200 * Constants.SCREEN_HEIGHT / 1920);
        obs2.setX(Constants.randomX()/2);
        obs2.setY(100 * Constants.SCREEN_HEIGHT / 1920);
        obs2.setSpeed();
        arrObs.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.rock));
        obs2.setArrBms(arrObs);

    }

    private void initCar() {
        car = new Car();
        car.setWidth(200 * Constants.SCREEN_WIDTH / 1080);
        car.setHeight(200 * Constants.SCREEN_HEIGHT / 1920);
        car.setX(Constants.SCREEN_WIDTH / 2 - car.getWidth() / 2);
        car.setY(1200 * Constants.SCREEN_HEIGHT / 1920);
        ArrayList<Bitmap> arrBms = new ArrayList<>();
        arrBms.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.audi));
        //arrBms.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.car));
        car.setArrBms(arrBms);
    }


    public void draw(Canvas canvas) {

        super.draw(canvas);
        car.draw(canvas);
        obs1.draw(canvas);
        obs2.draw(canvas);
        handler.postDelayed(r, 10);
        if((GameView.obs1.getX() >= GameView.car.getX()  && GameView.obs1.getX() <= GameView.car.getX()+GameView.car.getWidth() ||
                GameView.obs1.getX()+GameView.obs1.width >= GameView.car.getX() && GameView.obs1.getX()+GameView.obs1.width <= GameView.car.getX()+GameView.car.getWidth())&&
                (GameView.obs1.getY() >= GameView.car.getY() && GameView.obs1.getY() <= GameView.car.getY()+GameView.car.getHeight()||
                        GameView.obs1.getY()+GameView.obs1.getHeight() >= GameView.car.getY() && GameView.obs1.getY()+GameView.obs1.getHeight() <= GameView.car.getY()+GameView.car.getHeight()))
                        {
                          //lives--;
                            //if (lives == 0) {
                                obs1.stop();
                                obs2.stop();
                                Toast.makeText(getContext(),"Game Over!",Toast.LENGTH_SHORT).show();
                            //}

                        }
        if((GameView.obs2.getX() >= GameView.car.getX()  && GameView.obs2.getX() <= GameView.car.getX()+GameView.car.getWidth() ||
                GameView.obs2.getX()+GameView.obs2.width >= GameView.car.getX() && GameView.obs2.getX()+GameView.obs2.width <= GameView.car.getX()+GameView.car.getWidth())&&
                (GameView.obs2.getY() >= GameView.car.getY() && GameView.obs2.getY() <= GameView.car.getY()+GameView.car.getHeight()||
                        GameView.obs2.getY()+GameView.obs2.getHeight() >= GameView.car.getY() && GameView.obs2.getY()+GameView.obs2.getHeight() <= GameView.car.getY()+GameView.car.getHeight()))
                        {
                            //lives--;
                            //if (lives == 0) {
                                obs1.stop();
                                obs2.stop();
                                Toast.makeText(getContext(),"Game Over!",Toast.LENGTH_SHORT).show();
                            //}
                        }

    }


}