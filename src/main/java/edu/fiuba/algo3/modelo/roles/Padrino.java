package edu.fiuba.algo3.modelo.roles;
import edu.fiuba.algo3.modelo.visitors.Visitante;
import edu.fiuba.algo3.modelo.visitors.VisitanteMafioso;

public class Padrino extends Rol {
    public Padrino(){
        visitante = new VisitanteMafioso();
    }


    public String getTipo() {
        return "Padrino";
    }
    @Override
    public Rol aceptar(Visitante visitante) {
        return visitante.visitar(this);
    }
}
