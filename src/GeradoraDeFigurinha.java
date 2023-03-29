import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinha {

  public void cria(InputStream inputStream, String nomeArquivo) throws IOException {

    // leitura
    // imgOriginal = ImageIO.read(new File("entrada/Filme.jpg"));
    BufferedImage imgOriginal = null;
    // InputStream inputStream = new URL(
    // "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
    imgOriginal = ImageIO.read(inputStream);

    // cria nova imagem
    int largura = imgOriginal.getWidth();
    int altura = imgOriginal.getHeight();
    int novaAltura = altura + 200;
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    // copiar nova imagem
    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imgOriginal, 0, 0, null);

    // escrever na imagem
    Font myFont = new Font("Impact", Font.BOLD, 80);
    graphics.setFont(myFont);
    graphics.setColor(Color.YELLOW);
    String palavraClass = "TOPZERA";

    drawCenteredString(palavraClass, largura, novaAltura, graphics);

    // escrever nova imagem no arquivo
    ImageIO.write(novaImagem, "png", new File(nomeArquivo));

  }

  public void drawCenteredString(String s, int w, int h, Graphics g) {
    FontMetrics fm = g.getFontMetrics();
    int x = (w - fm.stringWidth(s)) / 2;
    int y = h - 100;
    g.drawString(s, x, y);
  }

}
