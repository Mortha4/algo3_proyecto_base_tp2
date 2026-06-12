package edu.fiuba.algo3.modelo.roles;

import edu.fiuba.algo3.modelo.visitors.Visitante;

public abstract class Rol {
    protected Visitante visitante;

    public Rol verBando(Rol visitable){
        return visitante.visitar(visitable);
    }

    public abstract Rol aceptar(Visitante visitante);
}
