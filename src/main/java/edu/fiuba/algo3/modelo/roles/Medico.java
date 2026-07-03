package edu.fiuba.algo3.modelo.roles;
import edu.fiuba.algo3.modelo.acciones.*;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones.CondicionDeVictoria;
import edu.fiuba.algo3.modelo.fase.*;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.visitors.Visitante;
import edu.fiuba.algo3.modelo.visitors.VisitanteCiudadano;

public class Medico extends Rol {
    public Medico() {
        visitante = new VisitanteCiudadano();
    }

    @Override
    public Rol aceptar(Visitante visitante) {
        return visitante.visitar(this);
    }

    @Override
    public Accion accion(FaseNocturna faseNocturna, Jugador base, Jugador objetivo) {
        return new Proteger(faseNocturna, objetivo);
    }

    public void contarRol(CondicionDeVictoria condicion) {
        condicion.contar(this);
    }

    @Override
    public Accion accion(FaseDiurna fase, Jugador base, Jugador objetivo) {
        return new NoActuar();
    }
}
