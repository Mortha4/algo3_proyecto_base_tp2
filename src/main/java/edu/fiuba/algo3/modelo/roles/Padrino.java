package edu.fiuba.algo3.modelo.roles;
import edu.fiuba.algo3.modelo.FaseNocturna.FaseNocturna;
import edu.fiuba.algo3.modelo.comandos.Command;
import edu.fiuba.algo3.modelo.comandos.VotarPrioritarioNocturno;
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
    public Command accionNocturna(FaseNocturna faseNocturna, Jugador base, Jugador objetivo) {
        return new VotarPrioritarioNocturno(faseNocturna, base, objetivo);
    }
}
