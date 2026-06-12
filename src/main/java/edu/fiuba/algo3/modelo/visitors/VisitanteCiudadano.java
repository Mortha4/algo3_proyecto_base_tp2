package edu.fiuba.algo3.modelo.visitors;

import edu.fiuba.algo3.modelo.excepciones.NoVisibleException;
import edu.fiuba.algo3.modelo.roles.*;

public class VisitanteCiudadano implements Visitante{

    @Override
    public Rol visitar(Rol rol) {
        return rol.aceptar(this);
    }

    @Override
    public Rol visitar(Mafioso mafioso) {
        throw new NoVisibleException();
    }

    @Override
    public Rol visitar(Padrino padrino) {
        throw new NoVisibleException();
    }

    @Override
    public Rol visitar(Ciudadano ciudadano) {
        throw new NoVisibleException();
    }

    @Override
    public Rol visitar(Medico medico) {
        throw new NoVisibleException();
    }

    @Override
    public Rol visitar(Detective detective) {
        throw new NoVisibleException();
    }

    @Override
    public Rol visitar(Sheriff sheriff) {
        throw new NoVisibleException();
    }
}
