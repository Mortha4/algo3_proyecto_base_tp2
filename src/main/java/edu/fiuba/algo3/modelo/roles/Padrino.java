package edu.fiuba.algo3.modelo.roles;
import edu.fiuba.algo3.modelo.visitors.Visitante;
import edu.fiuba.algo3.modelo.visitors.VisitanteMafioso;

public class Padrino extends Rol implements RolVisitable{
    public Padrino(){
        visitante = new VisitanteMafioso();
    }
    @Override
    public RolVisitable aceptar(Visitante visitante) {
        return visitante.visitar(this);
    }
}
