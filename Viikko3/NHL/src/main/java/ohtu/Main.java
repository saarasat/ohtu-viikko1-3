package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.http.client.fluent.Request;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        Scanner scanner = new Scanner(System.in);
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        PlayerApp app = new PlayerApp(players);

//      Scanner ei toiminut myöskään komentoriviltä, joten kovakoodattu haluttu arvo
//      String nationality = scanner.nextLine();

        String nationality = "FIN";
        System.out.println("Print players from " + nationality + "  " + ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME));
        app.playersByNationality(nationality);
 
    }
  
}