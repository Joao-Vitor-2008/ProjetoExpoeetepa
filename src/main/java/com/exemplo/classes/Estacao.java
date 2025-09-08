package com.exemplo.classes;

public class Estacao {
  private String id;
  private double temperaturaAr;
  private double umidadeAr;

  public Estacao(String id, double temperaturaAr, double umidadeAr) {
    this.id = id;
    this.temperaturaAr = temperaturaAr;
    this.umidadeAr = umidadeAr;
  }

  // Getters e Setters
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public double getTemperaturaAr() {
    return temperaturaAr;
  }

  public void setTemperaturaAr(double temperaturaAr) {
    this.temperaturaAr = temperaturaAr;
  }

  public double getUmidadeAr() {
    return umidadeAr;
  }

  public void setUmidadeAr(double umidadeAr) {
    this.umidadeAr = umidadeAr;
  }

  @Override
  public String toString() {
    return "Estação [ID=" + id +
        ", Temperatura=" + temperaturaAr + "°C" +
        ", Umidade=" + umidadeAr + "%]";
  }
}
