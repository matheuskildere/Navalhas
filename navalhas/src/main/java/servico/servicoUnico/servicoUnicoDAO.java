package servico.servicoUnico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import banco.connection.ConnectionFactory;

/**
 * servicoUnicoDAO
 */
public class servicoUnicoDAO {

    public void create(ServicoUnico servUni) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO servico_unico (valor, idtrab) VALUES (?,?,?)");

            stmt.setDouble(1, servUni.getValor());
            stmt.setInt(2, servUni.getTrabalho().getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showConfirmDialog(null, "SALVO COM SUCESSO");
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
}