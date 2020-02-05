package Tennis;

public class Main {
    public static void main(String[] args) {

    Player player1 = new Player("Niall");
    Player player2 = new Player("James");
    Game game = new Game(player1, player2);

    Player winner = game.playSet();
    System.out.println(winner.getStats());
    System.out.println(winner.getScoreString());
    }
}
