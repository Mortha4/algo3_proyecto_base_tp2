package edu.fiuba.algo3.modelo.roles;
import edu.fiuba.algo3.modelo.visitors.Visitante;
import edu.fiuba.algo3.modelo.visitors.VisitanteCiudadano;

public class Medico extends Rol {
    public Medico(){
        visitante = new VisitanteCiudadano();
    }

    public String getTipo() {
        return "Medico";
    }
    @Override
    public Rol aceptar(Visitante visitante) {
        return visitante.visitar(this);
    }
}
