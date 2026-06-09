package edu.fiuba.algo3.modelo.roles;

import edu.fiuba.algo3.modelo.visitors.Visitante;
import edu.fiuba.algo3.modelo.visitors.VisitanteCiudadano;

public class Sheriff extends Rol implements RolVisitable{

    public Sheriff(){
        visitante = new VisitanteCiudadano();
    }

    public String getTipo() {
        return "Sheriff";
    }
    @Override
    public RolVisitable aceptar(Visitante visitante) {
        return visitante.visitar(this);
    }
}
