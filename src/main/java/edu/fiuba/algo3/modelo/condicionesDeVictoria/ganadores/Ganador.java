package edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores;

import edu.fiuba.algo3.modelo.partida.Observable;
import edu.fiuba.algo3.vistas.Notificable;

import java.util.List;

public abstract class Ganador implements Observable{
    protected List<Notificable> notificables;
    public abstract void anunciar();
    @Override
    public void agregarNotificable(Notificable notificable) {
        notificables.add(notificable);
    }}
