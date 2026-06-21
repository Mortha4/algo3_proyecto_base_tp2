package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.excepciones.NoHuboDecisionException;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeInvestigarDosVecesSeguidasException;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeProtegerDosVecesSeguidasException;
import edu.fiuba.algo3.modelo.excepciones.SeleccionInvalidaException;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega2Test {

    @Test
    public void test01DetectivePuedeIdentificarAOtroDetective(){
        // Arrange
        Detective detective = new Detective();
        Detective otroDetective = new Detective();

        // Act
        Rol result = detective.verBando(otroDetective);

        // Assert
        assertEquals(Ciudadano.class, result.getClass(),
                "El detective debería identificar a otro detective como ciudadano");
    }

    @Test
    public void test02DetectivePuedeIdentificarAUnMedico(){
        // Arrange
        Detective detective = new Detective();
        Medico medico = new Medico();

        // Act
        Rol result = detective.verBando(medico);

        // Assert
        assertEquals(Ciudadano.class, result.getClass(),
                "El detective debería identificar a un médico como ciudadano");
    }

    @Test
    public void test03DetectivePuedeIdentificarAUnCiudadano(){
        // Arrange
        Detective detective = new Detective();
        Ciudadano ciudadano = new Ciudadano();

        // Act
        Rol result = detective.verBando(ciudadano);

        // Assert
        assertEquals(Ciudadano.class, result.getClass(),
                "El detective debería identificar a un ciudadano como ciudadano");
    }

    @Test
    public void test04DetectivePuedeIdentificarAUnSheriff(){
        // Arrange
        Detective detective = new Detective();
        Sheriff sheriff = new Sheriff();

        // Act
        Rol result = detective.verBando(sheriff);

        // Assert
        assertEquals(Ciudadano.class, result.getClass(),
                "El detective debería identificar a un sheriff como ciudadano");
    }

    @Test
    public void test05DetectivePuedeIdentificarAUnMafioso(){
        // Arrange
        Detective detective = new Detective();
        Mafioso mafioso = new Mafioso();

        // Act
        Rol result = detective.verBando(mafioso);

        // Assert
        assertEquals(Mafioso.class, result.getClass(),
                "El detective debería identificar a un mafioso como mafioso");
    }

    @Test
    public void test06DetectivePuedeIdentificarAUnPadrinoComoCiudadano(){
        // Arrange
        Detective detective = new Detective();
        Padrino padrino = new Padrino();

        // Act
        Rol result = detective.verBando(padrino);

        // Assert
        assertEquals(Ciudadano.class, result.getClass(),
                "El detective debería identificar a un padrino como ciudadano");
    }

    @Test
    public void test07UnDetectiveNoPuedeInvestigarAlMismoJugadorDosNochesSeguidas(){
        // Arrange
        Jugador detective = new Jugador(new Detective(), "detective");
        Jugador ciudadano = new Jugador(new Ciudadano(), "ciudadano");
        FaseNocturna primeraNoche = new FaseNocturna();

        // Act
        detective.accionNocturna(primeraNoche, ciudadano);

        FaseNocturna segundaNoche = new FaseNocturna(primeraNoche.exportarInfo());

        // Assert
        assertThrows(NoSePuedeInvestigarDosVecesSeguidasException.class,
                () -> detective.accionNocturna(segundaNoche, ciudadano),
                "Un detective no debería poder investigar al mismo jugador dos noches seguidas");
    }

    @Test
    public void test08UnMedicoNoPuedeProtegerAlMismoJugadorDosNochesSeguidas(){
        // Arrange
        Jugador medico = new Jugador(new Medico(), "medico");
        Jugador ciudadano = new Jugador(new Ciudadano(), "ciudadano");
        FaseNocturna noche1 = new FaseNocturna();

        // Act
        medico.accionNocturna(noche1, ciudadano);
        FaseNocturna noche2 = new FaseNocturna(noche1.exportarInfo());

        // Assert
        assertThrows(NoSePuedeProtegerDosVecesSeguidasException.class,
                () -> medico.accionNocturna(noche2, ciudadano),
                "Un médico no debería poder proteger al mismo jugador dos noches seguidas");
    }

    @Test
    public void test09NoSePuedeVotarAUnJugadorMuerto(){
        // Arrange
        Jugador ciudadano1 = new Jugador(new Ciudadano(), "ciudadano");
        Jugador ciudadano2 = new Jugador(new Ciudadano(), "ciudadano2");
        FaseDiurna fase = new FaseDiurna();

        // Act
        ciudadano1.morir();

        // Assert
        assertThrows(SeleccionInvalidaException.class,
                () -> ciudadano2.votar(fase, ciudadano1),
                "No debería poder votarse a un jugador muerto");
    }

    @Test
    public void test10NoSeEliminaNingunJugadorEnCasoDeEmpate(){
        // Arrange
        Jugador ciudadano1 = new Jugador(new Ciudadano(), "ciudadano");
        Jugador ciudadano2 = new Jugador(new Ciudadano(), "ciudadano2");
        FaseDiurna fase = new FaseDiurna();

        // Act
        ciudadano1.votar(fase, ciudadano2);
        ciudadano2.votar(fase, ciudadano1);

        // Assert
        assertThrows(NoHuboDecisionException.class,
                fase::finalizar,
                "No debería eliminarse ningún jugador cuando hay un empate en la votación");
    }

    @Test
    public void test11SeEliminaAlJugadorMasVotadoEnUnaVotacionValida(){
        // Arrange
        Jugador ciudadano1 = new Jugador(new Ciudadano(), "ciudadano");
        Jugador ciudadano2 = new Jugador(new Ciudadano(), "ciudadano2");
        Jugador ciudadano3 = new Jugador(new Ciudadano(), "ciudadano3");
        FaseDiurna fase = new FaseDiurna();

        // Act
        ciudadano1.votar(fase, ciudadano3);
        ciudadano2.votar(fase, ciudadano3);
        ciudadano3.votar(fase, ciudadano2);
        fase.finalizar();

        // Assert
        assertFalse(ciudadano3.estaVivo(),
                "El jugador más votado debería ser eliminado en una votación válida");
    }

    @Test
    public void test12UnJugadorMuertoNoPuedeVotar(){
        // Arrange
        Jugador ciudadano1 = new Jugador(new Ciudadano(), "ciudadano");
        Jugador ciudadano2 = new Jugador(new Ciudadano(), "ciudadano2");
        FaseDiurna fase = new FaseDiurna();

        // Act
        ciudadano1.morir();

        // Assert
        assertThrows(SeleccionInvalidaException.class,
                () -> ciudadano1.accionDiurna(fase, ciudadano2),
                "Un jugador muerto no debería poder votar");
    }
}
