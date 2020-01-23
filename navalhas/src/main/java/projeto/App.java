package projeto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import cliente.Cliente;
import cliente.ClienteDAO;

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
        //String vari = 17+"/"+getPegaDataAtual("MM/yyyy");
        //System.out.println(vari.equals(getPegaDataAtual("dd/MM/yyyy")));
        App();
        cliente2();
    }

    private static void cliente2(){
        Cliente cli = new Cliente();
        ClienteDAO dao = new ClienteDAO();

        cli.setNome("Matheus");
        cli.setContato1("94992552303");
        cli.setFoto("snadjsvçhaçsld0");
        dao.create(cli);
    }

    private static void cliente(){
        Cliente cli = new Cliente();
        System.out.println(cli.getNome());
        System.out.println(cli.getServicos());
        System.out.println(cli.getServicosGratis());
        System.out.println(cli.getServicosTotal());
        System.out.println(cli.getContato1());
    }
    private static void App() {
        //System.out.println(getPegaDataAtual() );
        /*
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
        mario.setComissao(valorTotal*0.5);
        System.out.println(mario.getComissao());
        */
    }
}
