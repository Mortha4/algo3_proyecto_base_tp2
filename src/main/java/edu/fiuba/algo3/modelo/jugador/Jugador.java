package edu.fiuba.algo3.modelo.jugador;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones.CondicionDeVictoria;
import edu.fiuba.algo3.modelo.fase.Candidato;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.excepciones.NoVisibleException;
import edu.fiuba.algo3.modelo.roles.Rol;

import java.util.Objects;

public class Jugador {
    private final Rol rol;
    private final String nombre;
    private Estado estado;

    public Jugador(Rol rol, String nombre) {
        this.rol = rol;
        this.nombre = nombre;
        this.estado = new Vivo();
    }

    public Rol verRol(Jugador otroJugador){
        if(otroJugador.equals(this)){
            return rol;
        }

        throw new NoVisibleException();
    }

    public void contarRol(CondicionDeVictoria condicion){
        estado.contar(condicion, rol);
    }

    public Rol verBando(Jugador otroJugador){
        return otroJugador.compararCon(this.rol);
    }

    public Rol compararCon(Rol rol){
        return rol.verBando(this.rol);
    }

    public boolean tieneMismoRol(Jugador otroJugador){
        return otroJugador.tieneMismoRol(this.rol);
    }

    public boolean tieneMismoRol(Rol rol){
        return this.rol.equals(rol);
    }

    public void morir() {
        this.estado = new Muerto();
    }

    public boolean estaVivo() {
        return this.estado.estaVivo();
    }

    public void accion(FaseNocturna faseNocturna, Jugador objetivo){
        estado.accion(faseNocturna, this, objetivo, rol);
    }

    public Candidato crearCandidato(Jugador otroJugador){
        return estado.crearCandidato(otroJugador);
    }

    public Candidato devolverCandidato(Jugador jugador){
        return estado.devolverCandidato(jugador);
    }

    public void accion(FaseDiurna faseDiurna, Jugador objetivo){
        estado.accion(faseDiurna, this, objetivo, rol);
    }

    public void votar(FaseDiurna fase, Jugador votado) {
        estado.votar(fase, this, votado, rol);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return Objects.equals(rol, jugador.rol) && Objects.equals(nombre, jugador.nombre);
    }
}
