package com.exemplo.Irrigador;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.exemplo.Estacao.Estacao;

public class IrrigadorManager {

  private Estacao estacao = Estacao.getInstance();
  private Map<String, Irrigador> irrigadores = new ConcurrentHashMap<>();

  public String getComando(Irrigador irrigador) {
    if (irrigador.getPlantio().equals("x") && irrigador.getUmidadeSolo() < irrigador.getLimiarUmidade()
        && estacao.getTemperaturaAr() > 30) {
      irrigador.setAcaoAtual("ligar");
      return "ligar";
    } else if (irrigador.getPlantio().equals("y") && irrigador.getUmidadeSolo() < irrigador.getLimiarUmidade()
        && estacao.getTemperaturaAr() > 28) {
      irrigador.setAcaoAtual("ligar");
      return "ligar";
    } else {
      return "erro";
    }
  }

  public void updateIrrigador(Irrigador irrigador) {
    irrigadores.put(irrigador.getPlantio(), irrigador);
  }

  public Irrigador getIrrigador(String plantio) {
    return irrigadores.get(plantio);
  }

  public Map<String, Irrigador> getTodos() {
    return irrigadores;
  }

  public boolean existeIrrigador(String id) {
    return irrigadores.containsKey(id);
  }

}
