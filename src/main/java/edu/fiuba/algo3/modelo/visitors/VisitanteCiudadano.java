package edu.fiuba.algo3.modelo.visitors;

import edu.fiuba.algo3.modelo.excepciones.NoVisible;
import edu.fiuba.algo3.modelo.roles.*;

public class VisitanteCiudadano implements Visitante{

    @Override
    public RolVisitable visitar(RolVisitable rol) {
        return rol.aceptar(this);
    }

    @Override
    public RolVisitable visitar(Mafioso mafioso) {
        throw new NoVisible();
    }

    @Override
    public RolVisitable visitar(Padrino padrino) {
        throw new NoVisible();
    }

    @Override
    public RolVisitable visitar(Ciudadano ciudadano) {
        throw new NoVisible();
    }

    @Override
    public RolVisitable visitar(Medico medico) {
        throw new NoVisible();
    }

    @Override
    public RolVisitable visitar(Detective detective) {
        throw new NoVisible();
    }

    @Override
    public RolVisitable visitar(Sheriff sheriff) {
        throw new NoVisible();
    }
}
