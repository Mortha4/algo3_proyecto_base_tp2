package edu.fiuba.algo3.modelo.configuraciones;
import edu.fiuba.algo3.modelo.roles.*;
import java.util.Map;
import java.util.Random;

public class ConfiguracionPequenia implements ConfiguracionDeMazo {
    private final Random random = new Random();

    @Override
    public void obtenerConfig(Map<String, Integer> config) {
        if(random.nextBoolean()) {
            config.put("Detective", 1);
        } else {
            config.put("Medico", 1);
        }

        if(random.nextBoolean()) {
            config.put("Mafioso", 1);
        } else {
            config.put("Mafioso", 2);
        }

    }
}
