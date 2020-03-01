package relatorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import banco.connection.ConnectionFactory;
import barbeiros.Barbeiro;
import servico.Servico;
import servico.ServicoDAO;
import servico.servicoUnico.trabalho.Trabalho;

/**
 * Relatorio
 */
public class Relatorio implements IRelatorio {
    private ServicoDAO dao_servico = new ServicoDAO();

    @Override
    public double somaValorCartao(String data) {
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        ResultSet rs = null;

        
        if (data.length() > 4 && data.length() <=7){
            String mes = data.substring(0, 2);
            String ano = data.substring(3, 7);
            data = ano+"/"+mes;
        }else if(data.length() > 7){
            String dia = data.substring(0, 2);
            String mes = data.substring(3, 5);
            String ano = data.substring(6, 10);
            data = ano+"/"+mes+"/"+dia;
        }

        
        try {
            stmt = con.prepareStatement("SELECT SUM(valtotal) FROM servico WHERE paga = false AND data LIKE '%"+data+"%'");
            rs = stmt.executeQuery();
            double val = 0;
            while (rs.next()) {
                val = rs.getDouble(1);
            }
            
            return val;
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showConfirmDialog(null, "ERROR" );
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return 0;
    }
    public double somaValorCartao(String data, String data2) {
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        ResultSet rs = null;

        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6, 10);
        data = ano+"/"+mes+"/"+dia;

        String dia2 = data2.substring(0, 2);
        String mes2 = data2.substring(3, 5);
        String ano2 = data2.substring(6, 10);
        data2 = ano2+"/"+mes2+"/"+dia2;
        
        try {
            stmt = con.prepareStatement("SELECT SUM(valtotal) FROM servico WHERE paga = false AND data BETWEEN '"+data+"' AND '"+data2+"'");
            rs = stmt.executeQuery();
            double val = 0;
            while (rs.next()) {
                val = rs.getDouble(1);
            }
            
            return val;
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showConfirmDialog(null, "ERROR" );
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return 0;
    }
    
    @Override
    public double somaValorDinheiro(String data) {
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        
        if (data.length() > 4 && data.length() <=7){
            String mes = data.substring(0, 2);
            String ano = data.substring(3, 7);
            data = ano+"/"+mes;
        }else if(data.length() > 7){
            String dia = data.substring(0, 2);
            String mes = data.substring(3, 5);
            String ano = data.substring(6, 10);
            data = ano+"/"+mes+"/"+dia;
        }

        try {
            stmt = con.prepareStatement("SELECT SUM(valtotal) FROM servico WHERE paga = true AND data LIKE '%"+data+"%'");
            rs = stmt.executeQuery();
            double val = 0;
            while (rs.next()) {
                val = rs.getDouble(1);
            }
            
            return val;
            
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showConfirmDialog(null, "ERROR" );
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return 0;
    }
    public double somaValorDinheiro(String data, String data2) {
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        ResultSet rs = null;

        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6, 10);
        data = ano+"/"+mes+"/"+dia;

        String dia2 = data2.substring(0, 2);
        String mes2 = data2.substring(3, 5);
        String ano2 = data2.substring(6, 10);
        data2 = ano2+"/"+mes2+"/"+dia2;
        
        try {
            stmt = con.prepareStatement("SELECT SUM(valtotal) FROM servico WHERE paga = true AND data BETWEEN '"+data+"' AND '"+data2+"'");
            rs = stmt.executeQuery();
            double val = 0;
            while (rs.next()) {
                val = rs.getDouble(1);
            }
            
            return val;
            
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showConfirmDialog(null, "ERROR" );
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return 0;
    }

    @Override
    public double somaValorTotal(String data) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        
        if (data.length() > 4 && data.length() <=7){
            String mes = data.substring(0, 2);
            String ano = data.substring(3, 7);
            data = ano+"/"+mes;
        }else if(data.length() > 7){
            String dia = data.substring(0, 2);
            String mes = data.substring(3, 5);
            String ano = data.substring(6, 10);
            data = ano+"/"+mes+"/"+dia;
        }

        
        try {
            stmt = con.prepareStatement("SELECT SUM(valtotal) FROM servico WHERE data LIKE '%"+data+"%'");
            rs = stmt.executeQuery();
            double val = 0;
            while (rs.next()) {
                val = rs.getDouble(1);
            }
            
            return val;
            
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showConfirmDialog(null, "ERROR" );
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return 0;
    }
    public double somaValorTotal(String data, String data2) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6, 10);
        data = ano+"/"+mes+"/"+dia;

        String dia2 = data2.substring(0, 2);
        String mes2 = data2.substring(3, 5);
        String ano2 = data2.substring(6, 10);
        data2 = ano2+"/"+mes2+"/"+dia2;
        
        try {
            stmt = con.prepareStatement("SELECT SUM(valtotal) FROM servico WHERE data BETWEEN '"+data+"' AND '"+data2+"'");
            rs = stmt.executeQuery();
            double val = 0;
            while (rs.next()) {
                val = rs.getDouble(1);
            }
            
            return val;
            
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showConfirmDialog(null, "ERROR" );
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return 0;
    }
    
    @Override
    public Object[] nServicoBarbeiro(int idBarbeiro, String data) {
        double val = 0;
        int count = 0;
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        ResultSet rs = null;

        if (data.length() > 4 && data.length() <=7){
            String mes = data.substring(0, 2);
            String ano = data.substring(3, 7);
            data = ano+"/"+mes;
        }else if(data.length() > 7){
            String dia = data.substring(0, 2);
            String mes = data.substring(3, 5);
            String ano = data.substring(6, 10);
            data = ano+"/"+mes+"/"+dia;
        }

        
        try {
            
            stmt = con.prepareStatement("SELECT COUNT(*),SUM(valtotal) FROM servico WHERE idbar = " + idBarbeiro+ " AND data LIKE '%"+data+"%'");
            rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
                val = rs.getDouble(2);
            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showConfirmDialog(null, "ERROR" );
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        Object[] ob = {count, val};
        return ob; 
    }
    public Object[] nServicoBarbeiro(int idBarbeiro, String data, String data2) {
        double val = 0;
        int count = 0;
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        ResultSet rs = null;

        
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6, 10);
        data = ano+"/"+mes+"/"+dia;

        String dia2 = data2.substring(0, 2);
        String mes2 = data2.substring(3, 5);
        String ano2 = data2.substring(6, 10);
        data2 = ano2+"/"+mes2+"/"+dia2;
        
        try {
            
            stmt = con.prepareStatement("SELECT COUNT(*),SUM(valtotal) FROM servico WHERE idbar = " + idBarbeiro+ " AND servico.data BETWEEN '"+data+"' AND '"+data2+"'");
            rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
                val = rs.getDouble(2);
            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showConfirmDialog(null, "ERROR" );
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        Object[] ob = {count, val};
        return ob; 
    }

    public Object[] nServiBarb(int idService, int idBarbeiro, String data) {
            double val = 0;
            int count = 0;
            
            Connection con = ConnectionFactory.getConnection();
            
            PreparedStatement stmt = null;
            
            ResultSet rs = null;

            if (data.length() > 4 && data.length() <=7){
                String mes = data.substring(0, 2);
                String ano = data.substring(3, 7);
                data = ano+"/"+mes;
            }else if(data.length() > 7){
                String dia = data.substring(0, 2);
                String mes = data.substring(3, 5);
                String ano = data.substring(6, 10);
                data = ano+"/"+mes+"/"+dia;
            }

            
            try {
                
                stmt = con.prepareStatement("SELECT COUNT(*),SUM(valor) FROM servico_unico INNER JOIN servico ON (idtrab = " + idService+" AND servico.idbar = "+idBarbeiro+" AND servico.id = servico_unico.idserv AND servico.data LIKE '%"+data+"%')");//
                rs = stmt.executeQuery();
                while (rs.next()) {
                    count = rs.getInt(1);
                    val = rs.getDouble(2);
                }
            } catch (SQLException e) {
                System.err.println(e);
                JOptionPane.showConfirmDialog(null, "ERROR" );
            }finally{
                ConnectionFactory.closeConnection(con, stmt);
            }
            Object[] ob = {count, val};
            return ob; 
        }
    
        public Object[] nServiBarb(int idService, int idBarbeiro, String data, String data2) {
            double val = 0;
            int count = 0;
            
            Connection con = ConnectionFactory.getConnection();
            
            PreparedStatement stmt = null;
            
            ResultSet rs = null;

            
            String dia = data.substring(0, 2);
            String mes = data.substring(3, 5);
            String ano = data.substring(6, 10);
            data = ano+"/"+mes+"/"+dia;

            String dia2 = data2.substring(0, 2);
            String mes2 = data2.substring(3, 5);
            String ano2 = data2.substring(6, 10);
            data2 = ano2+"/"+mes2+"/"+dia2;
            
            try {
                
                stmt = con.prepareStatement("SELECT COUNT(*),SUM(valor) FROM servico_unico INNER JOIN servico ON (idtrab = " + idService+" AND servico.idbar = "+idBarbeiro+" AND servico.id = servico_unico.idserv AND servico.data BETWEEN '"+data+"' AND '"+data2+"')");//
                rs = stmt.executeQuery();
                while (rs.next()) {
                    count = rs.getInt(1);
                    val = rs.getDouble(2);
                }
            } catch (SQLException e) {
                System.err.println(e);
                JOptionPane.showConfirmDialog(null, "ERROR" );
            }finally{
                ConnectionFactory.closeConnection(con, stmt);
            }
            Object[] ob = {count, val};
            return ob; 
        }
    @Override
    public Object[] nServico(int idService, String data) {
        double val = 0;
        int count = 0;
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        if (data.length() > 4 && data.length() <=7){
            String mes = data.substring(0, 2);
            String ano = data.substring(3, 7);
            data = ano+"/"+mes;
        }else if(data.length() > 7){
            String dia = data.substring(0, 2);
            String mes = data.substring(3, 5);
            String ano = data.substring(6, 10);
            data = ano+"/"+mes+"/"+dia;
        }

        
        try {
            
            stmt = con.prepareStatement("SELECT COUNT(*),SUM(valor) FROM servico_unico INNER JOIN servico ON (idtrab = " + idService+" AND servico.id = servico_unico.idserv AND data LIKE '%"+data+"%')");//
            rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
                val = rs.getDouble(2);
            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showConfirmDialog(null, "ERROR" );
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        Object[] ob = {count, val};
        return ob; 
    }

    public Object[] nServico(int idService, String data, String data2 ) {
        double val = 0;
        int count = 0;
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        ResultSet rs = null;

        
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6, 10);
        data = ano+"/"+mes+"/"+dia;

        String dia2 = data2.substring(0, 2);
        String mes2 = data2.substring(3, 5);
        String ano2 = data2.substring(6, 10);
        data2 = ano2+"/"+mes2+"/"+dia2;

        
        try {
            
            stmt = con.prepareStatement("SELECT COUNT(*),SUM(valor) FROM servico_unico INNER JOIN servico ON (idtrab = " + idService+" AND servico.id = servico_unico.idserv AND servico.data BETWEEN ('"+data+"') AND ('"+data2+"'))");//
            rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
                val = rs.getDouble(2);
            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showConfirmDialog(null, "ERROR" );
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        Object[] ob = {count, val};
        return ob; 
    }

    
}