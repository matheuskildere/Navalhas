package cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import banco.connection.ConnectionFactory;
import cliente.Cliente;
/**
 * ClienteDAO
 */
public class ClienteDAO {

    public void create(Cliente cli) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO cliente (nom, cont1, cont2, foto, bio) VALUES (?,?,?,?,?)");

            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getContato1());
            stmt.setString(3, cli.getContato2());
            stmt.setString(4, cli.getFoto());
            stmt.setByte(5, cli.getBiometria());

            stmt.executeUpdate();

            JOptionPane.showConfirmDialog(null, "SALVO COM SUCESSO");
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "ERROR AO SALVAR");
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}