package edu.fiuba.algo3.modelo.mazo;
import edu.fiuba.algo3.modelo.excepciones.CantidadDeJugadoresException;

public class CreadorDeConfiguracion {
    // TODO: CONFIGURACION MANUAL
    public static CreadorDeMazo crearConfigAutomatica(int cantidadDeJugadores){
        if (cantidadDeJugadores < 5 || cantidadDeJugadores > 12) {
            throw new CantidadDeJugadoresException();
        }
        if(cantidadDeJugadores <= 6) {
            return new Pequenia(cantidadDeJugadores);
        } else if (cantidadDeJugadores <= 9 ) {
            return new Mediana(cantidadDeJugadores);
        } else {
            return new Grande(cantidadDeJugadores);
        }
    }
}