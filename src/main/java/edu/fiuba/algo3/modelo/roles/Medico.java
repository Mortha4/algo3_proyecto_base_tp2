package edu.fiuba.algo3.modelo.roles;
import edu.fiuba.algo3.modelo.visitors.Visitante;
import edu.fiuba.algo3.modelo.visitors.VisitanteCiudadano;

public class Medico extends Rol implements RolVisitable{
    public Medico(){
        visitante = new VisitanteCiudadano();
    }

    public String getTipo() {
        return "Medico";
    }
    @Override
    public RolVisitable aceptar(Visitante visitante) {
        return visitante.visitar(this);
    }
}
