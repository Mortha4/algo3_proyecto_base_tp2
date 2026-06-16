package edu.fiuba.algo3.modelo.roles;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.comandos.Command;
import edu.fiuba.algo3.modelo.comandos.Proteger;
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
    public Command accionNocturna(FaseNocturna faseNocturna, Jugador base, Jugador objetivo) {
        return new Proteger(faseNocturna, objetivo);
    }
}
