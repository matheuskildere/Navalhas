package servico;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import barbeiros.Barbeiro;
import pagamento.TipoPagamento;

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
    public double somaValorCartao(ArrayList<Servico> listaServico) {
        double valorCartao = 0;
        for (Servico servico : listaServico) {
            if (servico.getTipoPagamento() == TipoPagamento.Cartao) {
                valorCartao += servico.getValorTotal();
            }
        }
        return valorCartao;
    }

    @Override
    public double somaValorDinheiro(ArrayList<Servico> listaServico) {
        double valorDinheiro = 0;
        for (Servico servico : listaServico) {
            if (servico.getTipoPagamento() == TipoPagamento.Dinheiro) {
                valorDinheiro += servico.getValorTotal();
            }
        }
        return valorDinheiro;
    }

    @Override
    public double somaValorTotal(ArrayList<Servico> listaServico) {
        return somaValorCartao(listaServico) + somaValorDinheiro(listaServico);
    }

    @Override
    public Object[] nServicoBarbeiro(Barbeiro barbeiro, ArrayList<Servico> listaServico) {
        
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
    public Object[] nServico(Servicos tipoServico, ArrayList<Servico> listaServico) {
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

    public ArrayList<Servico> relatorioDiario() {
        ArrayList<Servico> relatorioDiario = new ArrayList<>();

        for (Servico servico : listaServico) {
            if(servico.getData("dd/MM/yyyy").equals(dataAtual("dd/MM/yyyy"))){
                relatorioDiario.add(servico);
            }
        }
        return relatorioDiario;
    }

    public ArrayList<Servico> relatorioSemanal() {
        ArrayList<Servico> relatorioSemanal = new ArrayList<>();

        int dia = Integer.parseInt(dataAtual("dd"));

        for (int i = 0; i < 7; i++) { 
            String semana = dia +"/"+ dataAtual("MM/yyyy");
            
            for (Servico servico : listaServico) {
                if(servico.getData("dd/MM/yyyy").equals(semana)){
                    relatorioSemanal.add(servico);
                }
            }
            dia--;
        }

        return relatorioSemanal;
    }

    public ArrayList<Servico> relatorioMensal() {
        ArrayList<Servico> relatorioMensal = new ArrayList<>();

        for (Servico servico : listaServico) {
            if(servico.getData("MM/yyyy").equals(dataAtual("MM/yyyy"))){
                relatorioMensal.add(servico);
            }
        }

        return relatorioMensal;
    }

    public ArrayList<Servico> relatorioAnual() {
        ArrayList<Servico> relatorioAnual = new ArrayList<>();

        for (Servico servico : listaServico) {
            if(servico.getData("yyyy").equals(dataAtual("yyyy"))){
                relatorioAnual.add(servico);
            }
        }

        return relatorioAnual;
    }

    private String dataAtual(String formato){
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat(formato); //"dd/MM/yyyy"
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(data);
        return formatador.format(calendar.getTime());
    }
}