package cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import banco.connection.ConnectionFactory;
/**
 * ClienteDAO
 */
public class ClienteDAO {

    public void create(Cliente cli) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO cliente (nom, cont1, cont2, foto, bio, servGratis, servTotal, serv) VALUES (?,?,?,?,?,?,?,?)");
            
            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getContato1());
            stmt.setString(3, cli.getContato2());
            stmt.setString(4, cli.getFoto());
            stmt.setByte(5, cli.getBiometria());
            stmt.setInt(6, cli.getServicosGratis());
            stmt.setInt(7, cli.getServicosTotal());
            stmt.setInt(8, cli.getServicos());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "SALVO COM SUCESSO");
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "ERROR AO SALVAR" );
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public List<Cliente> read() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM cliente ORDER BY nom");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nom"));
                cliente.setContato1(rs.getString("cont1"));
                cliente.setContato2(rs.getString("cont2"));
                cliente.setFoto(rs.getString("foto"));
                cliente.setBiometria(rs.getByte("bio"));
                cliente.setServicos(rs.getInt("serv"));
                cliente.setServicosGratis(rs.getInt("servgratis"));
                cliente.setServicosTotal(rs.getInt("servtotal"));

                lista.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return lista;
    }

    public void update(Cliente cli) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE cliente SET cont1 = ?, cont2 = ?, foto = ?, bio = ? WHERE nom = ?");
            
            stmt.setString(1, cli.getContato1());
            stmt.setString(2, cli.getContato2());
            stmt.setString(3, cli.getFoto());
            stmt.setByte(4, cli.getBiometria());
            stmt.setString(5, cli.getNome());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "ATUALIZADO COM SUCESSO");
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "ERROR AO ATUALIZAR" );
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Cliente cli) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE from cliente WHERE nom = ?");
            
            stmt.setString(1, cli.getNome());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "EXCLUIDO COM SUCESSO");
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "ERROR AO EXCLUIR" );
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void updateService(Cliente cli) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql ="UPDATE cliente SET servgratis = "+ cli.getServicosGratis()
                +", servtotal = "+ cli.getServicosTotal()
                +", serv = " +cli.getServicos() 
                +" WHERE id = "+cli.getId();
            stmt = con.prepareStatement(sql); //"UPDATE cliente SET servtotal ?WHERE id = 5");// servgratis ?, , serv ? 
            
            //stmt.setInt(1, cli.getServicosGratis());
            //stmt.setInt(1, cli.getServicosTotal());
            //stmt.setInt(3, cli.getServicos());
            //stmt.setInt(2, cli.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "SERVIÇO REGISTRADO COM SUCESSO");
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "ERROR AO ATUALIZAR" );
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
