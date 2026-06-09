package edu.fiuba.algo3.modelo.roles;

import edu.fiuba.algo3.modelo.visitors.Visitante;

public class Rol {
    protected Visitante visitante;


    public RolVisitable verBando(RolVisitable visitable){
        return visitante.visitar(visitable);
    }
}
