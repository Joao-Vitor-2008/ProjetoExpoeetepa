package com.exemplo.ConexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMysql {

    public static String STATUS = "Não conectado";

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "admin";
    private static final String PASSWORD = "8U7=~mf-VhL7|q6Bgw/x";
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DATABASE = "ProjetoExpoeetepaBD";
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?useSSL=false&serverTimezone=UTC";

    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                return connection;
            }

            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            STATUS = "Conectado com sucesso!";
            return connection;

        } catch (ClassNotFoundException e) {
            STATUS = "Driver JDBC não encontrado!";
            e.printStackTrace();
        } catch (SQLException e) {
            STATUS = "Erro ao conectar ao banco de dados!";
            e.printStackTrace();
        }

        return null;
    }

    public static String getStatus() {
        return STATUS;
    }

    public static boolean closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                STATUS = "Conexão encerrada.";
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
