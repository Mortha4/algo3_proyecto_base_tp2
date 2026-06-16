package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.FaseNocturna;
import edu.fiuba.algo3.modelo.comandos.Votar;
import edu.fiuba.algo3.modelo.excepciones.ObjetivoProtegidoException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.excepciones.SeleccionInvalidaException;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Mafioso;
import edu.fiuba.algo3.modelo.roles.Medico;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FaseNocturnaTest {
    @Test
    public void test01LaMafiaPuedeSeleccionarVictimaValida() {
        // Arrange
        Jugador ciudadano = new Jugador(new Ciudadano(), "ciudadano");
        Jugador mafioso = new Jugador(new Mafioso(), "mafioso");

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(ciudadano);
        jugadores.add(mafioso);

        FaseNocturna faseNocturna = new FaseNocturna();

        // Act
        faseNocturna.ejecutar(new Votar(mafioso, ciudadano));
        faseNocturna.finalizar();

        // Assert
        assertFalse(ciudadano.estaVivo(),"La mafia seleccionó una víctima valida");
    }

    @Test
    public void test02LaMafiaNoPuedeSeleccionarVictimaInvalida() {
        // Arrange
        Jugador ciudadano = new Jugador(new Ciudadano(), "ciudadano");
        Jugador mafioso1 = new Jugador(new Mafioso(), "mafioso");
        Jugador mafioso2 = new Jugador(new Mafioso(), "mafioso");

        ciudadano.morir();

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(ciudadano);
        jugadores.add(mafioso1);
        jugadores.add(mafioso2);

        FaseNocturna faseNocturna = new FaseNocturna();

        // Act y Assert
        assertThrows(SeleccionInvalidaException.class, () -> faseNocturna.ejecutar(new Votar(mafioso1, ciudadano)),"La mafia seleccionó una víctima invalida");
    }

    @Test
    public void test03ElMedicoProtegeAlMismoJugadorQueEligioLaMafia(){
        // Arrange
        Jugador victima = new Jugador(new Ciudadano(), "ciudadano");
        Jugador medico = new Jugador(new Medico(), "medico");
        Jugador mafioso = new Jugador(new Mafioso(), "mafioso");

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(victima);
        jugadores.add(medico);
        jugadores.add(mafioso);

        FaseNocturna faseNocturna = new FaseNocturna();

        // Act
        faseNocturna.ejecutar(new Votar(mafioso, victima));
        faseNocturna.proteger(victima);

        // Assert
        assertThrows(ObjetivoProtegidoException.class, faseNocturna::finalizar,"El medico protegió al objetivo de la mafia");
    }
    @Test
    public void test04LaMafiaEligeAUnJugadorNoProgido(){
        // Arrange
        Jugador victima = new Jugador(new Ciudadano(), "ciudadano");
        Jugador protegido = new Jugador(new Ciudadano(), "ciudadano");
        Jugador medico = new Jugador(new Medico(), "medico");
        Jugador mafioso = new Jugador(new Mafioso(), "mafioso");

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(victima);
        jugadores.add(protegido);
        jugadores.add(medico);
        jugadores.add(mafioso);

        FaseNocturna faseNocturna = new FaseNocturna();

        // Act
        faseNocturna.ejecutar(new Votar(mafioso, victima));
        faseNocturna.proteger(protegido);
        faseNocturna.finalizar();

        // Assert
        assertFalse(victima.estaVivo(),"El objetivo fue eliminado");
    }

}
