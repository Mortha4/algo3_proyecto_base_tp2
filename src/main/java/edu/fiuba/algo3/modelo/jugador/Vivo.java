package edu.fiuba.algo3.modelo.jugador;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones.CondicionDeVictoria;
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

    @Override
    public void votar(FaseDiurna fase, Jugador votante, Jugador votado, Rol rol) {
        fase.ejecutar(rol.votar(fase, votante, votado));
    }

    @Override
    public void contar(CondicionDeVictoria condicion, Rol rol) {
        rol.contarRol(condicion);
    }

    public boolean estaVivo(){return true;}
}
