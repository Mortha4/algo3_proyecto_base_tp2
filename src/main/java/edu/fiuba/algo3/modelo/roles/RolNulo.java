package edu.fiuba.algo3.modelo.roles;

import edu.fiuba.algo3.modelo.acciones.AccionDiurna;
import edu.fiuba.algo3.modelo.acciones.AccionNocturna;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones.CondicionDeVictoria;
import edu.fiuba.algo3.modelo.excepciones.RolNuloException;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.visitors.Visitante;

public class RolNulo extends Rol {
    @Override
    public Rol aceptar(Visitante visitante) {
        throw new RolNuloException();
    }

    public void contarRol(CondicionDeVictoria condicion) {
        condicion.contar(this);
    }

    @Override
    public AccionNocturna accionNocturna(FaseNocturna faseNocturna, Jugador base, Jugador objetivo) {
        throw new RolNuloException();
    }

    @Override
    public AccionDiurna accionDiurna(FaseDiurna fase, Jugador base, Jugador objetivo) {
        throw new RolNuloException();
    }
}
