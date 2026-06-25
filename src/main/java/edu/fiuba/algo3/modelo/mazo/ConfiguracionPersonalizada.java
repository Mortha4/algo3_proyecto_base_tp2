package edu.fiuba.algo3.modelo.mazo;

import java.util.Map;

public class ConfiguracionPersonalizada implements ConfiguracionDeMazo {
    private Map<String, Integer> configuracionDeseada;

    public ConfiguracionPersonalizada(Map<String, Integer> config) {
        this.configuracionDeseada = config;
    }

    @Override
    public void obtenerConfig(Map<String, Integer> config) {
        config.putAll(this.configuracionDeseada);
    }
}