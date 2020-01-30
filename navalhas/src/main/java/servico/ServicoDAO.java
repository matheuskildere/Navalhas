package servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import banco.connection.ConnectionFactory; 

/**
 * ClienteDAO
 */
public class ServicoDAO {

    public void create(Servico serv) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO servico (idcli, idbar, data, valtotal, paga) VALUES (?,?,?,?,?)");

            stmt.setInt(1, serv.getCliente().getId());
            stmt.setInt(2, serv.getBarbeiro().getId());
            stmt.setString(3, serv.getData());
            stmt.setDouble(4, serv.getValorTotal());
            stmt.setBoolean(4, serv.isPagamento());
            
            stmt.executeUpdate();
            
            JOptionPane.showConfirmDialog(null, "SALVO COM SUCESSO");
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showConfirmDialog(null, "ERROR AO SALVAR" );
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Servico ser) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE from servico WHERE id = ?");
            
            stmt.setInt(1, ser.getId());
            
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
