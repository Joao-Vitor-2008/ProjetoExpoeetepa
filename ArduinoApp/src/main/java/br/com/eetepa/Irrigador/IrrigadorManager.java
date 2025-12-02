package com.exemplo.Irrigador;

import java.util.Map;

import com.exemplo.ClassesAuxiliares.Store;
import com.exemplo.Estacao.EstacaoManager;

public class IrrigadorManager {

  private Store store = Store.getStoreInstance();
  private EstacaoManager estacaoManager = new EstacaoManager();

  public String getComando(Irrigador irrigador) {
    if (irrigador.getPlantio().equals("x") && irrigador.getUmidadeSolo() < irrigador.getLimiarUmidade()
        && estacaoManager.getEstacao("estacao-central").getTemperaturaAr() > 30) {
      irrigador.setAcaoAtual("ligar");
      return "ligar";
    } else if (irrigador.getPlantio().equals("y") && irrigador.getUmidadeSolo() < irrigador.getLimiarUmidade()
        && estacaoManager.getEstacao("estacao-central").getTemperaturaAr() > 28) {
      irrigador.setAcaoAtual("ligar");
      return "ligar";
    } else {
      return "desligar";
    }
  }

  public void updateIrrigador(Irrigador irrigador) {
    store.getIrrigadores().put(irrigador.getPlantio(), irrigador);
  }

  public Irrigador getIrrigador(String plantio) {
    return store.getIrrigadores().get(plantio);
  }

  public Map<String, Irrigador> getTodos() {
    return store.getIrrigadores();
  }

  public boolean existeIrrigador(String id) {
    return store.getIrrigadores().containsKey(id);
  }

}
