package edu.fiuba.algo3.modelo.visitors;

import edu.fiuba.algo3.modelo.roles.*;

public interface Visitante {
    Rol visitar(Rol rol);
    Rol visitar(Mafioso mafioso);
    Rol visitar(Padrino padrino);
    Rol visitar(Ciudadano ciudadano);
    Rol visitar(Medico medico);
    Rol visitar(Detective detective);
    Rol visitar(Sheriff sheriff);

}
