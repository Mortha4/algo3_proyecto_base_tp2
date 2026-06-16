package edu.fiuba.algo3.modelo.roles;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.comandos.Command;
import edu.fiuba.algo3.modelo.comandos.Votar;
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
    public Command accionNocturna(FaseNocturna faseNocturna, Jugador base, Jugador objetivo) {
        return new Votar(faseNocturna, base, objetivo);
    }
}
