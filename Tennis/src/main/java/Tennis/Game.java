package Tennis;

import java.util.Random;

public class Game {

    Player player1;
    Player player2;

    public Game(Player one, Player two){
        player1 = one;
        player2 = two;
    }

    public Player playPoint(){

        int i = coinFlip();
        if(i == 1) {
            player1.setScore(player1.getScore() + 1);
            return player1;
        }else {
            player2.setScore(player2.getScore() + 1);
            return player2;
        }

    }

    public int coinFlip(){
        Random r = new Random();
        int i = r.nextInt(2);
        return i;
    }

    public Player playGame(){

        playPoint();
        while(!gameWinner()){
            playPoint();
            if (gameWinner()){
                break;
            }
        }

    return getGameWinner();
    }

    public Boolean gameWinner(){

        if(player1.getScore() >= 4 && player1.getScore() + 2 > player2.getScore()) {
            return true;
        }else if(player2.getScore() >= 4 && player2.getScore() + 2 > player1.getScore()){
            return true;
        }else {
            return false;
        }

    }

    public Player getGameWinner(){

        if (player1.getScore() > player2.getScore()){
            player1.setGamesWon(player1.getGamesWon() + 1);
            player1.setScore(0);
            return player1;
        }else{
            player2.setGamesWon(player2.getGamesWon() + 1);
            player2.setScore(0);
            return player2;
        }

    }

    public Player playSet() {
        playGame();
        while (!setWinner()) {
            playGame();
            if (setWinner()) {
                break;
            }
        }
        return getSetWinner();
    }

    public Boolean setWinner(){
        if(player1.gamesWon > 5 && player1.gamesWon + 2 > player2.gamesWon){
            return true;
        }else if(player2.gamesWon >5 && player2.gamesWon + 2 > player1.gamesWon){
            return true;
        }else{
            return false;
        }
    }

    public Player getSetWinner(){
        if(player1.gamesWon > player2.gamesWon){
            player1.setSetsWon(player1.setsWon + 1);
            return player1;
        }else{
            player2.setSetsWon(player2.setsWon + 1);
            return player2;
        }

    }
}
