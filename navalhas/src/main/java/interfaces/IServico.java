package interfaces;

import java.util.List;

import classes.Servico;
import enumeracao.Barbeiro;
import enumeracao.Servicos;

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
     * @return valor recebido no cartao
     */
    public double somaValorCartao();

    /**
     * Soma o total recebido em dinheiro
     * @return valor recebido em dinheiro
     */
    public double somaValorDinheiro();

    /**
     * Soma o total recebido
     * @return total recebido
     */
    public double somaValorTotal();

    /**
     * Devolve o numero de servicos feito por 
     * determinado barbeiro e o valor total de seus servicos
     * @param barbeiro
     * @return
     */
    public Object[] nServicoBarbeiro(Barbeiro barbeiro);

    /**
     * Devolve a quantidade de vez que determinado servico
     * foi realizado e o valor total acumulado com o mesmo
     * @param servico
     * @return
     */
    public Object[] nServico(Servicos tipoServico);
}