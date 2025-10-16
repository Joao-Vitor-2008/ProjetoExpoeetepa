package com.exemplo.Estacao;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class EstacaoManager {

  private Map<Integer, Estacao> estacoes = new ConcurrentHashMap<>();

  public void updateEstacao(Estacao d) {
    estacoes.put(d.getId(), d);
  }

  public Estacao getEstacao(Integer id) {
    return estacoes.get(id);
  }

  public Map<Integer, Estacao> getTodosEstacao() {
    return estacoes;
  }

}
