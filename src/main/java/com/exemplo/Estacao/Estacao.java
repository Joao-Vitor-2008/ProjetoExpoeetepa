package com.exemplo.Estacao;

public class Estacao {

  private int id;
  private String nome;
  private double temperaturaAr;
  private double umidadeAr;
  private int pressaoAr;

  // Construtor padrão (necessário para Jackson)
  public Estacao() {
  }

  // Getters e Setters
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  private static Estacao instance = new Estacao();

  public static Estacao getInstance() {
    return instance;
  }

  @Override
  public String toString() {
    return "Estacao [ID=" + id + ", Temp=" + temperaturaAr + ", Umidade=" + umidadeAr + "]";
  }
}
