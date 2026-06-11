package edu.fiuba.algo3.modelo;

import java.util.Collections;
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

    public Jugador obtenerMasVotado() {
        if (this.votos.isEmpty()) {
            return null;
        }
        return Collections.max(this.votos.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
