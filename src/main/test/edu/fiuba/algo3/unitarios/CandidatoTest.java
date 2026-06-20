package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.fase.Candidato;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Mafioso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CandidatoTest {
    @Test
    public void test01UnCandidatoRecienCreadoNoTieneVotos() {
        // Arrange
        Candidato candidato = new Candidato(new Jugador(new Ciudadano(), "ciudadano"));

        // Act y Assert
        assertTrue(candidato.empataCon(0),
                "Un candidato recién creado debería tener 0 votos");
    }

    @Test
    public void test02SumarVotoIncrementaLosVotosDelCandidato() {
        // Arrange
        Candidato candidato = new Candidato(new Jugador(new Ciudadano(), "ciudadano"));

        // Act
        candidato.sumarVoto();

        // Assert
        assertTrue(candidato.esMasVotadoQue(0),
                "Un candidato con un voto debería superar a uno con cero votos");
    }

    @Test
    public void test03DosCandidatosDelMismoJugadorSonIguales() {
        // Arrange
        Jugador jugador = new Jugador(new Ciudadano(), "ciudadano");

        // Act
        Candidato candidato = new Candidato(jugador);
        Candidato otroCandidato = new Candidato(jugador);

        // Assert
        assertEquals(candidato, otroCandidato,
                "Dos candidatos creados con el mismo jugador deberían ser iguales");
    }

    @Test
    public void test04DosCandidatosDeDistintosJugadoresNoSonIguales() {
        // Arrange
        Candidato candidato = new Candidato(new Jugador(new Ciudadano(), "ciudadano"));
        Candidato otroCandidato = new Candidato(new Jugador(new Mafioso(), "mafioso"));

        // Act y Assert
        assertNotEquals(candidato, otroCandidato,
                "Dos candidatos de distintos jugadores no deberían ser iguales");
    }

    @Test
    public void test05MorirMataAlJugadorDelCandidato() {
        // Arrange
        Jugador jugador = new Jugador(new Ciudadano(), "ciudadano");
        Candidato candidato = new Candidato(jugador);

        // Act
        candidato.morir();

        // Assert
        assertFalse(jugador.estaVivo(),
                "Al morir un candidato debería morir su jugador");
    }
}
