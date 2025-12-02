package br.com.eetepa.Estacao;

import java.util.Map;

import br.com.eetepa.ClassesAuxiliares.Store;

public class EstacaoManager {

  private Store store = Store.getStoreInstance();

  public void updateEstacao(Estacao d) {
    store.getEstacoes().put(d.getNome(), d);
  }

  public Estacao getEstacao(String nome) {
    return store.getEstacoes().get(nome);
  }

  public Map<String, Estacao> getTodos() {
    return store.getEstacoes();
  }

}
