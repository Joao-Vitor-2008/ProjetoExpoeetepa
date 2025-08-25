package com.exemplo.classes;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class ArduinoManager {
    private static ArduinoManager instance = new ArduinoManager();

    // Armazena os dispositivos pelo ID
    private Map<String, Arduino> dispositivos = new ConcurrentHashMap<>();

    private ArduinoManager() {}

    public static ArduinoManager getInstance() {
        return instance;
    }

    public void updateDevice(Arduino d) {
        dispositivos.put(d.getId(), d);
    }

    public Arduino getDevice(String id) {
        return dispositivos.get(id);
    }

    public Map<String, Arduino> getTodos() {
        return dispositivos;
    }

    public String getComando(String id) {
    	Arduino d = dispositivos.get(id);
        if (d != null) {
            if (d.getUmidade() < 50 && d.getTemperatura() > 30) {
            	d.setComando("ligar");
            	return "ligar";
            } else {
            	d.setComando("desligar");
            	return "desligar";
            }
        }
        return "sem_comando";
    }
}