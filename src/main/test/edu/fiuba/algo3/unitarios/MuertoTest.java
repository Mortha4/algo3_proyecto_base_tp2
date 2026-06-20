package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.excepciones.SeleccionInvalidaException;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Muerto;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MuertoTest {
    @Test
    public void test01UnEstadoMuertoNoEstaVivo() {
        // Arrange
        Muerto muerto = new Muerto();

        // Act y Assert
        assertFalse(muerto.estaVivo(),
                "Un estado muerto no debería estar vivo");
    }

    @Test
    public void test02UnEstadoMuertoNoPuedeCrearCandidato() {
        // Arrange
        Muerto muerto = new Muerto();
        Jugador jugador = new Jugador(new Ciudadano(), "ciudadano");

        // Act y Assert
        assertThrows(SeleccionInvalidaException.class, () -> muerto.crearCandidato(jugador),
                "Un estado muerto no debería poder crear candidatos");
    }

    @Test
    public void test03UnEstadoMuertoNoPuedeRealizarAccionNocturna() {
        // Arrange
        Muerto muerto = new Muerto();
        Jugador jugador = new Jugador(new Ciudadano(), "ciudadano");

        // Act y Assert
        assertThrows(SeleccionInvalidaException.class,
                () -> muerto.accionNocturna(new FaseNocturna(), jugador, jugador, new Ciudadano()),
                "Un estado muerto no debería poder realizar acciones nocturnas");
    }

    @Test
    public void test04UnEstadoMuertoNoPuedeRealizarAccionDiurna() {
        // Arrange
        Muerto muerto = new Muerto();
        Jugador jugador = new Jugador(new Ciudadano(), "ciudadano");

        // Act y Assert
        assertThrows(SeleccionInvalidaException.class,
                () -> muerto.accionDiurna(new FaseDiurna(), jugador, jugador, new Ciudadano()),
                "Un estado muerto no debería poder realizar acciones diurnas");
    }

    @Test
    public void test05UnEstadoMuertoNoPuedeVotar() {
        // Arrange
        Muerto muerto = new Muerto();
        Jugador jugador = new Jugador(new Ciudadano(), "ciudadano");

        // Act y Assert
        assertThrows(SeleccionInvalidaException.class,
                () -> muerto.votar(new FaseDiurna(), jugador, jugador, new Ciudadano()),
                "Un estado muerto no debería poder votar");
    }
}
