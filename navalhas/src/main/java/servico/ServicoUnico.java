package servico;

/**
 * ServicoUnico
 */
public class ServicoUnico {

    private int id;
    private Servicos nome;
    private double valor;

    public ServicoUnico(Servicos nome, double valor){
        this.nome = nome;
        this.valor = valor;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @return the nome
     */
    public Servicos getNome() {
        return nome;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }
}