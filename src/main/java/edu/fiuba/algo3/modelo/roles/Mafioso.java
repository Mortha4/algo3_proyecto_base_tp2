package edu.fiuba.algo3.modelo.roles;
import edu.fiuba.algo3.modelo.visitors.Visitante;
import edu.fiuba.algo3.modelo.visitors.VisitanteMafioso;

public class Mafioso extends Rol {
    public Mafioso(){
        visitante = new VisitanteMafioso();
    }

    public String getTipo() {
        return "Mafioso";
    }

    @Override
    public Rol aceptar(Visitante visitante) {
        return visitante.visitar(this);
    }
}
