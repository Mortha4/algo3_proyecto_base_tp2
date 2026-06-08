package edu.fiuba.algo3.modelo.visitors;

import edu.fiuba.algo3.modelo.roles.*;

public interface Visitante {
    RolVisitable visitar(RolVisitable rol);
    RolVisitable visitar(Mafioso mafioso);
    RolVisitable visitar(Padrino padrino);
    RolVisitable visitar(Ciudadano ciudadano);
    RolVisitable visitar(Medico medico);
    RolVisitable visitar(Detective detective);
    RolVisitable visitar(Sheriff sheriff);

}
