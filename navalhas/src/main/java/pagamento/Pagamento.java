package pagamento;


/**
 * Pagamento
 */
public class Pagamento {
    private static double cartão = 0;
    private static double dinheiro = 0;
    

    public void pagamento(double valor, TipoPagamento tipo){
        if (tipo == TipoPagamento.Dinheiro) {
            dinheiro += valor;
        } else if (tipo == TipoPagamento.Cartão) {
            cartão += valor;
        }
    }

    /**
     * @return the cartão
     */
    public static double getCartão() {
        return cartão;
    }

    /**
     * @return the dinheiro
     */
    public static double getDinheiro() {
        return dinheiro;
    }
}