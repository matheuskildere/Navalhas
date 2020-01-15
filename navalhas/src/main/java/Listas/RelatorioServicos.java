package Listas;

import java.util.ArrayList;

import classes.Servico;
import classes.ServicoUnico;
import enumeracao.Barbeiro;
import enumeracao.Servicos;
import enumeracao.TipoPagamento;
import interfaces.IServico;

/**
 * RelatorioServicos
 */
public class RelatorioServicos implements IServico {
    private ArrayList<Servico> listaServico = new ArrayList<>();

    @Override
    public void add(Servico serv) {
        listaServico.add(serv);    
    }

    @Override
    public double somaValorCartao() {
        double valorCartao = 0;
        for (Servico servico : listaServico) {
            if (servico.getTipoPagamento() == TipoPagamento.Cartão) {
                valorCartao += servico.getValorTotal();
            }
        }
        return valorCartao;
    }

    @Override
    public double somaValorDinheiro() {
        double valorDinheiro = 0;
        for (Servico servico : listaServico) {
            if (servico.getTipoPagamento() == TipoPagamento.Dinheiro) {
                valorDinheiro += servico.getValorTotal();
            }
        }
        return valorDinheiro;
    }

    @Override
    public double somaValorTotal() {
        return somaValorCartao() + somaValorDinheiro();
    }

    @Override
    public Object[] nServicoBarbeiro(Barbeiro barbeiro) {
        
        int nServicos = 0;
        double vServicos = 0;
        for (Servico servico : listaServico) {
            if (servico.getBarbeiro() == barbeiro) {
                nServicos += 1;
                vServicos += servico.getValorTotal();
            }
        }
        Object[] servicosBarbeiro = {nServicos,vServicos};
        return servicosBarbeiro;
    }

    @Override
    public Object[] nServico(Servicos tipoServico) {
        int nVezes = 0;
        double valor = 0;
        for (Servico servico : listaServico) {
            for (ServicoUnico servicoUnico : servico.getServicos()) {
                if (servicoUnico.getNome() == tipoServico) {
                    nVezes += 1;
                    valor += servicoUnico.getValor();
                }
            }
        }
        Object[] servicosBarbeiro = {nVezes,valor};
        return servicosBarbeiro;
    }
    
    
}