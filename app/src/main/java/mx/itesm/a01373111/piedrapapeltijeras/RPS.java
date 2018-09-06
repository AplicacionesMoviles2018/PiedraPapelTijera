package mx.itesm.a01373111.piedrapapeltijeras;

import java.util.Random;

public class RPS {

    private int scorePlayer, scoreCom;

    public RPS(){
        initializeScore();
    }

    private void initializeScore() {
        scorePlayer = 0;
        scoreCom = 0;
    }

    public String haveWinner(){
        if(scorePlayer==5){
            return "Player";
        } else if(scoreCom==5){
            return "Computer";
        } return "none";
    }

    public String play(String movePlayer, String moveCom){
        String result = "";
        if(moveCom.equals(movePlayer)){
            return "draw";
        }
        switch (movePlayer){
            case "rock":
                result = moveCom.equals("paper")?"lost":"won";
                if(result.equals("won")){
                    scorePlayer++;
                } else
                    scoreCom++;
                break;
            case "paper":
                result = moveCom.equals("scissors")?"lost":"won";
                if(movePlayer.equals("scissors")){
                    scorePlayer++;
                } else
                    scoreCom++;
                break;
            case "scissors":
                result = moveCom.equals("rock")?"lost":"won";
                if(movePlayer.equals("rock")){
                    scorePlayer++;
                } else
                    scoreCom++;
                break;
        }
        return result;
    }

    public String playComputer(){
        int random = new Random().nextInt(3);
        System.out.println(random+"************************");
        String move = "";
        switch (random){
            case 0:
                move = "rock";
                break;
            case 1:
                move = "paper";
                break;
            case 2:
                move = "scissors";
                break;
        }
        return move;
    }

    public int getScorePlayer() {
        return scorePlayer;
    }

    public void setScorePlayer(int scorePlayer) {
        this.scorePlayer = scorePlayer;
    }

    public int getScoreCom() {
        return scoreCom;
    }

    public void setScoreCom(int scoreCom) {
        this.scoreCom = scoreCom;
    }

}
