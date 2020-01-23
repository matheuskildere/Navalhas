package relatorio;

import java.util.ArrayList;

import barbeiros.Barbeiro;
import servico.Servico;

/**
 * IServico
 */
public interface IRelatorio {

  
    /**
     * Soma o total recebido no cartao
     * @return valor mantido em cartao
     */
    public double somaValorCartao();

    /**
     * Soma o total recebido em dinheiro
     * @return valor recebido em dinheiro
     * @param listaServico
     */
    public double somaValorDinheiro();

    /**
     * Soma o total recebido
     * @return total recebido
     * @param listaServico
     */
    public double somaValorTotal();

    /**
     * Devolve o numero de servicos feito por 
     * determinado barbeiro e o valor total de seus servicos
     * @param barbeiro and listaServico
     * @return
     */
    public Object[] nServicoBarbeiro(int idBarbeiro);

    /**
     * Devolve a quantidade de vez que determinado servico
     * foi realizado e o valor total acumulado com o mesmo
     * @param servico and listaServico
     * @return
     */
    public Object[] nServico(int idSer);
}