package edu.fiuba.algo3.modelo.mazo;
import java.util.Map;
import java.util.Random;

public class Mediana implements ConfiguracionDeMazo {
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
