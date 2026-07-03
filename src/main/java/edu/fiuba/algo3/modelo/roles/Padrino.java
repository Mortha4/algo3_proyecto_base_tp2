package edu.fiuba.algo3.modelo.roles;
import edu.fiuba.algo3.modelo.acciones.*;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones.CondicionDeVictoria;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.visitors.Visitante;
import edu.fiuba.algo3.modelo.visitors.VisitanteMafioso;

public class Padrino extends Rol {
    public Padrino() {
        visitante = new VisitanteMafioso();
    }

    @Override
    public Rol aceptar(Visitante visitante) {
        return visitante.visitar(this);
    }

    @Override
    public Accion accion(FaseNocturna faseNocturna, Jugador base, Jugador objetivo) {
        return new VotarPrioritario(faseNocturna, base, objetivo);
    }

    public void contarRol(CondicionDeVictoria condicion) {
        condicion.contar(this);
    }

    @Override
    public Accion accion(FaseDiurna fase, Jugador base, Jugador objetivo) {
        return new NoActuar();
    }
}
