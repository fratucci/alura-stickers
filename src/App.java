import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

public class App {
    public static void main(String[] args) throws Exception {

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        // System.out.println(body);

        // extrair dados qu interessam
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir dados
        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println("\u001b[1mTítulo:\u001b[m\u001b[31m \u001b[43m" + filme.get("title") + "\u001b[m");
            System.out.println(filme.get("image"));
            System.out.print("\u001b[1mNota: \u001b[m" + filme.get("imDbRating") + " ");
            Integer nota = Integer.valueOf(filme.get("imDbRating").substring(0, 1));
            for (int i = 0; i <= nota; i++) {
                System.out.print("⭐");
            }
            System.out.println();
            System.out.println();

        }

        BufferedImage img = ImageIO.read(new File("entrada/filme.jpg"));
    }
}
