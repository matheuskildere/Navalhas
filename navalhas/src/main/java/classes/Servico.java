package classes;

import java.util.Date;
import java.util.List;

import enumeracao.Barbeiro;
import enumeracao.Servicos;
import enumeracao.TipoPagamento;

/**
 * Servico
 */
public class Servico {
    private Cliente cliente;
    private Barbeiros mario;
    private Barbeiros raimundo;
    private Barbeiros hugo;
    private Barbeiros sergio;
    private List<ServicoUnico> servicos;
    private Barbeiro barbeiro;
    TipoPagamento tipoPagamento;
    private Date data;
    private Pagamento pagamento;
    private double valorTotal = 0;

    public Servico (Cliente cliente, List<ServicoUnico> servicos, Barbeiro barbeiro, TipoPagamento tipoPagamento){
        this.cliente = cliente;
        this.servicos = servicos;
        this.barbeiro = barbeiro;
        this.tipoPagamento = tipoPagamento;

        data = new Date(System.currentTimeMillis());
        cliente.novoServico();
        somaPagamento();
        comissaoBarbeiro();
    }

    private void somaPagamento(){
        for (int i = 0; i < servicos.size(); i++) {
            valorTotal += servicos.get(i).getValor();
        }
        pagamento.pagamento(valorTotal, tipoPagamento);
    }

    private void comissaoBarbeiro(){
        if (barbeiro == Barbeiro.Mario) {
            mario.setComissao(valorTotal*0.5);
        } else if (barbeiro == Barbeiro.Raimundo) {
            raimundo.setComissao(valorTotal*0.5);
        } else if (barbeiro == Barbeiro.Hugo) {
            hugo.setComissao(valorTotal*0.5);
        } else if (barbeiro == Barbeiro.Sérgio) {
            sergio.setComissao(valorTotal*0.5);
        } 
    }

    /**
     * @return the valorTotal
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * @return the barbeiro
     */
    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    /**
     * @return the tipoPagamento
     */
    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    /**
     * @return the servicos
     */
    public List<ServicoUnico> getServicos() {
        return servicos;
    }

}