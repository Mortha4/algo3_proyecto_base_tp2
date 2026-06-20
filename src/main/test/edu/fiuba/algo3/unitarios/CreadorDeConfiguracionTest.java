package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.excepciones.CantidadDeJugadoresException;
import edu.fiuba.algo3.modelo.mazo.CreadorDeConfiguracion;
import edu.fiuba.algo3.modelo.mazo.CreadorDeMazo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CreadorDeConfiguracionTest {
    @Test
    public void test01SeCreaConfiguracionConExactamente5Jugadores() {
        // Arrange
        final int cantidadDeJugadores = 5;
        CreadorDeMazo configuracion = CreadorDeConfiguracion.crearConfigAutomatica(cantidadDeJugadores);

        // Act
        final int result = configuracion.obtenerRoles().size();

        // Assert
        assertEquals(cantidadDeJugadores, result,
                "Se debería crear una configuración con 5 jugadores");
    }

    @Test
    public void test02SeCreaConfiguracionConExactamente12Jugadores() {
        // Arrange
        final int cantidadDeJugadores = 12;
        CreadorDeMazo configuracion = CreadorDeConfiguracion.crearConfigAutomatica(cantidadDeJugadores);

        // Act
        final int result = configuracion.obtenerRoles().size();

        // Assert
        assertEquals(cantidadDeJugadores, result,
                "Se debería crear una configuración con 12 jugadores");
    }

    @Test
    public void test03NoSeCreaConfiguracionCon4Jugadores() {
        // Arrange
        final int cantidadDeJugadores = 4;

        // Act y Assert
        assertThrows(CantidadDeJugadoresException.class, () -> CreadorDeConfiguracion.crearConfigAutomatica(cantidadDeJugadores),
                "No se debería crear una configuración con 4 jugadores");
    }

    @Test
    public void test04NoSeCreaConfiguracionCon13Jugadores() {
        // Arrange
        final int cantidadDeJugadores = 13;

        // Act y Assert
        assertThrows(CantidadDeJugadoresException.class, () -> CreadorDeConfiguracion.crearConfigAutomatica(cantidadDeJugadores),
                "No se debería crear una configuración con 13 jugadores");
    }
}
