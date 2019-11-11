
package ohtu;

import java.util.*;

public class Player implements Comparable<Player> {
    private String name;
    private String nationality;
    private String team;
    private int goals;
    private int assists;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeam() {
        return team;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getGoals() {
        return goals;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getAssists() {
        return assists;
    }
    
    public int getScore() {
        return assists+goals;
    }
    
    @Override
    public int compareTo(Player another) {        
        return another.getScore() - this.getScore();
    }
    
    

    @Override
    public String toString() {
        return String.format("%-20s %-5s %2d + %2d = %3d", this.name, this.nationality, this.goals, this.assists, this.assists+this.goals);
    }
      
}
