package projeto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import cliente.Cliente;
import cliente.ClienteDAO;
import ui.Janela;

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

    
    public static void main(String[] args) {
        Janela i = new Janela();
    }
}
