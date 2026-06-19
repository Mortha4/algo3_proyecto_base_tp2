package edu.fiuba.algo3.modelo.jugador;
import edu.fiuba.algo3.modelo.acciones.Votar;
import edu.fiuba.algo3.modelo.fase.*;
import edu.fiuba.algo3.modelo.roles.Rol;

public class Vivo implements Estado {
    public Candidato crearCandidato(Jugador otroJugador){
        return otroJugador.devolverCandidato(otroJugador);
    }

    public Candidato devolverCandidato(Jugador jugador){
        return new Candidato(jugador);
    }

    public void accionNocturna(FaseNocturna faseNocturna, Jugador ejecutor, Jugador objetivo, Rol rol){
        faseNocturna.ejecutar(rol.accionNocturna(faseNocturna, ejecutor, objetivo));
    }

    public void accionDiurna(FaseDiurna fase, Jugador ejecutor, Jugador objetivo, Rol rol){
        fase.ejecutar(rol.accionDiurna(fase, ejecutor, objetivo));
    }

    public boolean estaVivo(){return true;}
}
