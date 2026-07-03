package edu.fiuba.algo3.unitarios.roles;
import edu.fiuba.algo3.modelo.acciones.Nominar;
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
    public void test01MedicoNoPuedeVerBandoDeUnCiudadano(){
        // Arrange
        Ciudadano ciudadano = new Ciudadano();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(ciudadano),
                "Un médico no debería poder ver el bando de un ciudadano");
    }

    @Test
    public void test02MedicoNoPuedeVerBandoDeOtroMedico(){
        // Arrange
        Medico otroMedico = new Medico();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(otroMedico),
                "Un médico no debería poder ver el bando de otro médico");
    }

    @Test
    public void test03MedicoNoPuedeVerBandoDeUnDetective(){
        // Arrange
        Detective detective = new Detective();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(detective),
                "Un médico no debería poder ver el bando de un detective");
    }

    @Test
    public void test04MedicoNoPuedeVerBandoDeUnSheriff(){
        // Arrange
        Sheriff sheriff = new Sheriff();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(sheriff),
                "Un médico no debería poder ver el bando de un sheriff");
    }

    @Test
    public void test05MedicoNoPuedeVerBandoDeUnMafioso(){
        // Arrange
        Mafioso mafioso = new Mafioso();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(mafioso),
                "Un médico no debería poder ver el bando de un mafioso");
    }

    @Test
    public void test06MedicoNoPuedeVerBandoDeUnPadrino(){
        // Arrange
        Padrino padrino = new Padrino();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> medico.verBando(padrino),
                "Un médico no debería poder ver el bando de un padrino");
    }

    @Test
    public void test07MedicoPuedeProtegerUnJugador(){
        // Arrange
        Jugador medico = new Jugador(this.medico, "medico");
        Jugador ciudadano = new Jugador(new Ciudadano(), "ciudadano");
        Jugador mafioso = new Jugador(new Mafioso(), "mafioso");
        FaseNocturna fase = new FaseNocturna();

        // Act
        medico.accion(fase, ciudadano);
        fase.ejecutar(new Nominar(fase, mafioso, ciudadano));
        mafioso.accion(fase, ciudadano);

        // Assert
        assertThrows(ObjetivoProtegidoException.class, fase::finalizar,
                "Un jugador protegido por el médico no debería recibir daño durante la fase nocturna");
    }
}
