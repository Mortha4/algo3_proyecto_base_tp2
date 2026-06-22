package edu.fiuba.algo3.entrega_2;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MedicoTest {
    @Test
    public void test01MedicoNoPuedeVerUnMedico(){
        // Arrange
        Medico medico = new Medico();
        Medico otroMedico = new Medico();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(otroMedico),
                "El medico pudo ver el bando de un ciudadano");
    }
    @Test
    public void test02MedicoNoPuedeVerUnCiudadano(){
        // Arrange
        Medico medico = new Medico();
        Ciudadano ciudadano = new Ciudadano();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(ciudadano),
                "El medico pudo ver el bando de un ciudadano");
    }
    @Test
    public void test03MedicoNoPuedeVerUnDetective(){
        // Arrange
        Medico medico = new Medico();
        Detective detective = new Detective();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(detective),
                "El medico pudo ver el bando de un ciudadano");
    }
    @Test
    public void test04MedicoNoPuedeVerUnSheriff(){
        // Arrange
        Medico medico = new Medico();
        Sheriff sheriff = new Sheriff();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(sheriff),
                "El medico pudo ver el bando de un ciudadano");
    }
    @Test
    public void test05MedicoNoPuedeVerUnMafioso(){
        // Arrange
        Medico medico = new Medico();
        Mafioso mafioso = new Mafioso();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(mafioso),
                "El medico pudo ver el bando de un ciudadano");
    }
    @Test
    public void test06MedicoNoPuedeVerUnPadrino(){
        // Arrange
        Medico medico = new Medico();
        Padrino padrino = new Padrino();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(padrino),
                "El medico pudo ver el bando de un ciudadano");
    }

    @Test
    public void test07MedicoPuedeProtegerUnJugador(){
        // Arrange
        Jugador medico = new Jugador(new Medico(), "medico");
        Jugador ciudadano = new Jugador(new Ciudadano(), "ciudadano");
        Jugador mafioso = new Jugador(new Mafioso(), "mafioso");
        FaseNocturna fase = new FaseNocturna();

        // Act
        medico.accionNocturna(fase, ciudadano);
        mafioso.accionNocturna(fase, ciudadano);

        // Assert
        assertThrows(ObjetivoProtegidoException.class, fase::finalizar,
                "Se pudo atacat al protegido");
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
        assertThrows(NoSePuedeProtegerDosVecesSeguidas.class,
                () -> medico.accionNocturna(noche2, ciudadano),
                "El medico pudo proteger dos veces seguidas al mismo jugador");

    }
}
