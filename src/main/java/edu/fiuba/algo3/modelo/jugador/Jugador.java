package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.comandos.Votar;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.excepciones.NoVisibleException;
import edu.fiuba.algo3.modelo.roles.Rol;

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

    public void verBando(Jugador otroJugador){
        rol.verBando(otroJugador.rol);
    }

    public void morir() {
        this.estado = new Muerto();
    }

    public boolean estaVivo() {
        return this.estado.estaVivo();
    }

    public void accionNocturna(FaseNocturna faseNocturna, Jugador objetivo){
        faseNocturna.ejecutar(rol.accionNocturna(faseNocturna, this, objetivo));
    }

    public void accionDiurna(FaseDiurna faseDiurna, Jugador objetivo){
        faseDiurna.ejecutar(new Votar(faseDiurna, this, objetivo));
    }
}
