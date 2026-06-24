package edu.fiuba.algo3.unitarios.acciones;

import edu.fiuba.algo3.modelo.acciones.Nominar;
import edu.fiuba.algo3.modelo.acciones.Votar;
import edu.fiuba.algo3.modelo.excepciones.JugadorNoNominadoException;
import edu.fiuba.algo3.modelo.excepciones.NoHuboDecisionException;
import edu.fiuba.algo3.modelo.excepciones.VotarAlMismoJugadorException;
import edu.fiuba.algo3.modelo.fase.Fase;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Mafioso;
import edu.fiuba.algo3.modelo.roles.Padrino;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VotarTest {
    private FaseDiurna faseDiurna;
    private FaseNocturna faseNocturna;
    private Jugador ciudadano1;
    private Jugador ciudadano2;
    private Jugador mafioso1;
    private Jugador mafioso2;
    private Jugador padrino;

    @BeforeEach
    public void arrange() {
        faseDiurna = new FaseDiurna();
        faseNocturna = new FaseNocturna();
        ciudadano1 = new Jugador(new Ciudadano(), "ciudadano1");
        ciudadano2 = new Jugador(new Ciudadano(), "ciudadano2");
        mafioso1 = new Jugador(new Mafioso(), "mafioso1");
        mafioso2 = new Jugador(new Mafioso(), "mafioso2");
        padrino = new Jugador(new Padrino(), "padrino");
    }

    public void nominarJugadores(Fase fase, Jugador ...jugadores){
        Jugador nominador = new Jugador(new Ciudadano(), "nominador");
        for(Jugador jugador: jugadores){
            fase.ejecutar(new Nominar(fase, nominador, jugador));
        }
    }

    @Test
    public void test01AlEjecutarVotarEnFaseDiurnaNoSeEliminaAlVotadoHastaFinalizarLaFase() {
        // Arrange
        nominarJugadores(faseDiurna, mafioso1);
        Votar votar = new Votar(faseDiurna, ciudadano1, mafioso1);

        // Act
        votar.execute();

        // Assert
        assertTrue(mafioso1.estaVivo(),
                "Ejecutar un voto no debería eliminar al votado antes de finalizar la fase");
    }

    @Test
    public void test02AlFinalizarLaFaseDiurnaSeEliminaAlVotado() {
        // Arrange
        nominarJugadores(faseDiurna, mafioso1);
        Votar votar = new Votar(faseDiurna, ciudadano1, mafioso1);

        // Act
        votar.execute();
        faseDiurna.finalizar();

        // Assert
        assertFalse(mafioso1.estaVivo(),
                "Al finalizar la fase se debería eliminar al jugador votado");
    }

    @Test
    public void test03AlVotarEnFaseDiurnaNoSeEliminaAlVotante() {
        // Arrange
        nominarJugadores(faseDiurna, mafioso1);
        Votar votar = new Votar(faseDiurna, ciudadano1, mafioso1);

        // Act
        votar.execute();
        faseDiurna.finalizar();

        // Assert
        assertTrue(ciudadano1.estaVivo(),
                "El votante no debería ser eliminado por votar a otro jugador");
    }

    @Test
    public void test04EnFaseDiurnaDosVotosAlMismoMafiosoLoEliminanComoMasVotado() {
        // Arrange
        nominarJugadores(faseDiurna, mafioso1, ciudadano1, ciudadano2);
        Votar votoCiudadano1 = new Votar(faseDiurna, ciudadano1, mafioso1);
        Votar votoCiudadano2 = new Votar(faseDiurna, ciudadano2, mafioso1);
        Votar votoMafioso = new Votar(faseDiurna, mafioso1, ciudadano1);
        Votar votoPadrino = new Votar(faseDiurna, padrino, ciudadano2);

        // Act
        votoCiudadano1.execute();
        votoCiudadano2.execute();
        votoMafioso.execute();
        votoPadrino.execute();
        faseDiurna.finalizar();

        // Assert
        assertFalse(mafioso1.estaVivo(),
                "El jugador con más votos debería ser eliminado");
        assertTrue(ciudadano1.estaVivo(),
                "El jugador con menos votos no debería ser eliminado");
        assertTrue(ciudadano2.estaVivo(),
                "El jugador con menos votos no debería ser eliminado");
        assertTrue(padrino.estaVivo(),
                "El votante con rol de padrino no debería ser eliminado por votar");
    }

    @Test
    public void test05UnEmpateDeVotosEnFaseDiurnaNoEliminaANingunJugador() {
        // Arrange
        nominarJugadores(faseDiurna, mafioso1, ciudadano1);
        Votar votoCiudadano = new Votar(faseDiurna, ciudadano1, mafioso1);
        Votar votoMafioso = new Votar(faseDiurna, mafioso1, ciudadano1);

        // Act
        votoCiudadano.execute();
        votoMafioso.execute();

        // Assert
        assertThrows(NoHuboDecisionException.class, faseDiurna::finalizar,
                "Una votación empatada no debería tener decisión");
        assertTrue(ciudadano1.estaVivo(),
                "No se debería eliminar a un jugador si la votación queda empatada");
        assertTrue(mafioso1.estaVivo(),
                "No se debería eliminar a un jugador si la votación queda empatada");
    }

    @Test
    public void test06UnJugadorNoPuedeVotarseASiMismo() {
        // Act y Assert
        nominarJugadores(faseDiurna, ciudadano1);
        assertThrows(VotarAlMismoJugadorException.class,
                () -> new Votar(faseDiurna, ciudadano1, ciudadano1),
                "Un jugador no debería poder votarse a sí mismo");
    }

    @Test
    public void test07LaFaseDiurnaPuedeEjecutarUnVoto() {
        // Arrange
        nominarJugadores(faseDiurna, mafioso1);
        Votar votar = new Votar(faseDiurna, ciudadano1, mafioso1);

        // Act
        faseDiurna.ejecutar(votar);
        faseDiurna.finalizar();

        // Assert
        assertFalse(mafioso1.estaVivo(),
                "La fase diurna debería poder ejecutar la acción votar");
    }

    @Test
    public void test08AlFinalizarLaFaseNocturnaSeEliminaAlCiudadanoVotado() {
        // Arrange
        nominarJugadores(faseNocturna, ciudadano1);
        Votar votar = new Votar(faseNocturna, mafioso1, ciudadano1);

        // Act
        votar.execute();
        faseNocturna.finalizar();

        // Assert
        assertFalse(ciudadano1.estaVivo(),
                "Al finalizar la fase nocturna se debería eliminar al jugador votado");
        assertTrue(mafioso1.estaVivo(),
                "El mafioso que vota no debería ser eliminado por votar");
    }

    @Test
    public void test09LaFaseNocturnaPuedeEjecutarUnVoto() {
        // Arrange
        nominarJugadores(faseNocturna, ciudadano1);
        Votar votar = new Votar(faseNocturna, mafioso1, ciudadano1);

        // Act
        faseNocturna.ejecutar(votar);
        faseNocturna.finalizar();

        // Assert
        assertFalse(ciudadano1.estaVivo(),
                "La fase nocturna debería poder ejecutar la acción votar");
    }

    @Test
    public void test10EnFaseNocturnaDosMafiososYPadrinoPuedenVotarAlMismoCiudadano() {
        // Arrange
        nominarJugadores(faseNocturna, ciudadano1);
        Votar votoMafioso1 = new Votar(faseNocturna, mafioso1, ciudadano1);
        Votar votoMafioso2 = new Votar(faseNocturna, mafioso2, ciudadano1);
        Votar votoPadrino = new Votar(faseNocturna, padrino, ciudadano1);

        // Act
        votoMafioso1.execute();
        votoMafioso2.execute();
        votoPadrino.execute();
        faseNocturna.finalizar();

        // Assert
        assertFalse(ciudadano1.estaVivo(),
                "El ciudadano votado por mafiosos y padrino debería ser eliminado");
        assertTrue(ciudadano2.estaVivo(),
                "El ciudadano que no recibió votos debería seguir vivo");
        assertTrue(mafioso1.estaVivo(),
                "El mafioso que vota no debería ser eliminado por votar");
        assertTrue(mafioso2.estaVivo(),
                "El mafioso que vota no debería ser eliminado por votar");
        assertTrue(padrino.estaVivo(),
                "El padrino que vota no debería ser eliminado por votar");
    }

    @Test
    public void test11UnEmpateDeVotosEnFaseNocturnaNoEliminaANingunJugador() {
        // Arrange
        nominarJugadores(faseNocturna, ciudadano1, ciudadano2);
        Votar votoMafioso = new Votar(faseNocturna, mafioso1, ciudadano1);
        Votar votoPadrino = new Votar(faseNocturna, padrino, ciudadano2);

        // Act
        votoMafioso.execute();
        votoPadrino.execute();

        // Assert
        assertThrows(NoHuboDecisionException.class, faseNocturna::finalizar,
                "Una votación nocturna empatada no debería tener decisión");
        assertTrue(ciudadano1.estaVivo(),
                "No se debería eliminar a un jugador si la votación queda empatada");
        assertTrue(ciudadano2.estaVivo(),
                "No se debería eliminar a un jugador si la votación queda empatada");
    }

    @Test
    public void test12UnJugadorNoNominadoNoPuedeSerVotado(){
        // Arrange
        Votar voto = new Votar(faseDiurna, mafioso1, ciudadano1);

        // Act y Assert
        assertThrows(JugadorNoNominadoException.class,
                voto::execute);
    }
}
