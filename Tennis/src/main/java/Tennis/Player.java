package Tennis;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.List;

public class Player {
    String playerName;
    int score = 0;
    int gamesWon = 0;
    int setsWon = 0;
    String[] array = {"love", "15", "30", "40"};

    public  Player(String name){
        playerName = name;
    }
    public String getStats(){
        return (playerName + ":  Score: " + score + "  Games: " + gamesWon + " Sets: " + setsWon);
    }
    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    public String getScoreString() {
        if (score > 3){
            return "Deuce";
        }else{
            return array[score];
        }
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getSetsWon() {
        return setsWon;
    }

    public void setSetsWon(int setsWon) {
        this.setsWon = setsWon;
    }
}
