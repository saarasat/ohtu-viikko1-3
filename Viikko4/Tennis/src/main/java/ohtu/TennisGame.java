package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            player1Score += 1;
        else
            player2Score += 1;
    }
    
    public String getOnePlayerScore(int playerScore) {
        switch (playerScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2: 
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "All";
        }
    }
    
    public String getTiedScore() {
        switch (player1Score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }
    
    public String checkWhoWonOrHasTheAdvantage() {
        int whoHasAdvantage = player1Score-player2Score;
        
        //Checking the advantage
        if (whoHasAdvantage == 1) return "Advantage " + player1Name;
        else if (whoHasAdvantage == -1) return "Advantage " + player2Name;
        
        //If advantage more than 2 sets, determine the winner 
        else if (whoHasAdvantage >= 2) return "Win for " + player1Name;
        else return "Win for " + player2Name;
    }
    
    public String getScore() {
        if (player1Score == player2Score) return getTiedScore();
        else if (player1Score>=4 || player2Score>=4) return checkWhoWonOrHasTheAdvantage();
        else return getOnePlayerScore(player1Score) + "-" + getOnePlayerScore(player2Score);    
    }
}