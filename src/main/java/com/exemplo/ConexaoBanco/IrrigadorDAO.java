package com.exemplo.ConexaoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.exemplo.Irrigador.Irrigador;
import com.exemplo.Irrigador.IrrigadorManager;
import com.exemplo.Estacao.EstacaoManager;

public class IrrigadorDAO {

  private IrrigadorManager irrigadorManager = new IrrigadorManager();
  private EstacaoManager estacaoManager = new EstacaoManager();

  public void inserirDadosIrrigador(Irrigador irrigador) throws SQLException {
    String sql = "INSERT INTO irrigadores (plantio, umidadeSolo, acaoAtual, tempoRestante, cicloDias, limiarUmidade, data_hora) VALUES (?,?,?,?,?,?,?);";

    try (Connection conn = new ConexaoMysql().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);) {

      stmt.setString(1, irrigador.getPlantio());
      stmt.setDouble(2, irrigador.getUmidadeSolo());
      stmt.setString(3, irrigadorManager.getComando(irrigador));
      stmt.setInt(4, irrigador.getTempoRestante());
      stmt.setInt(5, irrigador.getCicloDias());
      stmt.setInt(6, irrigador.getLimiarUmidade());
      stmt.setTimestamp(7, estacaoManager.getEstacao("estacao-central").getData_hora());

      stmt.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException("Erro ao inserir os dados do irrigador: " + irrigador.getPlantio(), e);
    }
  }
}
