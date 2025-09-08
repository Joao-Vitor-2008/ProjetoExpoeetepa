package com.exemplo.classes;

public class Estacao {

    private String id;
    private int temperaturaAr;
    private int umidadeAr;

    // Construtor padrão (necessário para Jackson)
    public Estacao() {}

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public int getTemperaturaAr() { return temperaturaAr; }
    public void setTemperaturaAr(int temperaturaAr) { this.temperaturaAr = temperaturaAr; }

    public int getUmidadeAr() { return umidadeAr; }
    public void setUmidadeAr(int umidadeAr) { this.umidadeAr = umidadeAr; }

    @Override
    public String toString() {
        return "Estacao [ID=" + id + ", Temp=" + temperaturaAr + ", Umidade=" + umidadeAr + "]";
    }
}
