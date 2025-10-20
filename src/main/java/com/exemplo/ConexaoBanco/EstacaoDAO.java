package com.exemplo.ConexaoBanco;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import com.exemplo.Estacao.Estacao;

public class EstacaoDAO {

  public void inserirDadosEstacao(Estacao estacao) {
    String sql = ("INSERT INTO estacoes (nome, temperaturaAr, umidadeAr, pressaoAr) VALUES (?,?,?,?);");

    try (
        Connection conn = ConexaoMysql.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);) {
      stmt.setString(1, estacao.getNome());
      stmt.setDouble(2, estacao.getTemperaturaAr());
      stmt.setDouble(3, estacao.getUmidadeAr());
      stmt.setInt(4, estacao.getPressaoAr());

      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
