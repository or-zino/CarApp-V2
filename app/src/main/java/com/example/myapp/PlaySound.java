package com.example.myapp;

import android.content.Context;
import android.media.MediaPlayer;

public class PlaySound {

    public static MediaPlayer player;
    public static MediaPlayer playerCrash;
    public static void SoundPlayer(Context ctx, int raw_id){

        player = MediaPlayer.create(ctx, raw_id);
        player.setLooping(false);
        player.setVolume((float) 0.3, (float) 0.3);


    }
    public static void CrashPlayer(Context ctx, int raw_id){

        playerCrash = MediaPlayer.create(ctx, raw_id);
        playerCrash.setLooping(false);
        playerCrash.setVolume(100,100);


    }
}
