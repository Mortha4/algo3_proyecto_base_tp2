package edu.fiuba.algo3.modelo.roles;
import edu.fiuba.algo3.modelo.acciones.AccionNocturna;
import edu.fiuba.algo3.modelo.acciones.Votar;
import edu.fiuba.algo3.modelo.acciones.VotarNocturno;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.acciones.AccionDiurna;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.visitors.Visitante;
import edu.fiuba.algo3.modelo.visitors.VisitanteMafioso;

public class Mafioso extends Rol {
    public Mafioso() {
        visitante = new VisitanteMafioso();
    }

    @Override
    public Rol aceptar(Visitante visitante) {
        return visitante.visitar(this);
    }

    @Override
    public AccionNocturna accionNocturna(FaseNocturna fase, Jugador base, Jugador objetivo) {
        return new VotarNocturno(fase, base, objetivo);
    }
    @Override
    public AccionDiurna accionDiurna(FaseDiurna fase, Jugador base, Jugador objetivo) {
        return new Votar(fase, base, objetivo);
    }

    @Override
    public boolean equals(Object o) {
        return o != null && this.getClass() == o.getClass();
    }
}
