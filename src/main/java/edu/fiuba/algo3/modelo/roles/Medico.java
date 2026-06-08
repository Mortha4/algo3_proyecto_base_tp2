package edu.fiuba.algo3.modelo.roles;

import edu.fiuba.algo3.modelo.visitors.Visitante;

public class Medico implements Rol, RolVisitable {
    @Override
    public RolVisitable aceptar(Visitante visitante) {
        return visitante.visitar(this);
    }
}
