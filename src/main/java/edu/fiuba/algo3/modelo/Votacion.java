package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import java.util.*;

public class Votacion {
    private List<Jugador> votos;
    private Jugador prioritario = null;

    public Votacion() {
        this.votos = new ArrayList<>();
    }

    public void registrarVoto(Jugador objetivo) {
        votos.add(objetivo);
    }

    public void registrarVotoPrioritario(Jugador objetivo) {
        registrarVoto(objetivo);
        this.prioritario = objetivo;
    }

    public Jugador obtenerMasVotado() {
        if (this.votos.isEmpty()) {
            return null;
        }

        Map<Jugador, Integer> cantidadesDeVotos = new HashMap<>();

        for (Jugador jugador: this.votos) {
            if (!cantidadesDeVotos.containsKey(jugador)) {
                cantidadesDeVotos.put(jugador, 0);
            }

            cantidadesDeVotos.put(jugador, cantidadesDeVotos.get(jugador) + 1);
        }

        return Collections.max(cantidadesDeVotos.entrySet(), Map.Entry.comparingByValue()).getKey();
        // TODO: si hay empate desempata this.prioritario
    }
}
