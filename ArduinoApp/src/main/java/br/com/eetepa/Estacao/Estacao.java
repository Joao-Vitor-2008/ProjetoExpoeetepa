package com.exemplo.Estacao;

import java.sql.Timestamp;

public class Estacao {

  private String nome;
  private double temperaturaAr;
  private double umidadeAr;
  private int pressaoAr;
  private int indice_uv;
  private Timestamp data_hora = new java.sql.Timestamp(System.currentTimeMillis());

  // Construtor padrão (necessário para Jackson)
  public Estacao() {
  }

  // Getters e Setters
  public Timestamp getData_hora() {
    return data_hora;
  }

  public void setIndice_uv(int indice_uv) {
    this.indice_uv = indice_uv;
  }

  public int getIndice_uv() {
    return indice_uv;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public int getPressaoAr() {
    return pressaoAr;
  }

  public void setPressaoAr(Integer pressaoAr) {
    this.pressaoAr = pressaoAr;
  }

  public double getTemperaturaAr() {
    return temperaturaAr;
  }

  public void setTemperaturaAr(Double temperaturaAr) {
    this.temperaturaAr = temperaturaAr;
  }

  public double getUmidadeAr() {
    return umidadeAr;
  }

  public void setUmidadeAr(Double umidadeAr) {
    this.umidadeAr = umidadeAr;
  }

  @Override
  public String toString() {
    return "Estacao [Nome=" + nome + ", Temp=" + temperaturaAr + ", Umidade=" + umidadeAr + "]";
  }
}
