package servico;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import barbeiros.Barbeiro;
import cliente.Cliente;
import servico.servicoUnico.ServicoUnico;

/**
 * Servico
 */
public class Servico {
    private int id;
    private Cliente cliente;
    private Barbeiro barbeiro;
    private static Date data;
    private List<ServicoUnico> servicos;
    private boolean pagamento; // true for money, and false for cart

    public Servico (Cliente cliente, Barbeiro barbeiro, List<ServicoUnico> servicos,boolean pagamento ){
        this.cliente = cliente;
        this.barbeiro = barbeiro;
        this.servicos = servicos;
        this.pagamento = pagamento; 

        data = new Date();
        cliente.novoServico();
    }

    public String getData(String formato){
        SimpleDateFormat formatador = new SimpleDateFormat(formato); //"dd/MM/yyyy"
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(data);
        return formatador.format(calendar.getTime());
    }

    public Double getValorTotal(){
        double valorTotal = 0;
        for (int i = 0; i < servicos.size(); i++) {
            valorTotal += servicos.get(i).getValor();
        }
        return valorTotal;
    }
    /*
    private void comissaoBarbeiro(){
        if (barbeiro == Barbeiro.Mario) {
            mario.setComissao(valorTotal*0.5);
        } else if (barbeiro == Barbeiro.Raimundo) {
            raimundo.setComissao(valorTotal*0.5);
        } else if (barbeiro == Barbeiro.Hugo) {
            hugo.setComissao(valorTotal*0.5);
        } else if (barbeiro == Barbeiro.Sergio) {
            sergio.setComissao(valorTotal*0.5);
        } 
    }*/

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the barbeiro
     */
    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @return the servicos
     */
    public List<ServicoUnico> getServicos() {
        ArrayList<ServicoUnico> listId = new ArrayList<>();
        for (ServicoUnico servicoUnico : servicos) {
            listId.add(servicoUnico);
        }
        return listId;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    public boolean isPagamento() {
        return pagamento;
    }

    public void setPagamento(boolean pagamento) {
        this.pagamento = pagamento;
    }
}