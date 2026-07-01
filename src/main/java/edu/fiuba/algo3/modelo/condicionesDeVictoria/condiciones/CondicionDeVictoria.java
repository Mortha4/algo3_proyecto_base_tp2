package edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones;
import edu.fiuba.algo3.modelo.excepciones.SinJugadoresException;
import edu.fiuba.algo3.modelo.excepciones.TodosEstanMuertosException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.*;
import edu.fiuba.algo3.vistas.Notificable;

import java.util.List;

public abstract class CondicionDeVictoria {
    protected int cantidadDeMafiososVivos = 0;
    protected int cantidadDeCiudadanosVivos = 0;
    private final List<Jugador> jugadores;

    protected CondicionDeVictoria(List<Jugador> jugadores){
        if(jugadores.isEmpty()){
            throw new SinJugadoresException();
        }

        this.jugadores = jugadores;
        contarRoles();

        if(cantidadDeCiudadanosVivos == 0 && cantidadDeMafiososVivos == 0){
            throw new TodosEstanMuertosException();
        }
    }

    protected void contarRoles(){
        cantidadDeMafiososVivos = 0;
        cantidadDeCiudadanosVivos = 0;
        for(Jugador j: jugadores){
            j.contarRol(this);
        }
    }

    public void contar(Rol rol) {
        rol.contarRol(this);
    }

    public void contar(Mafioso ignored) {
        cantidadDeMafiososVivos++;
    }

    public void contar(Padrino ignored) {
        cantidadDeMafiososVivos++;
    }

    public void contar(Ciudadano ignored) {
        cantidadDeCiudadanosVivos++;
    }

    public void contar(Medico ignored) {
        cantidadDeCiudadanosVivos++;
    }

    public void contar(Detective ignored) {
        cantidadDeCiudadanosVivos++;
    }

    public void contar(Sheriff ignored) {
        cantidadDeCiudadanosVivos++;
    }

    public void contar(RolNulo ignored){}

    protected abstract void chequearCondicion(List<Notificable> notificables);

    public void chequear(List<Notificable> notificables){
        contarRoles();
        chequearCondicion(notificables);
    }
}
