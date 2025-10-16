package com.exemplo.Estacao;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class EstacaoManager {

  private Map<String, Estacao> estacoes = new ConcurrentHashMap<>();

  public void updateEstacao(Estacao d) {
    estacoes.put(d.getId(), d);
  }

  public Estacao getEstacao(String id) {
    return estacoes.get(id);
  }

  public Map<String, Estacao> getTodosEstacao() {
    return estacoes;
  }

}
