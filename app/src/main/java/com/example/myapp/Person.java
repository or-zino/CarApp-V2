package com.example.myapp;

public class Person {

    String name;
    int score;
    long km;

    Person(){

    }
    Person(String name, int score, long km){

        this.name = name;
        this.score = score;
        this.km = km;
    }

    public String getName(){
        return name;
    }

    public int getScore() {
        return score;

    }

    public long getKm() {
        return km;
    }

    public void setKm(long km) {
        this.km = km;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
