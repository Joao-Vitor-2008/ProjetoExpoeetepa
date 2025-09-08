package com.exemplo.classes;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class IrrigadorManager {
  private static IrrigadorManager instance = new IrrigadorManager();
  private Map<String, Irrigador> irrigadores = new ConcurrentHashMap<>();

  private IrrigadorManager() {
  }

  public static IrrigadorManager getInstance() {
    return instance;
  }

  public void updateIrrigador(Irrigador irrigador) {
    irrigadores.put(irrigador.getId(), irrigador);
  }

  public Irrigador getIrrigador(String id) {
    return irrigadores.get(id);
  }

  public Map<String, Irrigador> getTodos() {
    return irrigadores;
  }

  public void removerIrrigador(String id) {
    irrigadores.remove(id);
  }

  public boolean existeIrrigador(String id) {
    return irrigadores.containsKey(id);
  }
}
