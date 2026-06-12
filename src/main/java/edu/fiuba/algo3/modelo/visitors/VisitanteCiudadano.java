package edu.fiuba.algo3.modelo.visitors;

import edu.fiuba.algo3.modelo.excepciones.NoVisible;
import edu.fiuba.algo3.modelo.roles.*;

public class VisitanteCiudadano implements Visitante{

    @Override
    public Rol visitar(Rol rol) {
        return rol.aceptar(this);
    }

    @Override
    public Rol visitar(Mafioso mafioso) {
        throw new NoVisible();
    }

    @Override
    public Rol visitar(Padrino padrino) {
        throw new NoVisible();
    }

    @Override
    public Rol visitar(Ciudadano ciudadano) {
        throw new NoVisible();
    }

    @Override
    public Rol visitar(Medico medico) {
        throw new NoVisible();
    }

    @Override
    public Rol visitar(Detective detective) {
        throw new NoVisible();
    }

    @Override
    public Rol visitar(Sheriff sheriff) {
        throw new NoVisible();
    }
}
