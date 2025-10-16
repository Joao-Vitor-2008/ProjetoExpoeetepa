package com.exemplo.Irrigador;

public class Irrigador {
  private String plantio;
  private double umidadeSolo;
  private String acaoAtual;
  private int tempoRestante;
  private int cicloDias;
  private int limiarUmidade;
  private String comando;

  // Getters e Setters
  public int getCicloDias() {
    return cicloDias;
  }

  public void setCicloDias(int cicloDias) {
    this.cicloDias = cicloDias;
  }

  public int getLimiarUmidade() {
    return limiarUmidade;
  }

  public void setLimiarUmidade(int limiarUmidade) {
    this.limiarUmidade = limiarUmidade;
  }

  public void setComando(String comando) {
    this.comando = comando;
  }

  @Override
  public String toString() {
    return "Irrigador [plantio=" + plantio +
        ", Umidade Solo=" + umidadeSolo +
        "%, Ação Atual=" + acaoAtual +
        ", Tempo Restante=" + tempoRestante + "s" +
        ", Ciclo Dias=" + cicloDias +
        ", Limiar Umidade=" + limiarUmidade +
        ", Comando=" + comando + "]";
  }

  public Irrigador() {
  }

  public String getPlantio() {
    return plantio;
  }

  public void setPlantio(String plantio) {
    this.plantio = plantio;
  }

  public double getUmidadeSolo() {
    return umidadeSolo;
  }

  public void setUmidadeSolo(double umidadeSolo) {
    this.umidadeSolo = umidadeSolo;
  }

  public String getAcaoAtual() {
    return acaoAtual;
  }

  public void setAcaoAtual(String acaoAtual) {
    this.acaoAtual = acaoAtual;
  }

  public int getTempoRestante() {
    return tempoRestante;
  }

  public void setTempoRestante(int tempoRestante) {
    this.tempoRestante = tempoRestante;
  }
}
