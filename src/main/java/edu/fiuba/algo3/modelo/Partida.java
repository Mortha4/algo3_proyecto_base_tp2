package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones.*;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.Ganador;
import edu.fiuba.algo3.modelo.fase.*;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mazo.Mazo;

import java.util.*;

public class Partida {
    private final List<String> nombres;
    private final List<Jugador> jugadores = new ArrayList<>();
    private final Mazo mazo;
    private final List<CondicionDeVictoria> condiciones;
    private Fase faseActual;
    private Deque<FaseNocturnaData> informacionNoches = new ArrayDeque<>();
    private Deque<FaseDiurnaData> informacionDias = new ArrayDeque<>();

    public Partida(List<String> nombres)
    {
        this.nombres = nombres;
        mazo = new Mazo(nombres.size());
        repartirCartas();

        condiciones = new ArrayList<>(List.of(
                new MayoriaDeMafiosos(jugadores),
                new NoHayMafiosos(jugadores),
                new UnSoloCiudadano(jugadores),
                new UnSoloMafioso(jugadores)
        ));
    }

    private void repartirCartas(){
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

    public void iniciar(){
        faseActual = new FaseNocturna();
        cicloFase();
        faseActual = new FaseDiurna();
    }

    private void cicloFase(){
        // TODO: iterar sobre todos los jugadores pidiendo que hagan una accion (controller)
        faseActual.finalizar();
        faseActual.exportarInfo();
        chequearCondicionesDeVictoria();
    }

    private void chequearCondicionesDeVictoria(){
        for(CondicionDeVictoria c: condiciones){
            c.chequear();
        }
    }
}
