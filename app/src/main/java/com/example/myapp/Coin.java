package com.example.myapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Random;


public class Coin extends baseObject{

    private int speed;
    private ArrayList<Bitmap> arrBms = new ArrayList<>();
    public Coin(){

    }
    public void setSpeed(){
        int maximum = 10, minimum = 8;
        Random rn = new Random();
        int rand = minimum + rn.nextInt(maximum);
        speed =  rand;

    }
    public void stop(){
        speed = 0;
    }

    public void draw(Canvas canvas){
        this.y+=speed;
        if(getY() > Constants.SCREEN_HEIGHT){
            setY(200 * Constants.SCREEN_HEIGHT / 1920 - 300);
            setX(Constants.randomX());
            setSpeed();

        }
        canvas.drawBitmap(this.getBm(), this.x,this.y,null);
    }
    public ArrayList<Bitmap> getArrBms() {
        return arrBms;
    }

    public void setArrBms(ArrayList<Bitmap> arrBms) {
        this.arrBms = arrBms;
        for (int i=0; i< arrBms.size(); i++){
            this.arrBms.set(i, Bitmap.createScaledBitmap(this.arrBms.get(i), this.width, this.height, true ));
        }
    }


    @Override
    public Bitmap getBm() {
        return this.arrBms.get(0);
    }
}
