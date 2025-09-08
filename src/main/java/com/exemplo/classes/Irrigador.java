package com.exemplo.classes;

public class Irrigador {
  private int umidadeSolo;
  private String acaoAtual;
  private int tempoRestante;
  private int cicloDias;
  private int limiarUmidade;
  private String comando;
  private String id;

  public void setId(String id) {
    this.id = id;
  }

  public void setUmidadeSolo(int umidadeSolo) {
    this.umidadeSolo = umidadeSolo;
  }

  public void setTempoRestante(int tempoRestante) {
    this.tempoRestante = tempoRestante;
  }

  public void setCicloDias(int cicloDias) {
    this.cicloDias = cicloDias;
  }

  public void setLimiarUmidade(int limiarUmidade) {
    this.limiarUmidade = limiarUmidade;
  }

  public void setAcaoAtual(String acaoAtual) {
    this.acaoAtual = acaoAtual;
  }

  public void setComando(String comando) {
    this.comando = comando;
  }

  public int getTempoRestante() {
    return tempoRestante;
  }

  public int getUmidadeSolo() {
    return umidadeSolo;
  }

  public String getAcaoAtual() {
    return acaoAtual;
  }

  public int getCicloDias() {
    return cicloDias;
  }

  public int getLimiarUmidade() {
    return limiarUmidade;
  }

  public String getComando() {
    return comando;
  }

  public String getId() {
    return id;
  }

}
