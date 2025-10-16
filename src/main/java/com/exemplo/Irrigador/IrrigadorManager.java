package com.exemplo.Irrigador;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.exemplo.Estacao.Estacao;

public class IrrigadorManager {

  private Estacao estacao = Estacao.getInstance();
  private Map<String, Irrigador> irrigadores = new ConcurrentHashMap<>();

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
