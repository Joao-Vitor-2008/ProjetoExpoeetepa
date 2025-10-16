package com.exemplo.ConexaoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.exemplo.Irrigador.Irrigador;

public class IrrigadorDAO {

  public void inserirDadosIrrigador(Irrigador irrigador) {
    String sql = ("INSERT INTO irrigadores (plantio, umidadeSolo, acaoAtual, tempoRestante, cicloDias, limiarUmidade) VALUES (?,?,?,?,?,?)");

    try (Connection conn = ConexaoMysql.getConnection()) {
      PreparedStatement stmt = conn.prepareStatement(sql);

      stmt.setString(1, irrigador.getId());
      stmt.setDouble(2, irrigador.getUmidadeSolo());
      stmt.setString(3, irrigador.getAcaoAtual());
      stmt.setInt(4, irrigador.getTempoRestante());
      stmt.setInt(5, irrigador.getCicloDias());
      stmt.setInt(6, irrigador.getLimiarUmidade());

      stmt.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
