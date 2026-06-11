package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.FaseNocturna;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Mafioso;
import edu.fiuba.algo3.modelo.roles.Medico;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FaseNocturnaTest {
    @Test
    public void test01LaMafiaPuedeSeleccionarVictimaValida() {
        // Arrange
        Jugador ciudadano = new Jugador(new Ciudadano());
        Jugador mafioso = new Jugador(new Mafioso());

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(ciudadano);
        jugadores.add(mafioso);

        FaseNocturna faseNocturna = new FaseNocturna(jugadores);

        // Act
        faseNocturna.laMafiaElije(ciudadano);
        faseNocturna.finalizar();

        // Assert
        assertFalse(ciudadano.estaVivo(),"La mafia seleccionó una víctima valida");
    }
    @Test
    public void test07ElMedicoProtegeAlMismoJugadorQueEligioLaMafia(){
        // Arrange
        Jugador victima = new Jugador(new Ciudadano());
        Jugador medico = new Jugador(new Medico());
        Jugador mafioso = new Jugador(new Mafioso());

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(victima);
        jugadores.add(medico);
        jugadores.add(mafioso);

        FaseNocturna faseNocturna = new FaseNocturna(jugadores);

        // Act
        faseNocturna.laMafiaElije(victima);
        faseNocturna.elMedicoProteje(victima);
        faseNocturna.finalizar();

        // Assert
        assertTrue(victima.estaVivo(),"El medico protegió al objetivo de la mafia");
    }
    @Test
    public void test08LaMafiaEligeAUnJugadorNoProgido(){
        // Arrange
        Jugador victima = new Jugador(new Ciudadano());
        Jugador protegido = new Jugador(new Ciudadano());
        Jugador medico = new Jugador(new Medico());
        Jugador mafioso = new Jugador(new Mafioso());

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(victima);
        jugadores.add(protegido);
        jugadores.add(medico);
        jugadores.add(mafioso);

        FaseNocturna faseNocturna = new FaseNocturna(jugadores);

        // Act
        faseNocturna.laMafiaElije(victima);
        faseNocturna.elMedicoProteje(protegido);
        faseNocturna.finalizar();

        // Assert
        assertFalse(victima.estaVivo(),"El objetivo fue eliminado");
    }

}
