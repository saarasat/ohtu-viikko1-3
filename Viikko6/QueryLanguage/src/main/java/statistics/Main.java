package statistics;

import statistics.matcher.*;
import statistics.QueryBuilder;

public class Main {
    public static void main(String[] args) {
        // seuraavassa osoitteessa 27.11.2019 päivitetyt tilastot
        String url = "https://nhl27112019.herokuapp.com/players.txt";
        // ajan tasalla olevat tilastot osoitteessa
        // "https://nhlstatisticsforohtu.herokuapp.com/players.txt"

        Statistics stats = new Statistics(new PlayerReaderImpl(url));

        QueryBuilder query = new QueryBuilder();

        Matcher v = query.hasFewerThan(5, "goals").playsIn("NYR").hasAtLeast(3, "assists").build();

        Matcher m1 = query.playsIn("PHI")
                .hasAtLeast(10, "assists")
                .hasFewerThan(8, "goals").build();

        Matcher m2 = query.playsIn("EDM")
                .hasAtLeast(20, "points").build();

        Matcher m = query.oneOf(m1, m2);

        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
          
    }
}
