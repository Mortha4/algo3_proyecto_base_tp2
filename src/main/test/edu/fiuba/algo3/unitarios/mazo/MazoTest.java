package edu.fiuba.algo3.unitarios.mazo;

import edu.fiuba.algo3.modelo.excepciones.CantidadDeJugadoresException;
import edu.fiuba.algo3.modelo.excepciones.NoHayMasCartasException;
import edu.fiuba.algo3.modelo.mazo.Mazo;
import edu.fiuba.algo3.modelo.roles.Rol;
import edu.fiuba.algo3.modelo.roles.Sheriff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MazoTest {
    private Mazo mazo;
    private int cantidadDeCartas;

    @BeforeEach
    public void arrange() {
        cantidadDeCartas = 10;
        mazo = new Mazo(cantidadDeCartas);
    }

    @Test
    public void test01SeCreaMazoConLaCantidadDeCartasIndicada() {
        // Arrange
        final int cantidadDeCartas = 10;

        // Act
        Mazo mazo = new Mazo(cantidadDeCartas);

        // Assert
        assertEquals(cantidadDeCartas, mazo.getRoles().size(),
                "Se debería crear un mazo con " + cantidadDeCartas + " cartas");
    }

    @Test
    public void test02NoSeCreaMazoConCantidadInvalidaDeCartas() {
        // Arrange
        final int cantidadDeCartas = 4;

        // Act y Assert
        assertThrows(CantidadDeJugadoresException.class, () -> new Mazo(cantidadDeCartas),
                "No se debería crear un mazo con " + cantidadDeCartas + " cartas");
    }

    @Test
    public void test03AgarrarCartaDevuelveLaPrimeraCartaDelMazo() {
        // Arrange
        Rol primeraCarta = mazo.getRoles().get(0);

        // Act
        Rol cartaObtenida = mazo.agarrarCarta();

        // Assert
        assertEquals(primeraCarta, cartaObtenida,
                "Se debería obtener la primera carta del mazo");
    }

    @Test
    public void test04AgarrarCartaQuitaLaCartaDelMazo() {
        // Arrange
        final int cantidadDeCartasLuegoDeAgarrarUna = 9;

        // Act
        mazo.agarrarCarta();

        // Assert
        assertEquals(cantidadDeCartasLuegoDeAgarrarUna, mazo.getRoles().size(),
                "Se debería quitar una carta del mazo");
        assertFalse(mazo.getRoles().contains(new Sheriff()),
                "La primera carta ya no debería estar en el mazo");
    }

    @Test
    public void test05AgarrarCartaDeMazoVacioLanzaExcepcion() {
        for(int i = 0; i < cantidadDeCartas; i++) {
            mazo.agarrarCarta();
        }

        // Act y Assert
        assertThrows(NoHayMasCartasException.class, mazo::agarrarCarta,
                "No se debería poder agarrar una carta de un mazo vacío");
    }

    @Test
    public void test06MezclarCambiaElOrdenDeLasCartas() {
        // Arrange
        List<Rol> rolesOriginales = mazo.getRoles();

        // Act
        mazo.mezclar();

        // Assert
        assertNotEquals(rolesOriginales, mazo.getRoles(),
                "Se debería cambiar el orden de las cartas al mezclar");
    }

    @Test
    public void test07MezclarMantieneLaCantidadDeCartas() {
        // Act
        mazo.mezclar();

        // Assert
        assertEquals(cantidadDeCartas, mazo.getRoles().size(),
                "Se debería mantener la cantidad de cartas al mezclar");
    }

    @Test
    public void test08NoSePuedeModificarElMazoDesdeLosRolesObtenidos() {
        // Arrange
        List<Rol> roles = mazo.getRoles();

        // Act y Assert
        assertThrows(UnsupportedOperationException.class, () -> roles.add(new Sheriff()),
                "No se debería poder modificar el mazo desde los roles obtenidos");
    }
}
