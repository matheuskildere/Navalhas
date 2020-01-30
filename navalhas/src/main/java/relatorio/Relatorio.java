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
        double val = 0;
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT SUM(valtotal) FROM servico WHERE paga = false AND data LIKE "+data);
            rs = stmt.executeQuery();
            while (rs.next()) {
                val = rs.getDouble(1);
            }
            
            
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showConfirmDialog(null, "ERROR" );
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return val;
    }
    
    @Override
    public double somaValorDinheiro(String data) {
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
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

    @Override
    public double somaValorTotal(String data) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        ResultSet rs = null;
        
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
    
    @Override
    public Object[] nServicoBarbeiro(int idBarbeiro, String data) {
        double val = 0;
        int count = 0;
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
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
    
    @Override
    public Object[] nServico(int idService, String data) {
        double val = 0;
        int count = 0;
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        try {
            
            stmt = con.prepareStatement("SELECT COUNT(*),SUM(valor) FROM servico_unico WHERE idtrab = " + idService+ " AND data LIKE '%"+data+"%'");
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

    
    public static void main(String[] args) {
        Relatorio r = new Relatorio();
        System.out.println(r.nServicoBarbeiro(2, "12")[0]);
        
        System.out.println(r.nServicoBarbeiro(2, "25/12/2019")[1]);

        System.out.println(r.somaValorTotal("/01/2020"));
    }
    
}