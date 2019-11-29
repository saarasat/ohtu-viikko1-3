package statistics;
import statistics.matcher.*;

public class QueryBuilder {

    Matcher matcher;

    public QueryBuilder() {
        matcher = new All();
    }

    public Matcher build() {
        Matcher match = matcher;
        matcher = new All();
        return match;
    }

    public Matcher oneOf(Matcher m1, Matcher m2) {
        return new Or(m1, m2);
    }

    public QueryBuilder not(Matcher... matchers) {
        this.matcher = new And(new Not(matchers), matcher);
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.matcher = new And(new HasAtLeast(value, category), matcher);
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.matcher = new And( new HasFewerThan(value, category), matcher);
        return this;
    }

    public QueryBuilder playsIn(String team) {
        this.matcher = new And(new PlaysIn(team), matcher);
        return this;
    }
}