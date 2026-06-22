package edu.fiuba.algo3.modelo.mazo;
import edu.fiuba.algo3.modelo.excepciones.CantidadDeJugadoresException;

public class CreadorDeConfiguracion {
    public static ConfiguracionDeMazo crearConfig(int cantidadDeJugadores){
        if (cantidadDeJugadores < 5 || cantidadDeJugadores > 12) {
            throw new CantidadDeJugadoresException();
        }
        if(cantidadDeJugadores <= 6) {
            return new Pequenia();
        } else if (cantidadDeJugadores <= 9 ) {
            return new Mediana();
        } else {
            return new Grande();
        }
    }
}