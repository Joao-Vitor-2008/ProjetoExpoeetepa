package com.exemplo.ConexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMysql {

  public static String STATUS = "Não conectado";

  private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
  private static final String url = "";
  private static final String user = "root";
  private static final String password = "senha";

  public ConexaoMysql() {

  }

  Connection connection = null;

  public static java.sql.Connection getConnection() {
    try {
      Class.forName(DRIVER);
      return DriverManager.getConnection(url, user, password);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {

    }
  }

}
