package edu.fiuba.algo3.modelo.partida;

import edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones.*;
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
    private final CriterioDeDesempate criterio;
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
        this.criterio = new SinMuerte();
    }

    public Partida(List<String> nombres, Set<Supplier<Rol>> config, Boolean conBallotage){
        this.nombres = nombres;
        mazo = new Mazo(config, nombres.size());
        repartirCartas();
        inicializarCondiciones();
        criterio = new SinMuerte();
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
        faseActual.obtenerMasVotados();
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
        if(informacionDias.isEmpty()){
            this.faseActual = new FaseDiurna(criterio);
        } else {
            notificar(informacionNoches.peek());
            this.faseActual = new FaseDiurna(informacionDias.peek());
        }
    }

    public void apilarData(FaseDiurnaData data){
        informacionDias.add(data);
    }
    public void apilarData(FaseNocturnaData data){
        informacionNoches.add(data);
    }

    private void chequearCondicionesDeVictoria(){
        for(CondicionDeVictoria c: condiciones){
            c.chequear(notificables);
        }
    }

    public List<Jugador> getJugadores(){
        return jugadores;
    }
    public Fase getFaseActual(){
        return faseActual;
    }

    @Override
    public void agregarNotificable(Notificable notificable) {
        notificables.add(notificable);
    }

    private void notificar(FaseData data){
        for(Notificable notificable: notificables){
            notificable.actualizar(data);
        }
    }
}
