/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * ConnectionFactory
 */
public class ConnectionFactory {

    private static final String DRIVER = "org.postgresql.Driver";

    private static final String URL = "jdbc:postgresql://servidor.cnltqoj8bkox.us-east-2.rds.amazonaws.com:5432/navalhas";
//
    private static final String USER = "postgres";

    private static final String PASS = "!engenheiromoderno1";

    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);

            
            return DriverManager.getConnection(URL, USER, PASS);
      
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Verifique se esta máquina está conectada a internet e tente abrir novamente.\nCaso o erro persista contate o desenvolvedor", "Erro ao Abrir o Programa", JOptionPane.ERROR_MESSAGE);
            System.out.println("erro: "+ e);
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