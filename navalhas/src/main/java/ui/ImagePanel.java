package ui;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class ImagePanel extends JPanel {
 
    /*
     * Podiamos usar qualquer uma das classes abaixo mas para simplificar
     * vamos usar um objecto do tipo Image que obtemos através de um ImageIcon
     * que tem métodos mais simples para carregar imagens, embora não permite a
     * mesma optimização que, por exemplo, um BufferedImage.
     *
     * Image é uma classe abstracta.
     *
     * Image, ImageBuffered, ImageIcon
     */
    private Image image;
 
    /**
     * Construtor que irá receber a imagem e defini-la como existindo no fundo
     * do painel.
     * 
     * @param url URL com a imagem a colocar no fundo.
     */
    public ImagePanel(URL url) {
 
        /*
         * Para evitar repetir código vamos já usar o método seImage. Usar os sets/gets
         * no construtor pode ajudar a manter a validade dos dados se, principalmente,
         * os sets fizerem alguma validação. Neste caso é simplesmente para não
         * repetir o mesmo código
         */
        setImage(url);
 
        //Fundamental que a propriedade seja coloca a false ou a imagem não vai aparecer
        setOpaque(false);
 
        setPreferredSize(new Dimension(getWidth(), getHeight()));
    }
 
    public void setImage(URL url) {
        image = new ImageIcon(url).getImage();
    }
 
    @Override
    public void paintComponent(Graphics g) {
        /*
         * A imagem vai ser desenhada em x=0, y=0 e usando o tamanho real da imagem
         * é fundamental que seja chamado o método drawImage antes de se chamar o
         * método paintComponent da superclasse.
         */
        g.drawImage(image, 0, 0, this);
 
        /*
         * Ao desenharmos primeiro a imagem garantimos que qualquer componente
         * que seja adicionado ao painel fique por cima da imagem, criando assim
         * o efeito de imagem de background que pretendemos.
         *
         * Se trocarmos a ordem, os efeitos podem não ser os esperados já que a
         * imagem vai ser desenhada em cima dos componentes que estão neste JPanel.
         * Se não existirem componente então a ordem não é relevante.
         */
        super.paintComponent(g);
    }
 
    /**
     * A largura do nosso painel será dada pela largura da nossa imagem.
     *
     * @return int largura da imagem, se disponível
     */
    @Override
    public int getWidth() {
        return image.getWidth(this);
    }
 
    /**
     * Tal como a largura, também a altura é dependente do painel.
     *
     * @return int altura da imagem, se disponível
     */
    @Override
    public int getHeight() {
        return image.getHeight(this);
    }
}