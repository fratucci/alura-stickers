
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {

  public List<Conteudo> extraiConteudos(String json) {

    JsonParser parser = new JsonParser();
    List<Map<String, String>> listaDetAributos = parser.parse(json);

    return listaDetAributos.stream()
        .map(atributos -> new Conteudo(atributos.get("title"), atributos.get("url")))
        .toList();

  }
}
