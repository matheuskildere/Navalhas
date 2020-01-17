package projeto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import barbeiros.Barbeiros;
import cliente.Cliente;
import cliente.Clientes;
import pagamento.Pagamento;
import pagamento.TipoPagamento;

/**
 * Hello world!
 */
public final class App {
    public static String getPegaDataAtual(String formato) {
        SimpleDateFormat formatador = new SimpleDateFormat(formato);
        Calendar calendar = new GregorianCalendar();
        Date date = new Date();
        calendar.setTime(date);
        //System.out.println(calendar.getTime());
        return formatador.format( calendar.getTime());
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        String vari = 17+"/"+getPegaDataAtual("MM/yyyy");
        System.out.println(vari.equals(getPegaDataAtual("dd/MM/yyyy")));
        //App();
        //cliente2();
    }

    private static void cliente2(){
        Cliente cli = new Cliente("Matheus");
        cli.setContato1("94992555555566");
        Clientes lista = new Clientes();
        lista.add(cli);
        System.out.println("numero: "+lista.get("Matheus").getContato1());
        
        Cliente cli2 = new Cliente("Matheus");
        cli2.setContato1("992552303");
        lista.set("Matheus", cli2);
        System.out.println("numero: "+lista.get("Matheus").getContato1());

        lista.addNewService("Matheus");
        lista.addNewService("Matheus");
        lista.addNewService("Matheus");
        lista.addNewService("Matheus");
        lista.addNewService("Matheus");
        lista.addNewService("Matheus");
        lista.addNewService("Matheus");
        lista.addNewService("Matheus");
        
        System.out.println(lista.addNewService("Matheus"));
        
        System.out.println(lista.addNewService("Matheus"));
        lista.addNewService("Matheus");
        System.out.println(lista.addNewService("Matheus"));

        System.out.println(cli2.getServicos());
        System.out.println(cli2.getServicosGratis());
        System.out.println(cli2.getServicosTotal());
        System.out.println(cli2.getContato1());
    }

    private static void cliente(){
        Cliente cli = new Cliente("Matheus");
        System.out.println(cli.getNome());
        System.out.println(cli.getServicos());
        System.out.println(cli.getServicosGratis());
        System.out.println(cli.getServicosTotal());
        System.out.println(cli.getContato1());
    }
    private static void App() {
        //System.out.println(getPegaDataAtual() );

        Scanner i = new Scanner(System.in);
        Pagamento pagamento = new Pagamento();
        System.out.print("valor: ");
        pagamento.pagamento(i.nextDouble(), TipoPagamento.Cartão);
        System.out.print("valor: ");
        pagamento.pagamento(i.nextDouble(), TipoPagamento.Dinheiro);
        System.out.print("valor: ");
        pagamento.pagamento(i.nextDouble(), TipoPagamento.Cartão);
        System.out.print("valor: ");
        pagamento.pagamento(i.nextDouble(), TipoPagamento.Dinheiro);

        System.out.println(pagamento.getCartão());
        System.out.println(pagamento.getDinheiro());
        double valorTotal = i.nextDouble();
        Barbeiros mario = new Barbeiros();
        mario.setComissao(valorTotal*0.5);
        System.out.println(mario.getComissao());
        
    }
}
