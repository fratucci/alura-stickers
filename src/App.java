import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
        // String url =
        // "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json";
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        ClienteHttp http = new ClienteHttp();
        String json = http.buscaDados(url);

        // extrair dados qu interessam

        File diretorio = new File("saida/");
        diretorio.mkdir();

        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        // exibir dados

        for (Conteudo conteudo : conteudos) {

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();

            String nomeArquivo = diretorio + "/" + conteudo.getTitulo().replace(":", "-") + ".png";

            GeradoraDeFigurinha geradora = new GeradoraDeFigurinha();
            geradora.cria(inputStream, nomeArquivo);

            System.out.println("\u001b[1mTítulo:\u001b[m\u001b[31m \u001b[43m" + conteudo.getTitulo() + "\u001b[m");
            // System.out.println(filme.get("image"));
            // System.out.print("\u001b[1mNota: \u001b[m" + filme.get("imDbRating") + " ");
            // Integer nota = Integer.valueOf(filme.get("imDbRating").substring(0, 1));
            // for (int i = 0; i <= nota; i++) {
            // System.out.print("⭐");
            // }
            System.out.println();
            System.out.println();

        }

    }
}
