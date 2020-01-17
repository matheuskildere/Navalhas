package servico;

import java.util.ArrayList;

import barbeiros.Barbeiro;

/**
 * IServico
 */
public interface IServico {

    /**
     * Adiciona um servico a lista de servicos
     * @param serv
     */
    public void add (Servico serv);

    /**
     * Soma o total recebido no cartao
     * @param listaServico
     * @return total recebido no cartao
     */
    public double somaValorCartao(ArrayList<Servico> listaServico);

    /**
     * Soma o total recebido em dinheiro
     * @return valor recebido em dinheiro
     * @param listaServico
     */
    public double somaValorDinheiro(ArrayList<Servico> listaServico);

    /**
     * Soma o total recebido
     * @return total recebido
     * @param listaServico
     */
    public double somaValorTotal(ArrayList<Servico> listaServico);

    /**
     * Devolve o numero de servicos feito por 
     * determinado barbeiro e o valor total de seus servicos
     * @param barbeiro and listaServico
     * @return
     */
    public Object[] nServicoBarbeiro(Barbeiro barbeiro, ArrayList<Servico> listaServico);

    /**
     * Devolve a quantidade de vez que determinado servico
     * foi realizado e o valor total acumulado com o mesmo
     * @param servico and listaServico
     * @return
     */
    public Object[] nServico(Servicos tipoServico, ArrayList<Servico> listaServico);
}