package com.exemplo.classes;

public class Irrigador {
  private String id;
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
    return "Irrigador [ID=" + id +
        ", Umidade Solo=" + umidadeSolo +
        "%, Ação Atual=" + acaoAtual +
        ", Tempo Restante=" + tempoRestante + "s" +
        ", Ciclo Dias=" + cicloDias +
        ", Limiar Umidade=" + limiarUmidade +
        ", Comando=" + comando + "]";
  }

  public Irrigador() {
  }

  // Getters e Setters
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
