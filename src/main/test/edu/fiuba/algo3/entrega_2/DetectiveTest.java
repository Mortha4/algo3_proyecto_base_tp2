package edu.fiuba.algo3.entrega_2;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeInvestigarDosVecesSeguidas;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DetectiveTest {
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

        assertThrows(NoSePuedeInvestigarDosVecesSeguidas.class,
                () -> detective.accionNocturna(segundaNoche, ciudadano),
                "No se lanza una excepcion al investigar dos veces al mismo jugador");
    }
}
