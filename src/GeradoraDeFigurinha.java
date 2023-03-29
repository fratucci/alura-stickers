import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinha {

  public void cria() throws IOException {

    // leitura
    BufferedImage imgOriginal = null;

    imgOriginal = ImageIO.read(new File("entrada/Filme.jpg"));

    int largura = imgOriginal.getWidth();
    int altura = imgOriginal.getHeight();
    int novaAltura = altura + 200;
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    // copiar nova imagem
    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imgOriginal, 0, 0, null);

    // escrever na imagem
    Font myFont = new Font("Serif", Font.BOLD, 80);
    graphics.setFont(myFont);
    graphics.setColor(Color.GREEN);
    graphics.drawString("TOPZERA", 200, novaAltura - 100);

    // escrever nova imagem no arquivo
    ImageIO.write(novaImagem, "png", new File("saida/figura.png"));

  }

  public static void main(String[] args) throws IOException {
    var gerador = new GeradoraDeFigurinha();
    gerador.cria();
  }
}
