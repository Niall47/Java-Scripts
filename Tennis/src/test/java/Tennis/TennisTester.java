package Tennis;

import org.junit.Before;
import org.junit.*;

public class TennisTester {

    Player player1;
    Player player2;
    Game game;

    @Before
    public void beforeTest(){
        player1 = new Player("Niall");
        player2 = new Player("James");
        game = new Game(player1, player2);
    }

    @Test
    public void allZero(){
        Assert.assertTrue(player1.getScore() == 0);
        Assert.assertTrue(player2.getScore() == 0);
    }

    @Test
    public void pointsAwarded(){
        Player winner = game.playPoint();
        Assert.assertTrue(winner.getScore() == 1);
    }
}