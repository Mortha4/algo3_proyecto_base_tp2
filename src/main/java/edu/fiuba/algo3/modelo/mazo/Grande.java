package edu.fiuba.algo3.modelo.mazo;

import java.util.Map;

public class Grande implements ConfiguracionDeMazo{
    @Override
    public void obtenerConfig(Map<String, Integer> config) {
        config.put("Sheriff", 1);
        config.put("Detective", 1);
        config.put("Padrino", 1);
        config.put("Medico", 1);
        config.put("Mafioso", 3);
    }
}
