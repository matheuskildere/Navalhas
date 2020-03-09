package servico.servicoUnico.trabalho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import banco.connection.ConnectionFactory;

/**
 * TrabalhoDAO
 */
public class TrabalhoDAO {

    public void create(Trabalho trab) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO servico_unico (nome) VALUES (?)");

            stmt.setString(1, trab.getNome());
            
            stmt.executeUpdate();
            
            JOptionPane.showConfirmDialog(null, "SALVO COM SUCESSO");
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showConfirmDialog(null, "ERROR AO SALVAR" );
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}