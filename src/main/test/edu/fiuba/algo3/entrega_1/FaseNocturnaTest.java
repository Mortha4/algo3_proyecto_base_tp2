package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.fase.*;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FaseNocturnaTest {
    private Jugador ciudadano1;
    private Jugador ciudadano2;
    private Jugador mafioso1;
    private Jugador mafioso2;
    private Jugador medico;
    private Jugador padrino;
    private Jugador detective;
    private FaseNocturna fase;


    @BeforeEach
    public void arrange(){
        ciudadano1 = new Jugador(new Ciudadano(), "ciudadano1");
        ciudadano2= new Jugador(new Ciudadano(), "ciudadano2");
        mafioso1 = new Jugador(new Mafioso(), "mafioso1");
        mafioso2 = new Jugador(new Mafioso(), "mafioso2");;
        medico = new Jugador(new Medico(), "medico");
        padrino = new Jugador(new Padrino(), "padrino");
        detective = new Jugador(new Detective(), "detective");
        fase = new FaseNocturna();
    }

    @Test
    public void test01LaMafiaPuedeSeleccionarVictimaValida() {
        // Act
        mafioso1.accionNocturna(fase, ciudadano1);
        fase.finalizar();

        // Assert
        assertFalse(ciudadano1.estaVivo(),"La mafia no pudo matar a una víctima valida");
    }

    @Test
    public void test02LaMafiaNoPuedeSeleccionarVictimaMuerta() {
        ciudadano1.morir();

        // Act y Assert
        assertThrows(SeleccionInvalidaException.class, () -> mafioso1.accionNocturna(fase, ciudadano1),
                "La mafia seleccionó una víctima invalida");
    }

    @Test
    public void test03ElMedicoProtegeAlMismoJugadorQueEligioLaMafia(){
        // Act
        mafioso1.accionNocturna(fase, ciudadano1);
        medico.accionNocturna(fase, ciudadano1);

        // Assert
        assertThrows(ObjetivoProtegidoException.class, fase::finalizar,"El medico protegió al objetivo de la mafia");
    }
    @Test
    public void test04LaMafiaEligeAUnJugadorNoProtegido(){
        // Act
        mafioso1.accionNocturna(fase, ciudadano1);
        medico.accionNocturna(fase, ciudadano2);
        fase.finalizar();

        // Assert
        assertFalse(ciudadano1.estaVivo(),"El objetivo fue eliminado");
    }

    @Test
    public void test05EnEmpateNoMuereNadie(){
        // Act
        mafioso1.accionNocturna(fase, ciudadano1);
        mafioso2.accionNocturna(fase, medico);

        // Assert
        assertThrows(NoHuboDecisionException.class, fase::finalizar,
                "Se elimino un jugador en empate");
    }

    @Test
    public void test06EnEmpateDesempataElPadrino(){
        // Act
        mafioso1.accionNocturna(fase, ciudadano1);
        padrino.accionNocturna(fase, medico);
        fase.finalizar();

        // Assert
        assertFalse(medico.estaVivo(),
                "No se desempató con el voto del padrino");
    }

    @Test
    public void test07NoSePuedeMatarAOtroMafioso(){
        // Act
        mafioso1.accionNocturna(fase, mafioso2);
        // Assert
        assertThrows(NoHuboDecisionException.class, fase::finalizar,
                "Los mafiosos pudieron eliminar a otro mafioso1");
    }

    @Test
    public void test08LosMafiososEstanDeAcuerdo(){
        // Act
        mafioso1.accionNocturna(fase, ciudadano1);
        mafioso2.accionNocturna(fase, ciudadano1);
        fase.finalizar();
        // Assert
        assertFalse(ciudadano1.estaVivo(),
                "No se elige correctamente el jugador a eliminar sin empate");
    }

    @Test
    public void test09UnMafiosoMuertoNoPuedeSeguirVotando(){
        // Act
        mafioso1.morir();
        // Assert
        assertThrows(SeleccionInvalidaException.class,
                () -> mafioso1.accionNocturna(fase, ciudadano1));
    }

    @Test
    public void test10NoSeTieneEnCuentaLaVotacionDeUnMuerto(){
        // Act
        mafioso1.morir();
        try{
            mafioso1.accionNocturna(fase, ciudadano1);
        }catch (SeleccionInvalidaException ignored){}
        mafioso2.accionNocturna(fase, ciudadano2);
        fase.finalizar();
        // Assert
        assertFalse(ciudadano2.estaVivo(),
                "El voto de un mafioso muerto fue efectivo.");
    }

    @Test
    public void test11UnMedicoMuertoNoPuedeProteger(){
        // Act
        medico.morir();
        try{
            medico.accionNocturna(fase, ciudadano1);
        }catch (SeleccionInvalidaException ignored){}
        mafioso1.accionNocturna(fase, ciudadano1);
        fase.finalizar();
        // Assert
        assertFalse(ciudadano1.estaVivo(),
                "Un medico muerto pudo proteger.");
    }
    @Test
    public void test12UnPadrinoMuertoNoPuedeVotar(){
        // Act
        padrino.morir();
        try{
            padrino.accionNocturna(fase, ciudadano1);
        }catch (SeleccionInvalidaException ignored){}
        mafioso1.accionNocturna(fase, ciudadano2);
        fase.finalizar();
        // Assert
        assertFalse(ciudadano2.estaVivo(),
                "El voto de un padrino muerto fue efectivo.");
    }

    @Test
    public void test13UnDetectiveMuertoNoPuedeInvestigar(){
        // Act
        detective.morir();
        // Assert
        assertThrows(SeleccionInvalidaException.class,
                () -> detective.accionNocturna(fase, ciudadano1),
                "Un detective muerto pudo investigar");
    }
}
