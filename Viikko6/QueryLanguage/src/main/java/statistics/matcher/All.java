package statistics.matcher;

import statistics.Player;

public class All implements Matcher {
    
    Matcher matcher;

    public All() {
    }

    @Override
    public boolean matches(Player p) {
        if (p.getTeam().length() > 0) return true;
        return false;
    }
}
