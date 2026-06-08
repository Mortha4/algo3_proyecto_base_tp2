package edu.fiuba.algo3.modelo.roles;
import edu.fiuba.algo3.modelo.visitors.Visitante;

public interface RolVisitable {
    RolVisitable aceptar(Visitante visitante);
}
