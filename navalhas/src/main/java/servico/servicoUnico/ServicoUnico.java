package servico.servicoUnico;

import servico.servicoUnico.trabalho.Trabalho;

/**
 * ServicoUnico
 */
public class ServicoUnico {

    private int id;
    private double valor;
    private Trabalho trabalho;

    public ServicoUnico(double valor, boolean pagamento, Trabalho trabalho){
        this.valor = valor;
        this.trabalho = trabalho;
    }

    /**
     * @return the trabalho
     */
    public Trabalho getTrabalho() {
        return trabalho;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

   
}