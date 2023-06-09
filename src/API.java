public enum API {

  IMDB_MOVIE("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json",
      new ExtratorDeConteudoDoIMDB()),
  IMBD_SERIE("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json",
      new ExtratorDeConteudoDoIMDB()),
  NASA("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json",
      new ExtratorDeConteudoDaNasa()),
  LINGUAGEM("http://localhost:8080/linguagens", new ExtratorDeConteudoDoIMDB());

  private String url;
  private ExtratorDeConteudo extrator;

  API(String url, ExtratorDeConteudo extrator) {
    this.url = url;
    this.extrator = extrator;
  }

  public String getUrl() {
    return url;
  }

  public ExtratorDeConteudo getExtrator() {
    return extrator;
  }

}
