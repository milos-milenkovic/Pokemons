import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class APIHandler {
  public String makeHTTPRequestPokemonDetails(String name) {
    String urlString = "https://pokeapi.co/api/v2/pokemon/"+name;
    String response = null;
    try {
      URL url = new URL(urlString);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      connection.setRequestProperty("Content-Type", "application/json");
      connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
      connection.connect();
      Scanner responseScanner = new Scanner(connection.getInputStream());
      while (responseScanner.hasNext()) {
        response = responseScanner.nextLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return response;
  }
}

