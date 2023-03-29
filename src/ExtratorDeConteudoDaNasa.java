
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {

  public List<Conteudo> extraiConteudos(String json) {

    JsonParser parser = new JsonParser();
    List<Map<String, String>> listaDetAributos = parser.parse(json);

    List<Conteudo> conteudos = new ArrayList<>();

    for (Map<String, String> atributos : listaDetAributos) {
      String titulo = atributos.get("title");
      String urlImagem = atributos.get("url");

      Conteudo conteudo = new Conteudo(titulo, urlImagem);

      conteudos.add(conteudo);
    }

    return conteudos;
  }
}
