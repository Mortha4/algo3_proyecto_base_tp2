package edu.fiuba.algo3.unitarios.fase;

import edu.fiuba.algo3.modelo.excepciones.NoHuboDecisionException;
import edu.fiuba.algo3.modelo.fase.Candidato;
import edu.fiuba.algo3.modelo.fase.CandidatoNulo;
import edu.fiuba.algo3.modelo.fase.Votacion;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Mafioso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VotacionTest {
    private Jugador ciudadano1;
    private Jugador ciudadano2;
    private Jugador mafioso;
    private Votacion votacion;

    @BeforeEach
    public void arrange() {
        ciudadano1 = new Jugador(new Ciudadano(), "ciudadano1");
        ciudadano2 = new Jugador(new Ciudadano(), "ciudadano2");
        mafioso = new Jugador(new Mafioso(), "mafioso");
        votacion = new Votacion();
    }

    @Test
    public void test01UnaVotacionSinVotosDevuelveCandidatoNulo() {
        // Act
        Candidato result = votacion.obtenerMasVotado();

        // Assert
        assertEquals(new CandidatoNulo(), result,
                "Una votación sin votos debería devolver un candidato nulo");
    }

    @Test
    public void test02ObtieneElCandidatoMasVotado() {
        // Act
        votacion.registrarVoto(ciudadano1, mafioso);
        votacion.registrarVoto(ciudadano2, mafioso);
        votacion.registrarVoto(mafioso, ciudadano1);

        // Assert
        assertEquals(new Candidato(mafioso), votacion.obtenerMasVotado(),
                "Se debería obtener el candidato con más votos");
    }

    @Test
    public void test03UnaVotacionEmpatadaSinPrioritarioNoTieneDecision() {
        // Act
        votacion.registrarVoto(ciudadano1, mafioso);
        votacion.registrarVoto(mafioso, ciudadano1);

        // Assert
        assertThrows(NoHuboDecisionException.class, votacion::obtenerMasVotado,
                "Una votación empatada sin voto prioritario no debería tener decisión");
    }

    @Test
    public void test04ElVotoPrioritarioDesempataLaVotacion() {
        // Act
        votacion.registrarVoto(ciudadano1, mafioso);
        votacion.registrarVotoPrioritario(mafioso, ciudadano1);

        // Assert
        assertEquals(new Candidato(ciudadano1), votacion.obtenerMasVotado(),
                "El voto prioritario debería desempatar la votación");
    }

    @Test
    public void test05BuscarCandidatoDevuelveElCandidatoExistente() {
        // Arrange
        votacion.registrarVoto(ciudadano1, mafioso);

        // Act
        Candidato result = votacion.buscarCandidato(ciudadano2, mafioso);

        // Assert
        assertEquals(new Candidato(mafioso), result,
                "Se debería encontrar el candidato ya registrado para el objetivo");
    }
}
