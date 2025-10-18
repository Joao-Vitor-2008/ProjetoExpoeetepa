package com.exemplo.ClassesAuxiliares;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.exemplo.Irrigador.Irrigador;
import com.exemplo.Estacao.Estacao;

public class Store {

  private static Store instance = new Store();

  public static Store getStoreInstance() {
    return instance;
  }

  private Map<String, Irrigador> irrigadores = new ConcurrentHashMap<>();
  private Map<String, Estacao> estacoes = new ConcurrentHashMap<>();

  public Map<String, Irrigador> getIrrigadores() {
    return irrigadores;
  }

  public Map<String, Estacao> getEstacoes() {
    return estacoes;
  }
}
