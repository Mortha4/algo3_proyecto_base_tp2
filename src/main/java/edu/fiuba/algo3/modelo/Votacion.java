package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Map;

public class Votacion {
    private Map<Jugador, Integer> votos;

    public Votacion() {
        this.votos = new HashMap<>();
    }

    public void votar(Jugador objetivo) {
        if (!this.votos.containsKey(objetivo)) {
            this.votos.put(objetivo, 0);
        }

        this.votos.put(objetivo, this.votos.get(objetivo) + 1);
    }
}
