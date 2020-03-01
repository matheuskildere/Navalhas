package servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import banco.connection.ConnectionFactory;
import servico.servicoUnico.ServicoUnico; 

/**
 * ClienteDAO
 */
public class ServicoDAO {

    public void create(Servico serv) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO servico (valtotal, idcli, idbar, paga ,data) VALUES (?,?,?,?,?)");
            String data = serv.getData();
            String dia = data.substring(0, 2);
            String mes = data.substring(3, 5);
            String ano = data.substring(6, 10);
            String dataEN = ano+"/"+mes+"/"+dia;
            stmt.setDouble(1, serv.getValorTotal());
            stmt.setInt(2, serv.getCliente().getId());
            stmt.setInt(3, serv.getBarbeiro().getId());
            stmt.setBoolean(4, serv.isPagamento());
            stmt.setString(5, dataEN);
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "ERROR AO SALVAR" );
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

    public void serv_seruni(Servico serv, ServicoUnico seruni) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO serv_seruni (idserv, idservuni) VALUES (?,?)");

            stmt.setInt(1, serv.getId());
            stmt.setInt(2, seruni.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showConfirmDialog(null, "SALVO COM SUCESSO");
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showConfirmDialog(null, "ERROR AO SALVAR" );
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Servico> read() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<Servico> lista = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM servico");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Servico servico = new Servico();
                servico.setId(rs.getInt("id"));
                servico.setIdCliente(rs.getInt("idcli"));
                servico.setPagamento(rs.getBoolean("paga"));
                servico.setIdBar(rs.getInt("idbar"));
                servico.setDataString(rs.getString("data"));
                lista.add(servico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return lista;
    }
}
