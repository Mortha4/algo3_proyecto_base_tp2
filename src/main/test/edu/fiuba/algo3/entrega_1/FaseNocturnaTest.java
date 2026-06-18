package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.excepciones.NoHuboDecisionException;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.comandos.Votar;
import edu.fiuba.algo3.modelo.excepciones.ObjetivoProtegidoException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.excepciones.SeleccionInvalidaException;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Mafioso;
import edu.fiuba.algo3.modelo.roles.Medico;
import edu.fiuba.algo3.modelo.roles.Padrino;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FaseNocturnaTest {
    @Test
    public void test01LaMafiaPuedeSeleccionarVictimaValida() {
        // Arrange
        Jugador ciudadano = new Jugador(new Ciudadano(), "ciudadano");
        Jugador mafioso = new Jugador(new Mafioso(), "mafioso");

        FaseNocturna faseNocturna = new FaseNocturna();

        // Act
        mafioso.accionNocturna(faseNocturna, ciudadano);
        faseNocturna.finalizar();

        // Assert
        assertFalse(ciudadano.estaVivo(),"La mafia no pudo matar a una víctima valida");
    }

    @Test
    public void test02LaMafiaNoPuedeSeleccionarVictimaMuerta() {
        // Arrange
        Jugador ciudadano = new Jugador(new Ciudadano(), "ciudadano");
        Jugador mafioso1 = new Jugador(new Mafioso(), "mafioso");

        FaseNocturna faseNocturna = new FaseNocturna();
        ciudadano.morir();

        // Act y Assert
        assertThrows(SeleccionInvalidaException.class, () -> mafioso1.accionNocturna(faseNocturna, ciudadano),
                "La mafia seleccionó una víctima invalida");
    }

    @Test
    public void test03ElMedicoProtegeAlMismoJugadorQueEligioLaMafia(){
        // Arrange
        Jugador victima = new Jugador(new Ciudadano(), "ciudadano");
        Jugador medico = new Jugador(new Medico(), "medico");
        Jugador mafioso = new Jugador(new Mafioso(), "mafioso");

        FaseNocturna faseNocturna = new FaseNocturna();

        // Act
        mafioso.accionNocturna(faseNocturna, victima);
        medico.accionNocturna(faseNocturna, victima);

        // Assert
        assertThrows(ObjetivoProtegidoException.class, faseNocturna::finalizar,"El medico protegió al objetivo de la mafia");
    }
    @Test
    public void test04LaMafiaEligeAUnJugadorNoProtegido(){
        // Arrange
        Jugador victima = new Jugador(new Ciudadano(), "ciudadano");
        Jugador protegido = new Jugador(new Ciudadano(), "ciudadano");
        Jugador medico = new Jugador(new Medico(), "medico");
        Jugador mafioso = new Jugador(new Mafioso(), "mafioso");

        FaseNocturna faseNocturna = new FaseNocturna();

        // Act
        mafioso.accionNocturna(faseNocturna, victima);
        medico.accionNocturna(faseNocturna, protegido);
        faseNocturna.finalizar();

        // Assert
        assertFalse(victima.estaVivo(),"El objetivo fue eliminado");
    }

    @Test
    public void test05EnEmpateNoMuereNadie(){
        // Arrange
        Jugador ciudadano = new Jugador(new Ciudadano(), "ciudadano");
        Jugador medico = new Jugador(new Medico(), "medico");
        Jugador mafioso = new Jugador(new Mafioso(), "mafioso");
        Jugador mafioso2 = new Jugador(new Mafioso(), "mafioso2");
        FaseNocturna fase = new FaseNocturna();

        // Act
        mafioso.accionNocturna(fase, ciudadano);
        mafioso2.accionNocturna(fase, medico);

        // Assert
        assertThrows(NoHuboDecisionException.class, fase::finalizar,
                "Se elimino un jugador en empate");
    }

    @Test
    public void test06EnEmpateDesempataElPadrino(){
        // Arrange
        Jugador ciudadano = new Jugador(new Ciudadano(), "ciudadano");
        Jugador medico = new Jugador(new Medico(), "medico");
        Jugador mafioso = new Jugador(new Mafioso(), "mafioso");
        Jugador padrino = new Jugador(new Padrino(), "Padrino");
        FaseNocturna fase = new FaseNocturna();

        // Act
        mafioso.accionNocturna(fase, ciudadano);
        padrino.accionNocturna(fase, medico);
        fase.finalizar();

        // Assert
        assertFalse(medico.estaVivo(),
                "No se desempató con el voto del padrino");
    }
}
