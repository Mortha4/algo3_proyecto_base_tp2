package edu.fiuba.algo3.modelo.visitors;

import edu.fiuba.algo3.modelo.roles.*;

public class VisitanteDetective implements Visitante {
    @Override
    public RolVisitable visitar(RolVisitable rol) {
        return rol.aceptar(this);
    }

    @Override
    public RolVisitable visitar(Mafioso mafioso) {
        return new Mafioso();
    }

    @Override
    public RolVisitable visitar(Padrino padrino) {
        return new Ciudadano();
    }

    @Override
    public RolVisitable visitar(Ciudadano ciudadano) {
        return new Ciudadano();
    }

    @Override
    public RolVisitable visitar(Medico medico) {
        return new Ciudadano();
    }

    @Override
    public RolVisitable visitar(Detective detective) {
        return new Ciudadano();
    }

    @Override
    public RolVisitable visitar(Sheriff sheriff) {
        return new Ciudadano();
    }
}
