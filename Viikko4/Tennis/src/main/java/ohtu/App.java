package ohtu;

public class App {
    public static void main(String[] args) {
        TennisGame game = new TennisGame("player", "player1");
        
        System.out.println(game.getScore());

        game.wonPoint("player");
        System.out.println(game.getScore());

        game.wonPoint("player");
        System.out.println(game.getScore());

        game.wonPoint("player1");
        System.out.println(game.getScore());

        game.wonPoint("player1");
        System.out.println(game.getScore());

        game.wonPoint("player");
        System.out.println(game.getScore());

    }
}
