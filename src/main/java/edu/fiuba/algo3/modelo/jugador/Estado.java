package edu.fiuba.algo3.modelo.jugador;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones.CondicionDeVictoria;
import edu.fiuba.algo3.modelo.fase.*;
import edu.fiuba.algo3.modelo.roles.Rol;

public interface Estado {
    boolean estaVivo();
    Candidato crearCandidato(Jugador otroJugador);
    Candidato devolverCandidato(Jugador otroJugador);
    void accion(FaseNocturna faseNocturna, Jugador ejecutor, Jugador objetivo, Rol rol);
    void accion(FaseDiurna faseDiurna, Jugador ejecutor, Jugador objetivo, Rol rol);
    void votar(FaseDiurna fase, Jugador votante, Jugador votado, Rol rol);
    void contar(CondicionDeVictoria condicion, Rol rol);
}
