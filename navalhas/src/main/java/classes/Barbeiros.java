package classes;

import enumeracao.Barbeiro;

/**
 * Barbeiros
 */
public class Barbeiros {
    private static double comissao;
    
    /**
     * @param comissao the comissao to set
     */
    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    /**
     * @return the comissao
     */
    public static double getComissao() {
        return comissao;
    }
}