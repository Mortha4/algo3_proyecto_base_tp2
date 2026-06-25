package edu.fiuba.algo3.modelo.jugador;
import edu.fiuba.algo3.modelo.acciones.Nada;
import edu.fiuba.algo3.modelo.acciones.Nominar;
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

    public void accion(FaseNocturna faseNocturna, Jugador ejecutor, Jugador objetivo, Rol rol){
        faseNocturna.ejecutar(rol.accion(faseNocturna, ejecutor, objetivo));
    }

    public void accion(FaseDiurna fase, Jugador ejecutor, Jugador objetivo, Rol rol){
        fase.ejecutar(rol.accion(fase, ejecutor, objetivo));
    }

    @Override
    public void votar(Fase fase, Jugador votante, Jugador votado, Rol rol) {
        fase.ejecutar(rol.votar(fase, votante, votado));
    }

    @Override
    public void contar(CondicionDeVictoria condicion, Rol rol) {
        rol.contarRol(condicion);
    }

    @Override
    public void noActuar(Fase fase, Jugador jugador) {
        fase.ejecutar(new Nada());
    }

    @Override
    public void nominar(Fase fase, Jugador nominante, Jugador nominado) {
        fase.ejecutar(new Nominar(fase, nominante, nominado));
    }

    @Override
    public void revelarRolPara(FaseDiurna fase, Jugador jugador) {
        fase.setRevelado(jugador);
    }

    public boolean estaVivo(){return true;}
}
