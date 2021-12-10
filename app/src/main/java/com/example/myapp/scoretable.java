package com.example.myapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;
import android.widget.TextView;

public class scoretable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoretable);

        TableLayout tableLayout = (TableLayout) findViewById(R.id.myTable);
        TextView name1 = (TextView) findViewById(R.id.name1);
        TextView score1 = (TextView) findViewById(R.id.score1);
        TextView km1 = (TextView) findViewById(R.id.km1);
        TextView name2 = (TextView) findViewById(R.id.name2);
        TextView score2 = (TextView) findViewById(R.id.score2);
        TextView km2 = (TextView) findViewById(R.id.km2);
        TextView name3 = (TextView) findViewById(R.id.name3);
        TextView score3 = (TextView) findViewById(R.id.score3);
        TextView km3 = (TextView) findViewById(R.id.km3);
        TextView name4 = (TextView) findViewById(R.id.name4);
        TextView score4 = (TextView) findViewById(R.id.score4);
        TextView km4 = (TextView) findViewById(R.id.km4);
        TextView name5 = (TextView) findViewById(R.id.name5);
        TextView score5 = (TextView) findViewById(R.id.score5);
        TextView km5 = (TextView) findViewById(R.id.km5);
        TextView name6 = (TextView) findViewById(R.id.name6);
        TextView score6 = (TextView) findViewById(R.id.score6);
        TextView km6 = (TextView) findViewById(R.id.km6);
        TextView name7 = (TextView) findViewById(R.id.name7);
        TextView score7 = (TextView) findViewById(R.id.score7);
        TextView km7 = (TextView) findViewById(R.id.km7);
        TextView name8 = (TextView) findViewById(R.id.name8);
        TextView score8 = (TextView) findViewById(R.id.score8);
        TextView km8 = (TextView) findViewById(R.id.km8);
        TextView name9 = (TextView) findViewById(R.id.name9);
        TextView score9 = (TextView) findViewById(R.id.score9);
        TextView km9 = (TextView) findViewById(R.id.km9);
        TextView name10 = (TextView) findViewById(R.id.name10);
        TextView score10 = (TextView) findViewById(R.id.score10);
        TextView km10 = (TextView) findViewById(R.id.km10);



        if(MainActivity2.index >= 1) {
            name1.setText(MainActivity2.person[0].getName().toString());
            km1.setText(String.valueOf(MainActivity2.person[0].getKm()));
            score1.setText(String.valueOf(MainActivity2.person[0].getScore()));
        }
        if(MainActivity2.index >= 2){
            name2.setText(MainActivity2.person[1].getName().toString());
            km2.setText(String.valueOf(MainActivity2.person[1].getKm()));
            score2.setText(String.valueOf(MainActivity2.person[1].getScore()));
        }
        if(MainActivity2.index >= 3){
            name3.setText(MainActivity2.person[2].getName().toString());
            km3.setText(String.valueOf(MainActivity2.person[2].getKm()));
            score3.setText(String.valueOf(MainActivity2.person[2].getScore()));
        }
        if(MainActivity2.index >= 4){
            name4.setText(MainActivity2.person[3].getName().toString());
            km4.setText(String.valueOf(MainActivity2.person[3].getKm()));
            score4.setText(String.valueOf(MainActivity2.person[3].getScore()));
        }
        if(MainActivity2.index >= 5){
            name5.setText(MainActivity2.person[4].getName().toString());
            km5.setText(String.valueOf(MainActivity2.person[4].getKm()));
            score5.setText(String.valueOf(MainActivity2.person[4].getScore()));
        }
        if(MainActivity2.index >= 6){
            name6.setText(MainActivity2.person[5].getName().toString());
            km6.setText(String.valueOf(MainActivity2.person[5].getKm()));
            score6.setText(String.valueOf(MainActivity2.person[5].getScore()));
        }
        if(MainActivity2.index >= 7){
            name7.setText(MainActivity2.person[6].getName().toString());
            km7.setText(String.valueOf(MainActivity2.person[6].getKm()));
            score7.setText(String.valueOf(MainActivity2.person[6].getScore()));
        }
        if(MainActivity2.index >= 8){
            name8.setText(MainActivity2.person[7].getName().toString());
            km8.setText(String.valueOf(MainActivity2.person[7].getKm()));
            score8.setText(String.valueOf(MainActivity2.person[7].getScore()));
        }
        if(MainActivity2.index >= 9){
            name9.setText(MainActivity2.person[8].getName().toString());
            km9.setText(String.valueOf(MainActivity2.person[8].getKm()));
            score9.setText(String.valueOf(MainActivity2.person[8].getScore()));
        }
        if(MainActivity2.index >= 10){
            name10.setText(MainActivity2.person[9].getName().toString());
            km10.setText(String.valueOf(MainActivity2.person[9].getKm()));
            score10.setText(String.valueOf(MainActivity2.person[9].getScore()));
        }

    }
}