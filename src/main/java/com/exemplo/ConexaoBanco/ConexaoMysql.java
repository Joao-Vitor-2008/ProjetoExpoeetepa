package com.exemplo.ConexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.exemplo.ClassesAuxiliares.STATUS;

public class ConexaoMysql {

  private static STATUS status = STATUS.getInstance();
  private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
  private static final String USER = "admin";
  private static final String PASSWORD = "senha";
  private static final String HOST = "localhost";
  private static final String PORT = "3306";
  private static final String DATABASE = "ProjetoExpoeetepaBD";
  private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE
      + "?useSSL=false&serverTimezone=UTC";

  private static Connection connection;

  public static Connection getConnection() throws SQLException {
    try {
      if (connection != null && !connection.isClosed()) {
        return connection;
      }

      Class.forName(DRIVER);
      connection = DriverManager.getConnection(URL, USER, PASSWORD);
      status.setStatus("Conectado com sucesso");
      return connection;

    } catch (ClassNotFoundException e) {
      status.setStatus("DRIVER não encontrado");
      e.printStackTrace();
    } catch (SQLException e) {
      status.setStatus("Erro SQL");
      e.printStackTrace();
    }

    return connection;
  }

  public static boolean closeConnection() {
    try {
      if (connection != null && !connection.isClosed()) {
        connection.close();
        status.setStatus("Conexão encerrada.");
        return true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }
}
