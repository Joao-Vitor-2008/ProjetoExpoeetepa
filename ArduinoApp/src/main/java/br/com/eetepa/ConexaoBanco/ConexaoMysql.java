package br.com.eetepa.ConexaoBanco;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.eetepa.ClassesAuxiliares.STATUS;

import io.github.cdimascio.dotenv.Dotenv;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConexaoMysql {

  private static final Dotenv dotenv = Dotenv.configure().filename("dados.env").load();

  private STATUS status = STATUS.getInstance();
  private static String DRIVER = "com.mysql.cj.jdbc.Driver";
  private static String USER = dotenv.get("usuarioBD");
  private static String PASSWORD = dotenv.get("senhaBD");
  private static String URL = dotenv.get("url");

  private static final HikariDataSource ds;

  static {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(URL);
    config.setUsername(USER);
    config.setPassword(PASSWORD);
    config.setDriverClassName(DRIVER);
    ds = new HikariDataSource(config);
  }

  public Connection getConnection() throws SQLException {
    try {
      if (ds.getConnection() != null && !ds.getConnection().isClosed()) {
        return ds.getConnection();
      }

      status.setStatus("Conectado com sucesso");
      return ds.getConnection();

    } catch (SQLException e) {
      status.setStatus("Erro SQL");
      e.printStackTrace();
    }
    return ds.getConnection();
  }
}
