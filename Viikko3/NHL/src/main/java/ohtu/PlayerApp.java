package ohtu;

import java.util.*;

public class PlayerApp {

    private Player[] players;

    public PlayerApp(Player[] players) {
        this.players = players;
        Arrays.sort(players);
    }
    
    

    public void playersByNationality(String nationality) {
        for (Player player : players) {
            if (player.getNationality().equals(nationality)) {
                System.out.println(player);
            }
        }
    }
}