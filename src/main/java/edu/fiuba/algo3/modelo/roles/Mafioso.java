package edu.fiuba.algo3.modelo.roles;

import edu.fiuba.algo3.modelo.visitors.Visitante;
import edu.fiuba.algo3.modelo.visitors.VisitanteMafioso;

public class Mafioso implements Rol, RolVisitable {
    private VisitanteMafioso visitante;

    public Mafioso(){
        visitante = new VisitanteMafioso();
    }

    @Override
    public RolVisitable aceptar(Visitante visitante) {
        return visitante.visitar(this);
    }

    public RolVisitable verRol(RolVisitable visitable){
        return visitante.visitar(visitable);
    }
}
