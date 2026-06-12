package edu.fiuba.algo3.modelo.configuraciones;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import edu.fiuba.algo3.modelo.roles.*;

public class ConfiguracionDeMazoGrande implements ConfiguracionDeMazo{
    @Override
    public void obtenerConfig(Map<String, Integer> config) {
        config.put("Sheriff", 1);
        config.put("Detective", 1);
        config.put("Padrino", 1);
        config.put("Medico", 1);
        config.put("Mafioso", 3);
    }
}
