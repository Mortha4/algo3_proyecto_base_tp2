package edu.fiuba.algo3.modelo.roles;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.comandos.Command;
import edu.fiuba.algo3.modelo.comandos.Investigar;
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
    public Command accionNocturna(FaseNocturna fase, Jugador base, Jugador objetivo) {
        return new Investigar(fase, base, objetivo);
    }

}
