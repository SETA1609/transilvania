package com.brightstraining.javafxgame.model;

public class ScoreBoard {
    public int score=0;
    public String scoreTitle="Score: ";
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int update(){
        return score++;
    }

    @Override
    public String toString() {
        return "Score:" + score ;
    }
}
