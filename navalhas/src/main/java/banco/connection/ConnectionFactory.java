package banco.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ConnectionFactory
 */
public class ConnectionFactory {

    private static final String DRIVER = "org.postgresql.Driver";

    private static final String URL = "jdbc:postgresql://localhost:5432/Navalhas";

    private static final String USER = "postgres";

    private static final String PASS = "!engenheiromoderno1";

    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);

            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro na conexao"+ e);
        }
    }

    public static void closeConnection(Connection connection){
        try {
            if (connection != null) {
                connection.close();
            } 
        } catch (Exception e) {
            throw new RuntimeException("Falha ao fechar a conexao"+ e);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement stmt){
        closeConnection(connection);
        try {
            if (stmt != null) {
                stmt.close();
            } 
        } catch (Exception e) {
            throw new RuntimeException("Falha ao fechar a stmt"+ e);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement stmt, ResultSet rs){
        closeConnection(connection, stmt);
        try {
            if (rs != null) {
                rs.close();
            } 
        } catch (Exception e) {
            throw new RuntimeException("Falha ao fechar o rs"+ e);
        }
    }
}