package edu.fiuba.algo3.modelo.roles;
import edu.fiuba.algo3.modelo.visitors.Visitante;
import edu.fiuba.algo3.modelo.visitors.VisitanteDetective;

public class Detective extends Rol implements RolVisitable{
    public Detective(){
        this.visitante = new VisitanteDetective();
    }
    @Override
    public RolVisitable aceptar(Visitante visitante) {
        return visitante.visitar(this);

    }

    public String getTipo() {
        return "Detective";
    }

}
