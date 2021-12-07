package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity2 extends AppCompatActivity {


    private Button btnPlay;
    private Switch sw;
    private Button btnScore;
    private boolean buttonOff = false;
    public EditText editText;
    public static Person[] person = new Person[10];
    public static int index = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Intent intent = new Intent(this, MainActivity.class);
        //Intent intent2 = new Intent(this, com.example.cargamev2.MainActivityNoButton.class);
        //Intent intent3 = new Intent(this, scoretable.class);

        sw = (Switch)findViewById(R.id.switch1);
        btnPlay = (Button) findViewById(R.id.play);
        btnScore = (Button) findViewById(R.id.scoreTable);
        editText = (EditText) findViewById(R.id.TextBox);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person[index] = new Person();
                person[index].setName(editText.getText().toString());



                if(buttonOff){
                    //startActivity(intent2);
                    //Log.d("TAG!!!","PLAY with ON");
                }else{
                    //startActivity(intent);
                    //Log.d("TAG!!!","PLAY with Off");
                }
            }

        });

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked) {
                    buttonOff = true;
                    //Log.d("Tag!!!!!!! ","switch On");
                }
                else {
                    buttonOff = false;
                    //Log.d("Tag!!!!!!! ", "switch Off");
                }
            }
        });


        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startActivity(intent3);

            }
        });


    }
}