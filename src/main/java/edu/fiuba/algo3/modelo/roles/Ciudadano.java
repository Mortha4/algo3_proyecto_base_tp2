package edu.fiuba.algo3.modelo.roles;
import edu.fiuba.algo3.modelo.visitors.Visitante;
import edu.fiuba.algo3.modelo.visitors.VisitanteCiudadano;

public class Ciudadano extends Rol {
    public Ciudadano(){
        this.visitante = new VisitanteCiudadano();
    }

    @Override
    public Rol aceptar(Visitante visitante) {
        return visitante.visitar(this);
    }
}
