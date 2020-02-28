package servico.servicoUnico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import banco.connection.ConnectionFactory;
import servico.Servico;

/**
 * servicoUnicoDAO
 */
public class ServicoUnicoDAO {

    public void create(ServicoUnico servUni, Servico serv) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO servico_unico (valor, idtrab, idserv) VALUES (?,?,?)");

            stmt.setDouble(1, servUni.getValor());
            stmt.setInt(2, servUni.getTrabalho().getId());
            stmt.setInt(3, serv.getId());
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showConfirmDialog(null, "ERROR AO SALVAR" );
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(ServicoUnico servUni) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE from servico WHERE id = ?");
            
            stmt.setInt(1, servUni.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showConfirmDialog(null, "EXCLUIDO COM SUCESSO");
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showConfirmDialog(null, "ERROR AO EXCLUIR" );
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public Objeto getDataService(int idService) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        ResultSet rs = null;
        Objeto ob = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM servico_unico");
            rs = stmt.executeQuery();
            while (rs.next()) {
                int nServico =rs.getInt(1);
                double valorTotal = rs.getInt(2);
                ob = new Objeto(nServico,valorTotal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return ob;
    }
}

class Objeto{
    int nServicos;
    double valorTotal;
    public Objeto(int nServicos, double valorTotal){
        this.nServicos = nServicos;
        this.valorTotal = valorTotal;
    }
}