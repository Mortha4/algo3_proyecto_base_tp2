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

    public Candidato recibirMasVotado(Candidato masVotado){
        return masVotado;
    }

    public void iniciar(){
        hacerDeNoche();
    }

    public void cambiarFase(){
        faseActual.finalizar();
        faseActual.cambiar(this);
        chequearCondicionesDeVictoria();
    }

    public void hacerDeNoche(){
        if(informacionNoches.isEmpty()){
            this.faseActual = new FaseNocturna();
        } else {
            this.faseActual = new FaseNocturna(informacionNoches.peek());
        }
    }
    public void hacerDeDia(){
        this.faseActual = new FaseDiurna();
    }

    public void apilarData(FaseDiurnaData data){
        informacionDias.add(data);
    }
    public void apilarData(FaseNocturnaData data){
        informacionNoches.add(data);
    }

    private void chequearCondicionesDeVictoria(){
        for(CondicionDeVictoria c: condiciones){
            c.chequear();
        }
    }

    public List<Jugador> getJugadores(){
        return jugadores;
    }
    public Fase getFaseActual(){
        return faseActual; // NO USAR DESDE EL MODELO
    }
}
