package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones.*;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.Ganador;
import edu.fiuba.algo3.modelo.fase.*;
import edu.fiuba.algo3.modelo.fase.faseData.FaseData;
import edu.fiuba.algo3.modelo.fase.faseData.FaseDiurnaData;
import edu.fiuba.algo3.modelo.fase.faseData.FaseNocturnaData;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mazo.Mazo;
import edu.fiuba.algo3.modelo.roles.Rol;
import edu.fiuba.algo3.vistas.Notificable;

import java.util.*;
import java.util.function.Supplier;

public class Partida implements Observable {
    private final List<Notificable> notificables = new ArrayList<>();
    private final List<String> nombres;
    private final List<Jugador> jugadores = new ArrayList<>();
    private final Mazo mazo;
    private List<CondicionDeVictoria> condiciones;
    private Fase faseActual;
    private final Deque<FaseNocturnaData> informacionNoches = new ArrayDeque<>();
    private final Deque<FaseDiurnaData> informacionDias = new ArrayDeque<>();

    public Partida(List<String> nombres)
    {
        this.nombres = nombres;
        mazo = new Mazo(nombres.size());
        repartirCartas();
        inicializarCondiciones();

    }

    public Partida(List<String> nombres, Set<Supplier<Rol>> config){
        this.nombres = nombres;
        mazo = new Mazo(config, nombres.size());
        repartirCartas();
        inicializarCondiciones();
    }

    private void inicializarCondiciones(){
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
            notificar(informacionDias.peek());
            this.faseActual = new FaseNocturna(informacionNoches.peek());
        }
    }
    public void hacerDeDia(){
        notificar(informacionNoches.peek());
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
            notificar(c.chequear());
        }
    }

    public List<Jugador> getJugadores(){
        return jugadores;
    }
    public Fase getFaseActual(){
        return faseActual; // NO USAR DESDE EL MODELO
    }

    @Override
    public void agregarNotificable(Notificable notificable) {
        notificables.add(notificable);
    }

    public void notificar(FaseData data){
        for(Notificable notificable: notificables){
            notificable.actualizar(data);
        }
    }
    public void notificar(Ganador ganador){
        for(Notificable notificable: notificables){
            notificable.actualizar(ganador);
        }
    }
}
