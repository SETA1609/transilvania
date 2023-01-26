package com.brightstraining.javafxgame.model;

public class ScoreBoard {
    public static double score=0;
    public String scoreTitle="Score: ";
    public double getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double update(){
        return score++;
    }

    @Override
    public String toString() {
        return "Score:" + (int)score ;
    }
}
