package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.fase.Candidato;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mazo.Mazo;
import java.util.ArrayList;
import java.util.List;

public class Partida {
    private final List<String> nombres;
    private final List<Jugador> jugadores = new ArrayList<>();
    private final Mazo mazo;

    public Partida(List<String> nombres)
    {
        this.nombres = nombres;
        mazo = new Mazo(nombres.size());
    }

    public void repartirCartas(){
        mazo.mezclar();
        for (String nombre : nombres) {
            jugadores.add(new Jugador(mazo.agarrarCarta(), nombre));
        }
    }

    public List<Jugador> getJugadores(){
        return jugadores;
    }

    public Candidato recibirMasVotado(Candidato masVotado){
        return masVotado;
    }
}
