package com.exemplo.Estacao;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class EstacaoManager {

  private Map<String, Estacao> estacoes = new ConcurrentHashMap<>();

  public void updateEstacao(Estacao d) {
    estacoes.put(d.getNome(), d);
  }

  public Estacao getEstacao(String nome) {
    return estacoes.get(nome);
  }

  public Map<String, Estacao> getTodosEstacao() {
    return estacoes;
  }

}
