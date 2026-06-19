package edu.fiuba.algo3.unitarios;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MedicoTest {
    private Medico medico;

    @BeforeEach
    public void arrange() {
        medico = new Medico();
    }

    @Test
    public void test02MedicoNoPuedeVerUnCiudadano(){
        // Arrange
        Ciudadano ciudadano = new Ciudadano();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(ciudadano),
                "El medico pudo ver el bando de un ciudadano");
    }

    @Test
    public void test01MedicoNoPuedeVerUnMedico(){
        // Arrange
        Medico otroMedico = new Medico();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(otroMedico),
                "El medico pudo ver el bando de un ciudadano");
    }

    @Test
    public void test03MedicoNoPuedeVerUnDetective(){
        // Arrange
        Detective detective = new Detective();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(detective),
                "El medico pudo ver el bando de un ciudadano");
    }

    @Test
    public void test04MedicoNoPuedeVerUnSheriff(){
        // Arrange
        Sheriff sheriff = new Sheriff();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(sheriff),
                "El medico pudo ver el bando de un ciudadano");
    }

    @Test
    public void test05MedicoNoPuedeVerUnMafioso(){
        // Arrange
        Mafioso mafioso = new Mafioso();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(mafioso),
                "El medico pudo ver el bando de un ciudadano");
    }

    @Test
    public void test06MedicoNoPuedeVerUnPadrino(){
        // Arrange
        Padrino padrino = new Padrino();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(padrino),
                "El medico pudo ver el bando de un ciudadano");
    }

    @Test
    public void test07MedicoPuedeProtegerUnJugador(){
        // Arrange
        Jugador medico = new Jugador(this.medico, "medico");
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
}
