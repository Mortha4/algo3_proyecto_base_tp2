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
    public void test01DetectivePuedeVerUnDetective(){
        // Arrange
        Detective detective = new Detective();
        Detective otroDetective = new Detective();

        // Act
        Rol result = detective.verBando(otroDetective);

        // Assert
        assertEquals(Ciudadano.class, result.getClass(),
                "Un detective no puede ver el bando de un detective");
    }

    @Test
    public void test02DetectivePuedeVerUnMedico(){
        // Arrange
        Detective detective = new Detective();
        Medico medico = new Medico();

        // Act
        Rol result = detective.verBando(medico);

        // Assert
        assertEquals(Ciudadano.class, result.getClass(),
                "Un detective no puede ver el bando de un medico");

    }

    @Test
    public void test03DetectivePuedeVerUnCiudadano(){
        // Arrange
        Detective detective = new Detective();
        Ciudadano ciudadano = new Ciudadano();

        // Act
        Rol result = detective.verBando(ciudadano);

        // Assert
        assertEquals(Ciudadano.class, result.getClass(),
                "Un detective no puede ver el bando de un ciudadano");

    }

    @Test
    public void test04DetectivePuedeVerUnSheriff(){
        // Arrange
        Detective detective = new Detective();
        Sheriff sheriff = new Sheriff();

        // Act
        Rol result = detective.verBando(sheriff);

        // Assert
        assertEquals(Ciudadano.class, result.getClass(),
                "Un detective no puede ver el bando de un sheriff");

    }

    @Test
    public void test05DetectivePuedeVerUnMafioso(){
        // Arrange
        Detective detective = new Detective();
        Mafioso mafioso = new Mafioso();

        // Act
        Rol result = detective.verBando(mafioso);

        // Assert
        assertEquals(Mafioso.class, result.getClass(),
                "Un detective no puede ver el bando de un mafioso");

    }

    @Test
    public void test06DetectivePuedeVerUnPadrino(){
        // Arrange
        Detective detective = new Detective();
        Padrino padrino = new Padrino();

        // Act
        Rol result = detective.verBando(padrino);

        // Assert
        assertEquals(Ciudadano.class, result.getClass(),
                "Un detective no puede ver el bando de un padrino");

    }

    @Test
    public void test07DetectiveNoPuedeInvestigarAlMismoJugadorDosNochesSeguidas(){
        // Arrange
        Jugador detective = new Jugador(new Detective(), "detective");
        Jugador ciudadano = new Jugador(new Ciudadano(), "ciudadano");
        FaseNocturna primeraNoche = new FaseNocturna();

        // Act
        detective.accionNocturna(primeraNoche, ciudadano);
        FaseNocturna segundaNoche = new FaseNocturna(ciudadano, null);
        //TODO: HACER QUE AL TERMINAR UNA FASE SE GUARDE UN MEMENTO, Y CADA FASENOCTURNA SE CONSTRUYA RECIBIENDO EL ULTIMO INVESTIGADO

        assertThrows(NoSePuedeInvestigarDosVecesSeguidasException.class,
                () -> detective.accionNocturna(segundaNoche, ciudadano),
                "No se lanza una excepción al investigar dos veces al mismo jugador");
    }

    @Test
    public void test08MedicoNoPuedeProtegerDosVecesAlMismo(){
        // Arrange
        Jugador medico = new Jugador(new Medico(), "medico");
        Jugador ciudadano = new Jugador(new Ciudadano(), "ciudadano");
        FaseNocturna noche1 = new FaseNocturna();

        // Act
        medico.accionNocturna(noche1, ciudadano);
        FaseNocturna noche2 = new FaseNocturna(null, ciudadano);

        // Assert
        assertThrows(NoSePuedeProtegerDosVecesSeguidasException.class,
                () -> medico.accionNocturna(noche2, ciudadano),
                "El medico pudo proteger dos veces seguidas al mismo jugador");

    }

    @Test
    public void test01VotacionSinEmpateSoloUsaJugadoresVivos(){
        // Arrange
        Jugador ciudadano1 = new Jugador(new Ciudadano(), "ciudadano");
        Jugador ciudadano2 = new Jugador(new Ciudadano(), "ciudadano2");
        FaseDiurna fase = new FaseDiurna();

        // Act y assert
        ciudadano1.morir();
        assertThrows(SeleccionInvalidaException.class, () -> ciudadano2.accionDiurna(fase, ciudadano1),
                "Se pudo votar a un muerto");

    }

    @Test
    public void test02EnEmpateNoMuereNadie(){
        // Arrange
        Jugador ciudadano1 = new Jugador(new Ciudadano(), "ciudadano");
        Jugador ciudadano2 = new Jugador(new Ciudadano(), "ciudadano2");
        FaseDiurna fase = new FaseDiurna();

        // Act
        ciudadano1.accionDiurna(fase, ciudadano2);
        ciudadano2.accionDiurna(fase, ciudadano1);
        // Assert
        assertThrows(NoHuboDecisionException.class,
                fase::finalizar,
                "Se elimino a alguien al empatar");
    }

    @Test
    public void test04VotacionValidaFinalizaCorrectamente(){
        // Arrange
        Jugador ciudadano1 = new Jugador(new Ciudadano(), "ciudadano");
        Jugador ciudadano2 = new Jugador(new Ciudadano(), "ciudadano2");
        Jugador ciudadano3 = new Jugador(new Ciudadano(), "ciudadano3");
        FaseDiurna fase = new FaseDiurna();

        // Act
        ciudadano1.accionDiurna(fase, ciudadano3);
        ciudadano2.accionDiurna(fase, ciudadano3);
        ciudadano3.accionDiurna(fase, ciudadano2);
        fase.finalizar();
        // Assert
        assertFalse(ciudadano3.estaVivo(), "En una votación valida, no se elimino el jugador mas votado");
    }

    @Test
    public void test05JugadorMuertoNoPuedeSeguirVotando(){
        // Arrange
        Jugador ciudadano1 = new Jugador(new Ciudadano(), "ciudadano");
        Jugador ciudadano2 = new Jugador(new Ciudadano(), "ciudadano2");
        FaseDiurna fase = new FaseDiurna();

        // Act
        ciudadano1.morir();
        // Assert
        assertThrows(SeleccionInvalidaException.class,
                () -> ciudadano1.accionDiurna(fase, ciudadano2),
                "Un jugador muerto puede seguir votando");
    }

}
