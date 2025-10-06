package com.exemplo.classes;

import java.util.concurrent.ConcurrentHashMap;

import java.util.Map;

public class IrrigadorManager {
  private static IrrigadorManager instance = new IrrigadorManager();

  private Map<String, Irrigador> irrigadores = new ConcurrentHashMap<>();

  private Estacao estacao = Estacao.getInstance();

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
