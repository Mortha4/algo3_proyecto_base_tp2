package edu.fiuba.algo3.modelo.roles;
import edu.fiuba.algo3.modelo.visitors.Visitante;
import edu.fiuba.algo3.modelo.visitors.VisitanteMafioso;

public class Mafioso extends Rol implements RolVisitable {
    public Mafioso(){
        visitante = new VisitanteMafioso();
    }

    public String getTipo() {
        return "Mafioso";
    }

    @Override
    public RolVisitable aceptar(Visitante visitante) {
        return visitante.visitar(this);
    }
}
