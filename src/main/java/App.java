import lombok.Value;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Url da Api
        var apiURL = "https://imdb-api.com/en/API/Top250TVs/";
        //Api Key
        var apiKey = "k_0nwp78p7";
        //Um Identificador Uniforme de Recursos é uma sequência de caracteres usada para a identificação de um recurso específico.
        var apiIMDB = URI.create(apiURL + apiKey);
        //se comporta como um contêiner para informações de configuração comuns a várias solicitações
        var client = HttpClient.newHttpClient();
        //representa a solicitação a ser enviada por meio do HttpClient
        var request = HttpRequest.newBuilder().uri(apiIMDB).build();
        //representa o resultado de uma chamada HttpRequest
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //corpo da requisição
        var json = response.body();
        System.out.println("Response: " + json);
    }
}
