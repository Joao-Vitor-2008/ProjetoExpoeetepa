package com.exemplo.Manager;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import com.exemplo.Estacao.Estacao;
import com.exemplo.ConexaoBanco.ConexaoMysql;
import java.sql.Connection;

import com.exemplo.Irrigador.Irrigador;

public class Manager {
  private static Manager manager = new Manager();
  private Map<String, Estacao> estacoes = new ConcurrentHashMap<>();
  private Map<String, Irrigador> irrigadores = new ConcurrentHashMap<>();
  private Estacao estacao = Estacao.getInstance();

  public static Manager getInstance() {
    return manager;
  }

  private Manager() {
  }

  public void updateEstacao(Estacao d) {
    estacoes.put(d.getId(), d);
  }

  public Estacao getEstacao(String id) {
    return estacoes.get(id);
  }

  public Map<String, Estacao> getTodosEstacao() {
    return estacoes;
  }

  public String getComando(Irrigador irrigador) {
    if (irrigador.getId().equals("x") && irrigador.getUmidadeSolo() < irrigador.getLimiarUmidade()
        && estacao.getTemperaturaAr() > 30) {
      irrigador.setAcaoAtual("ligar");
      return "ligar";
    } else if (irrigador.getId().equals("y") && irrigador.getUmidadeSolo() < irrigador.getLimiarUmidade()
        && estacao.getTemperaturaAr() > 28) {
      irrigador.setAcaoAtual("ligar");
      return "ligar";
    } else {
      return "erro";
    }
  }

  Connection conn = ConexaoMysql.getConnection();

  public void updateIrrigador(Irrigador irrigador) {
    irrigadores.put(irrigador.getId(), irrigador);
  }

  public Irrigador getIrrigador(String id) {
    return irrigadores.get(id);
  }

  public Map<String, Irrigador> getTodos() {
    return irrigadores;
  }

  public boolean existeIrrigador(String id) {
    return irrigadores.containsKey(id);
  }

}
