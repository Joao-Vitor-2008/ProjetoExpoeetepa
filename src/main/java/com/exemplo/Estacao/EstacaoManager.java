package com.exemplo.Estacao;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class EstacaoManager {
  private static EstacaoManager instance = new EstacaoManager();
  private Map<String, Estacao> dispositivos = new ConcurrentHashMap<>();

  private EstacaoManager() {
  }

  public static EstacaoManager getInstance() {
    return instance;
  }

  public void updateDevice(Estacao d) {
    dispositivos.put(d.getId(), d);
  }

  public Estacao getDevice(String id) {
    return dispositivos.get(id);
  }

  public Map<String, Estacao> getTodos() {
    return dispositivos;
  }
}
