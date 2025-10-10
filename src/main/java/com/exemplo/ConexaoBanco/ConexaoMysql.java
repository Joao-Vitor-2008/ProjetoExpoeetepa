package com.exemplo.ConexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMysql {

  public static String STATUS = "Não conectado";

  private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
  private static final String URL = "";
  private static final String USER = "root";
  private static final String PASSWORD = "senha";

  public ConexaoMysql() {

  }

  private static Connection connection = null;

  public static Connection getConnection() {
    try {
      if (connection != null) {
        return connection;
      }

      Class.forName(DRIVER);
      connection = DriverManager.getConnection(URL, USER, PASSWORD);
      STATUS = "Conectado";
    } catch (ClassNotFoundException e) {
      STATUS = "Driver não encontrado";
      e.printStackTrace();
    } catch (SQLException f) {
      STATUS = "Erro de conexão";
      f.printStackTrace();
    }

    return connection;

  }

  public static String getStatus() {
    return STATUS;
  }

  public static boolean closeConnection() {
    try {
      if (connection != null && !connection.isClosed()) {
        connection.close();
        STATUS = "Conexão Encerrada";
        return true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return false;

  }

}
