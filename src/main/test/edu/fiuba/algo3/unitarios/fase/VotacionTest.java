package edu.fiuba.algo3.unitarios.fase;
import edu.fiuba.algo3.modelo.fase.Candidato;
import edu.fiuba.algo3.modelo.fase.Votacion;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Mafioso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class VotacionTest {
    private Jugador ciudadano1;
    private Jugador mafioso;
    private Votacion votacion;

    @BeforeEach
    public void arrange() {
        ciudadano1 = new Jugador(new Ciudadano(), "ciudadano1");
        mafioso = new Jugador(new Mafioso(), "mafioso");
        votacion = new Votacion();
    }

    public void agregarCandidatos(Jugador ...jugadores){
        Jugador nominador = new Jugador(new Ciudadano(), "nominador");
        for(Jugador jugador: jugadores){
            votacion.agregarCandidato(nominador, jugador);
        }
    }

    @Test
    public void test01UnaVotacionSinVotosDevuelveSetVacio() {
        // Act
        Set<Candidato> result = votacion.obtenerMasVotado();

        // Assert
        assertTrue(result.isEmpty(),
                "Una votación sin votos debería devolver un candidato nulo");
    }

    @Test
    public void test02ObtieneElCandidatoMasVotado() {
        // Act
        agregarCandidatos(mafioso, ciudadano1);
        votacion.registrarVoto(mafioso);
        votacion.registrarVoto(mafioso);
        votacion.registrarVoto(ciudadano1);

        // Assert
        assertEquals(new Candidato(mafioso), votacion.obtenerMasVotado().iterator().next(),
                "Se debería obtener el candidato con más votos");
    }

    @Test
    public void test03UnaVotacionEmpatadaSinPrioritarioNoTieneDecision() {
        // Act
        agregarCandidatos(mafioso, ciudadano1);
        votacion.registrarVoto(mafioso);
        votacion.registrarVoto(ciudadano1);
        Set<Candidato> masVotados = votacion.obtenerMasVotado();

        // Assert
        assertTrue(masVotados.containsAll(Set.of(new Candidato(mafioso), new Candidato(ciudadano1))),
                "Una votación empatada sin voto prioritario no debería tener decisión");
    }

    @Test
    public void test04ElVotoPrioritarioDesempataLaVotacion() {
        // Act
        agregarCandidatos(mafioso, ciudadano1);
        votacion.registrarVoto(mafioso);
        votacion.registrarVotoPrioritario(ciudadano1);

        // Assert
        assertEquals(new Candidato(ciudadano1), votacion.obtenerMasVotado().iterator().next(),
                "El voto prioritario debería desempatar la votación");
    }

    @Test
    public void test05BuscarCandidatoDevuelveElCandidatoExistente() {
        // Arrange
        agregarCandidatos(mafioso);
        votacion.registrarVoto(mafioso);

        // Act
        Candidato result = votacion.buscarCandidato(mafioso);

        // Assert
        assertEquals(new Candidato(mafioso), result,
                "Se debería encontrar el candidato ya registrado para el objetivo");
    }
}
