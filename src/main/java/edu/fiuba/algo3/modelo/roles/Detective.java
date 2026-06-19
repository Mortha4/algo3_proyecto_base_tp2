package edu.fiuba.algo3.modelo.roles;
import edu.fiuba.algo3.modelo.acciones.AccionDiurna;
import edu.fiuba.algo3.modelo.acciones.AccionNocturna;
import edu.fiuba.algo3.modelo.acciones.Votar;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.acciones.Investigar;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.visitors.Visitante;
import edu.fiuba.algo3.modelo.visitors.VisitanteDetective;

public class Detective extends Rol {
    public Detective() {
        this.visitante = new VisitanteDetective();
    }

    @Override
    public Rol aceptar(Visitante visitante) {
        return visitante.visitar(this);
    }

    @Override
    public AccionNocturna accionNocturna(FaseNocturna fase, Jugador base, Jugador objetivo) {
        return new Investigar(fase, base, objetivo);
    }
    @Override
    public AccionDiurna accionDiurna(FaseDiurna fase, Jugador base, Jugador objetivo) {
        return new Votar(fase, base, objetivo);
    }

}
