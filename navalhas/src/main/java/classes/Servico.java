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
    private List<Servicos> servicos;
    private List<Double> valores;
    private Barbeiro barbeiro;
    TipoPagamento tipoPagamento;
    private Date data;
    private Pagamento pagamento;
    private double valorTotal = 0;

    public Servico (Cliente cliente, List<Servicos> servicos,List<Double> valores, Barbeiro barbeiro, TipoPagamento tipoPagamento){
        this.cliente = cliente;
        this.servicos = servicos;
        this.valores = valores;
        this.barbeiro = barbeiro;
        this.tipoPagamento = tipoPagamento;

        data = new Date(System.currentTimeMillis());
        cliente.novoServiço();
        somaPagamento();
        comissaoBarbeiro();
    }

    private void somaPagamento(){
        for (Double valor : valores) {
            valorTotal += valor;
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

}