package edu.fiuba.algo3.unitarios.jugador;

import edu.fiuba.algo3.modelo.fase.Candidato;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Vivo;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VivoTest {
    @Test
    public void test01UnEstadoVivoEstaVivo() {
        // Arrange
        Vivo vivo = new Vivo();

        // Act y Assert
        assertTrue(vivo.estaVivo(),
                "Un estado vivo debería estar vivo");
    }

    @Test
    public void test02UnEstadoVivoCreaCandidatoDelJugadorIndicado() {
        // Arrange
        Vivo vivo = new Vivo();
        Jugador jugador = new Jugador(new Ciudadano(), "ciudadano");

        // Act
        Candidato result = vivo.crearCandidato(jugador);

        // Assert
        assertEquals(new Candidato(jugador), result,
                "Un estado vivo debería crear un candidato del jugador indicado");
    }
}
