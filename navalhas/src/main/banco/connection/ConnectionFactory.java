import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ConnectionFactory
 */
public class ConnectionFactory {

    private final String DRIVER = "org.postgresql.Driver";

    private final String URL = "jdbc:postgresql://localhost/5432/Navalhas";

    private final String USER = "postgres";

    private final String PASS = "!engenheiromoderno1";

    public Connection getConnection(){
        try {
            Class.forName("DRIVER");

            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntmeException("Erro na conexao"+ e);
        }
        return null;
    }

    public static void closeConnection(Connection connection){
        try {
            if (connection != null) {
                connection.close();
            } 
        } catch (Exception e) {
            throw new RuntmeException("Falha ao fechar a conexao"+ e);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement stmt){
        closeConnection(connection);
        try {
            if (stmt != null) {
                stmt.close();
            } 
        } catch (Exception e) {
            throw new RuntmeException("Falha ao fechar a stmt"+ e);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement stmt, ResultSet rs){
        closeConnection(connection, stmt);
        try {
            if (rs != null) {
                rs.close();
            } 
        } catch (Exception e) {
            throw new RuntmeException("Falha ao fechar o rs"+ e);
        }
    }
}