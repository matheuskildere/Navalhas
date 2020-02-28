package ui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

/**
 * Redimensionamento
 */
public class RedimensionaImg {

    public static void redimenImagem(String caminhoImg, Integer imgLargura, Integer imgAltura) throws IOException {

        BufferedImage imagem = ImageIO.read(new File(caminhoImg));

        Double novaImgLargura = (double) imagem.getWidth();
        Double novaImgAltura = (double) imagem.getHeight();

        Double imgProporcao = null;
        if (novaImgLargura >= imgLargura) {
            imgProporcao = (novaImgAltura / novaImgLargura);
            novaImgLargura = (double) imgLargura;
            novaImgAltura = (novaImgLargura * imgProporcao);
            while (novaImgAltura > imgAltura) {
                novaImgLargura = (double) (--imgLargura);
                novaImgAltura = (novaImgLargura * imgProporcao);
            }
        } else if (novaImgAltura >= imgAltura) {
            imgProporcao = (novaImgLargura / novaImgAltura);
            novaImgAltura = (double) imgAltura;
            while (novaImgLargura > imgLargura) {
                novaImgAltura = (double) (--imgAltura);
                novaImgLargura = (novaImgAltura * imgProporcao);
            }
        }

        BufferedImage novaImagem = new BufferedImage(novaImgLargura.intValue(), novaImgAltura.intValue(),
                BufferedImage.TYPE_INT_RGB);
        Graphics g = novaImagem.getGraphics();
        g.drawImage(imagem.getScaledInstance(novaImgLargura.intValue(), novaImgAltura.intValue(), 10000), 0, 0, null);
        g.dispose();
        ImageIO.write(novaImagem, "JPG", new File(caminhoImg));
    }

    public static void main(String[] args) {
        try {
            redimenImagem("./photos/conceicao.png", 100, 100);
        } catch (IOException e) {
            System.out.println("Não deu !");
            e.printStackTrace();
        }
}

}