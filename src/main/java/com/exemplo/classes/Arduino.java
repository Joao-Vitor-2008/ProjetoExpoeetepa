package com.exemplo.classes;

public class Arduino {
	
	private String id;
	private double temperatura;
	private double umidade;
	private String comando;
	
	
	public String getComando() {
		return comando;
	}
	public void setComando(String comando) {
		this.comando = comando;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	public double getUmidade() {
		return umidade;
	}
	public void setUmidade(double umidade) {
		this.umidade = umidade;
	}
}
