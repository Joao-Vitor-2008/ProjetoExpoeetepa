package com.exemplo.classes;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class IrrigadorManager {
    private static IrrigadorManager instance = new IrrigadorManager();

    // Armazena os irrigadores pelo ID
    private Map<String, Irrigador> irrigadores = new ConcurrentHashMap<>();

    private IrrigadorManager() {}

    public static IrrigadorManager getInstance() {
        return instance;
    }

    // Adiciona ou atualiza um irrigador
    public void updateIrrigador(String id, Irrigador irrigador) {
        irrigadores.put(id, irrigador);
    }

    // Recupera um irrigador pelo ID
    public Irrigador getIrrigador(String id) {
        return irrigadores.get(id);
    }

    // Retorna todos os irrigadores
    public Map<String, Irrigador> getTodos() {
        return irrigadores;
    }

    // Remove um irrigador pelo ID
    public void removerIrrigador(String id) {
        irrigadores.remove(id);
    }

    // Verifica se um irrigador existe
    public boolean existeIrrigador(String id) {
        return irrigadores.containsKey(id);
    }
}

