package com.exemplo.Irrigador;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.exemplo.Estacao.Estacao;

public class IrrigadorManager {

  private Estacao estacao = Estacao.getInstance();
  private Map<Integer, Irrigador> irrigadores = new ConcurrentHashMap<>();

  public String getComando(Irrigador irrigador) {
    if (irrigador.getId() == 1 && irrigador.getUmidadeSolo() < irrigador.getLimiarUmidade()
        && estacao.getTemperaturaAr() > 30) {
      irrigador.setAcaoAtual("ligar");
      return "ligar";
    } else if (irrigador.getId() == 2 && irrigador.getUmidadeSolo() < irrigador.getLimiarUmidade()
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

  public Irrigador getIrrigador(Integer id) {
    return irrigadores.get(id);
  }

  public Map<Integer, Irrigador> getTodos() {
    return irrigadores;
  }

  public boolean existeIrrigador(Integer id) {
    return irrigadores.containsKey(id);
  }

}
