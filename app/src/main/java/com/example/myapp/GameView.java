package com.example.myapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.SyncStateContract;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GameView extends View {

    public static Car car;
    public static Obstacle obs1, obs2;
    public static Coin coin1, coin2;
    public static Chronometer chronometer;
    ArrayList<Bitmap> arrObs = new ArrayList<>();
    ArrayList<Bitmap> arrCoins = new ArrayList<>();
    ArrayList<Bitmap> arrCoins2 = new ArrayList<>();
    private Handler handler, diamondHand;
    private Runnable r, diamondR;
    public int lives = 3;
    public int score = 0;
    public long time;



    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initCar();
        initObstacle1();
        initObstacle2();
        initCoin1();
        initCoin2();

        PlaySound.SoundPlayer(context,R.raw.music);
        PlaySound.player.start();
        PlaySound.CrashPlayer(context,R.raw.crash);




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
        obs1.setWidth(100 * Constants.SCREEN_WIDTH / 1080);
        obs1.setHeight(100 * Constants.SCREEN_HEIGHT / 1920);
        obs1.setX(Constants.randomX() / 2 + Constants.SCREEN_WIDTH / 2);
        obs1.setY(100 * Constants.SCREEN_HEIGHT / 1920);
        obs1.setSpeed();
        arrObs.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.rock));
        obs1.setArrBms(arrObs);


    }
    public void initObstacle2() {
        obs2 = new Obstacle();
        obs2.setWidth(100 * Constants.SCREEN_WIDTH / 1080);
        obs2.setHeight(100 * Constants.SCREEN_HEIGHT / 1920);
        obs2.setX(Constants.randomX() / 2);
        obs2.setY(100 * Constants.SCREEN_HEIGHT / 1920);
        obs2.setSpeed();
        arrObs.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.rock));
        obs2.setArrBms(arrObs);

    }

    private void initCar() {
        car = new Car();
        car.setWidth(120 * Constants.SCREEN_WIDTH / 1080);
        car.setHeight(120 * Constants.SCREEN_HEIGHT / 1920);
        car.setX(Constants.SCREEN_WIDTH / 2 - car.getWidth() / 2);
        car.setY(1200 * Constants.SCREEN_HEIGHT / 1920);
        ArrayList<Bitmap> arrBms = new ArrayList<>();
        arrBms.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.audi));
        //arrBms.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.coin));
        car.setArrBms(arrBms);
    }

    public void initCoin1(){
        coin1 = new Coin();
        coin1.setWidth(100 * Constants.SCREEN_WIDTH / 1080);
        coin1.setHeight(100 * Constants.SCREEN_HEIGHT / 1920);
        coin1.setX(Constants.randomX() / 2 + Constants.SCREEN_WIDTH / 2);
        coin1.setY(100 * Constants.SCREEN_HEIGHT / 1920);
        coin1.setSpeed();
        arrCoins.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.coin));
        arrCoins.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.coin2));
        coin1.setArrBms(arrCoins);
    }


    public void initCoin2(){

        coin2 = new Coin();
        coin2.setWidth(100 * Constants.SCREEN_WIDTH / 1080);
        coin2.setHeight(100 * Constants.SCREEN_HEIGHT / 1920);
        coin2.setX(Constants.randomX() / 2 + Constants.SCREEN_WIDTH / 2);
        coin2.setY(100 * Constants.SCREEN_HEIGHT / 1920);
        coin2.setSpeed();
        arrCoins2.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.coin));
        arrCoins2.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.coin2));
        coin2.setArrBms(arrCoins2);

    }


    public void draw(Canvas canvas) {

        super.draw(canvas);
        car.draw(canvas);
        obs1.draw(canvas);
        obs2.draw(canvas);
        coin1.draw(canvas);
        coin2.draw(canvas);


        handler.postDelayed(r, 10);




        if ((GameView.obs1.getX() >= GameView.car.getX() && GameView.obs1.getX() <= GameView.car.getX() + GameView.car.getWidth() ||
                GameView.obs1.getX() + GameView.obs1.width >= GameView.car.getX() && GameView.obs1.getX() + GameView.obs1.width <= GameView.car.getX() + GameView.car.getWidth()) &&
                (GameView.obs1.getY() >= GameView.car.getY() && GameView.obs1.getY() <= GameView.car.getY() + GameView.car.getHeight() ||
                        GameView.obs1.getY() + GameView.obs1.getHeight() >= GameView.car.getY() && GameView.obs1.getY() + GameView.obs1.getHeight() <= GameView.car.getY() + GameView.car.getHeight())) {
            obs1.setX(Constants.randomX() / 2 + Constants.SCREEN_WIDTH / 2);
            obs1.setY(100 * Constants.SCREEN_HEIGHT / 1920);

            if(MainActivity.bheart1 != null) {
                MainActivity.explode.setX(car.getX());
                MainActivity.explode.setY(car.getY()-80);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        MainActivity.explode.setX(2000);
                    }
                }, 250);
            }
            if(MainActivityNoButton.explode2 != null) {
                MainActivityNoButton.explode2.setX(car.getX());
                MainActivityNoButton.explode2.setY(car.getY()-80);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        MainActivityNoButton.explode2.setX(2000);
                    }
                }, 250);
            }
            PlaySound.playerCrash.start();


            lives = lives - 1;
            if(lives == 2){
                if(MainActivity.bheart1 != null){
                    Log.d("TAG", " "+lives);
                    MainActivity.bheart1.setX(1500);
                }if(MainActivityNoButton.nheart1 != null)  {
                    MainActivityNoButton.nheart1.setX(1500);
                }
            }
            if(lives == 1){
                if(MainActivity.bheart2 != null) {
                    MainActivity.bheart2.setX(1600);
                    Log.d("TAG", " "+lives);
                }if(MainActivityNoButton.nheart2 != null)  {
                    MainActivityNoButton.nheart2.setX(1600);
                }
            }
            if (lives <= 0) {
                if(MainActivity.bheart3 != null) {
                    MainActivity.bheart3.setX(1700);
                }if(MainActivityNoButton.nheart3 != null)  {
                    MainActivityNoButton.nheart3.setX(1700);
                }
                endGame();
            }

        }
        if ((GameView.obs2.getX() >= GameView.car.getX() && GameView.obs2.getX() <= GameView.car.getX() + GameView.car.getWidth() ||
                GameView.obs2.getX() + GameView.obs2.width >= GameView.car.getX() && GameView.obs2.getX() + GameView.obs2.width <= GameView.car.getX() + GameView.car.getWidth()) &&
                (GameView.obs2.getY() >= GameView.car.getY() && GameView.obs2.getY() <= GameView.car.getY() + GameView.car.getHeight() ||
                        GameView.obs2.getY() + GameView.obs2.getHeight() >= GameView.car.getY() && GameView.obs2.getY() + GameView.obs2.getHeight() <= GameView.car.getY() + GameView.car.getHeight())) {
            obs2.setX(Constants.randomX() / 2 + Constants.SCREEN_WIDTH / 2);
            obs2.setY(100 * Constants.SCREEN_HEIGHT / 1920);

            if(MainActivity.explode != null) {
                MainActivity.explode.setX(car.getX());
                MainActivity.explode.setY(car.getY()-80);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        MainActivity.explode.setX(2000);
                    }
                }, 250);
            }
            if(MainActivityNoButton.explode2 != null) {
                MainActivityNoButton.explode2.setX(car.getX());
                MainActivityNoButton.explode2.setY(car.getY()-80);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        MainActivityNoButton.explode2.setX(2000);
                    }
                }, 250);
            }

            PlaySound.playerCrash.start();
            lives = lives - 1;
            if(lives == 2){
                if(MainActivity.bheart1 != null){
                MainActivity.bheart1.setX(1500);
                }if(MainActivityNoButton.nheart1 != null)  {
                    MainActivityNoButton.nheart1.setX(1500);
                }
            }
            if(lives == 1){
                if(MainActivity.bheart2 != null) {
                    MainActivity.bheart2.setX(1600);
                    Log.d("TAG", " "+lives);
                }if(MainActivityNoButton.nheart2 != null)  {
                    MainActivityNoButton.nheart2.setX(1600);
                }
            }
            if (lives <= 0) {
                if(MainActivity.bheart3 != null) {
                    MainActivity.bheart3.setX(1700);
                }if(MainActivityNoButton.nheart3 != null)  {
                    MainActivityNoButton.nheart3.setX(1700);
                }
                endGame();
            }

        }


        if ((GameView.coin1.getX() >= GameView.car.getX() && GameView.coin1.getX() <= GameView.car.getX() + GameView.car.getWidth() ||
                GameView.coin1.getX() + GameView.coin1.width >= GameView.car.getX() && GameView.coin1.getX() + GameView.coin1.width <= GameView.car.getX() + GameView.car.getWidth()) &&
                (GameView.coin1.getY() >= GameView.car.getY() && GameView.coin1.getY() <= GameView.car.getY() + GameView.car.getHeight() ||
                        GameView.coin1.getY() + GameView.coin1.getHeight() >= GameView.car.getY() && GameView.coin1.getY() + GameView.coin1.getHeight() <= GameView.car.getY() + GameView.car.getHeight())) {
            coin1.setX(Constants.randomX() / 2 + Constants.SCREEN_WIDTH / 2);
            coin1.setY(100 * Constants.SCREEN_HEIGHT / 1920);
            score++;
            if(MainActivity.coinCounter1 != null){
                MainActivity.coinCounter1.setText(String.valueOf(score));
            }
            if(MainActivityNoButton.coinCounter2 != null){
                MainActivityNoButton.coinCounter2.setText(String.valueOf(score));
            }

        }


        if ((GameView.coin2.getX() >= GameView.car.getX() && GameView.coin2.getX() <= GameView.car.getX() + GameView.car.getWidth() ||
                GameView.coin2.getX() + GameView.coin2.width >= GameView.car.getX() && GameView.coin2.getX() + GameView.coin2.width <= GameView.car.getX() + GameView.car.getWidth()) &&
                (GameView.coin2.getY() >= GameView.car.getY() && GameView.coin2.getY() <= GameView.car.getY() + GameView.car.getHeight() ||
                        GameView.coin2.getY() + GameView.coin2.getHeight() >= GameView.car.getY() && GameView.coin2.getY() + GameView.coin2.getHeight() <= GameView.car.getY() + GameView.car.getHeight())) {

            coin2.setX(Constants.randomX() / 2 + Constants.SCREEN_WIDTH / 2);
            coin2.setY(100 * Constants.SCREEN_HEIGHT / 1920);
            score++;
            if(MainActivity.coinCounter1 != null){
                MainActivity.coinCounter1.setText(String.valueOf(score));
            }
            if(MainActivityNoButton.coinCounter2 != null){
                MainActivityNoButton.coinCounter2.setText(String.valueOf(score));
            }

        }
    }
        public void endGame() {
            PlaySound.playerCrash.start();
            coin1.stop();
            coin2.stop();
            obs1.stop();
            obs2.stop();
            Toast t = Toast.makeText(getContext(), "Game Over! score: " + score, Toast.LENGTH_SHORT);
            t.show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    t.cancel();
                }
            }, 2000);

            chronometer.stop();
            time = (SystemClock.elapsedRealtime() - chronometer.getBase()); //in milsec
            PlaySound.player.release();
            MainActivity2.person[MainActivity2.index].setKm(this.time);
            MainActivity2.person[MainActivity2.index].setScore(this.score);
            MainActivity2.index++;

        }


}