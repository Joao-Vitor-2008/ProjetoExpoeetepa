package com.exemplo.ConexaoBanco;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import com.exemplo.Estacao.Estacao;

public class EstacaoDAO {

  public void inserirDadosEstacao(Estacao estacao) {
    String sql = ("INSERT INTO estacoes (data_hora, nome, temperaturaAr, umidadeAr, pressaoAr, indice_uv) VALUES (?,?,?,?,?,?);");

    try (
        Connection conn = ConexaoMysql.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);) {
      stmt.setTimestamp(1, estacao.getData_hora());
      stmt.setString(2, estacao.getNome());
      stmt.setDouble(3, estacao.getTemperaturaAr());
      stmt.setDouble(4, estacao.getUmidadeAr());
      stmt.setInt(5, estacao.getPressaoAr());
      stmt.setInt(6, estacao.getIndice_uv());

      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
