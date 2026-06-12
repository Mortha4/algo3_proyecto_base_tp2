package edu.fiuba.algo3.modelo.visitors;

import edu.fiuba.algo3.modelo.roles.*;

public class VisitanteDetective implements Visitante {
    @Override
    public Rol visitar(Rol rol) {
        return rol.aceptar(this);
    }

    @Override
    public Rol visitar(Mafioso mafioso) {
        return new Mafioso();
    }

    @Override
    public Rol visitar(Padrino padrino) {
        return new Ciudadano();
    }

    @Override
    public Rol visitar(Ciudadano ciudadano) {
        return new Ciudadano();
    }

    @Override
    public Rol visitar(Medico medico) {
        return new Ciudadano();
    }

    @Override
    public Rol visitar(Detective detective) {
        return new Ciudadano();
    }

    @Override
    public Rol visitar(Sheriff sheriff) {
        return new Ciudadano();
    }
}
