package edu.fiuba.algo3.modelo.configuraciones;
import edu.fiuba.algo3.modelo.roles.*;
import java.util.Map;
import java.util.Random;

public class ConfiguracionMediana implements ConfiguracionDeMazo {
    private final Random random = new Random();

    @Override
    public void obtenerConfig(Map<String, Integer> config) {
        config.put("Detective", 1);
        config.put("Medico", 1);

        if(random.nextBoolean()){
            config.put("Mafioso", 2);
        } else {
            config.put("Mafioso", 3);
        }
    }
}
