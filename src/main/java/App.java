import lombok.Value;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        var apiURL = "https://imdb-api.com/en/API/Top250TVs/";
        var apiKey = "apiKey";
        var apiIMDB = URI.create(apiURL + apiKey);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder().uri(apiIMDB).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        var json = response.body();
        System.out.println("Response: " + json);
    }
}
