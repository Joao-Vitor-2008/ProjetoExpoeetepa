package com.exemplo.ConexaoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ListarDadosDAO {

  private ObjectMapper mapper = new ObjectMapper();

  public String listarDados() throws SQLException {
    StringBuilder sbResultado = new StringBuilder();
    StringBuilder sbEstacoes = new StringBuilder();
    StringBuilder sbIrrigadores = new StringBuilder();
    String sqlEstacoes = ("SELECT * FROM estacoes;");
    String sqlIrrigadores = ("SELECT * FROM irrigadores;");

    // loop pra jogar os dados da querry para um sb
    try (
        Connection conn = new ConexaoMysql().getConnection();
        PreparedStatement sttm = conn.prepareStatement(sqlEstacoes);
        ResultSet result = sttm.executeQuery()) {

      while (result.next()) {
        sbEstacoes.append(result.getDate("data_hora"));
        sbEstacoes.append(result.getString("nome"));

        // transforma esse sb em json e depois retorna para um sb geral
        String jsonEstacoes = mapper.writeValueAsString(sbEstacoes);
        sbResultado.append(jsonEstacoes);
      }
    } catch (Exception e) {
    }

    // loop pra jogar os dados da querry para um sb
    try (
        Connection conn = new ConexaoMysql().getConnection();
        PreparedStatement sttm = conn.prepareStatement(sqlIrrigadores);
        ResultSet result = sttm.executeQuery()) {

      while (result.next()) {
        sbIrrigadores.append(result.getInt("id"));
        sbIrrigadores.append(result.getString("plantio"));
        sbIrrigadores.append(result.getDate("data_hora"));

        String jsonIrrigadores = mapper.writeValueAsString(sbIrrigadores);
        sbResultado.append(jsonIrrigadores);
      }
    } catch (Exception e) {
    }

    return sbResultado.toString();
  }
}
