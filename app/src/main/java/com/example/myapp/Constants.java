package com.example.myapp;

import java.util.Random;

public class Constants {
    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;

    public static int randomX(){
        Random r = new Random();
        return r.nextInt(Constants.SCREEN_WIDTH - 200);
    }

}
