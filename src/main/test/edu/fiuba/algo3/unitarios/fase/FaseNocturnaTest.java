package edu.fiuba.algo3.unitarios.fase;

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
        ciudadano2 = new Jugador(new Ciudadano(), "ciudadano2");
        mafioso1 = new Jugador(new Mafioso(), "mafioso1");
        mafioso2 = new Jugador(new Mafioso(), "mafioso2");
        medico = new Jugador(new Medico(), "medico");
        padrino = new Jugador(new Padrino(), "padrino");
        detective = new Jugador(new Detective(), "detective");
        fase = new FaseNocturna();
    }

    @Test
    public void test01NoSeEliminaNingunJugadorEnCasoDeEmpate(){
        // Act
        mafioso1.accionNocturna(fase, ciudadano1);
        mafioso2.accionNocturna(fase, medico);

        // Assert
        assertThrows(NoHuboDecisionException.class, fase::finalizar,
                "No debería eliminarse ningún jugador cuando hay un empate en la votación");
    }

    @Test
    public void test02ElVotoDelPadrinoDesempataLaVotacion(){
        // Act
        mafioso1.accionNocturna(fase, ciudadano1);
        padrino.accionNocturna(fase, medico);
        fase.finalizar();

        // Assert
        assertFalse(medico.estaVivo(),
                "El voto del padrino debería desempatar la votación");
    }

    @Test
    public void test03SeEliminaAlJugadorMasVotadoCuandoNoHayEmpate(){
        // Act
        mafioso1.accionNocturna(fase, ciudadano1);
        mafioso2.accionNocturna(fase, ciudadano1);
        fase.finalizar();

        // Assert
        assertFalse(ciudadano1.estaVivo(),
                "El jugador más votado debería ser eliminado cuando no hay empate");
    }

    @Test
    public void test04UnMafiosoMuertoNoPuedeVotar(){
        // Act
        mafioso1.morir();

        // Assert
        assertThrows(SeleccionInvalidaException.class,
                () -> mafioso1.accionNocturna(fase, ciudadano1),
                "Un mafioso muerto no debería poder votar");
    }

    @Test
    public void test05NoSeTieneEnCuentaElVotoDeUnMafiosoMuerto(){
        // Act
        mafioso1.morir();

        try {
            mafioso1.accionNocturna(fase, ciudadano1);
        } catch(SeleccionInvalidaException ignored){}

        mafioso2.accionNocturna(fase, ciudadano2);

        fase.finalizar();

        // Assert
        assertFalse(ciudadano2.estaVivo(),
                "La votación de un mafioso muerto no debería tener efecto");
    }

    @Test
    public void test06UnMedicoMuertoNoPuedeProtegerAJugador(){
        // Act
        medico.morir();

        try{
            medico.accionNocturna(fase, ciudadano1);
        }catch (SeleccionInvalidaException ignored){}

        mafioso1.accionNocturna(fase, ciudadano1);

        fase.finalizar();

        // Assert
        assertFalse(ciudadano1.estaVivo(),
                "Un médico muerto no debería poder proteger a un jugador");
    }

    @Test
    public void test07NoSeTieneEnCuentaElVotoDeUnPadrinoMuerto(){
        // Act
        padrino.morir();

        try{
            padrino.accionNocturna(fase, ciudadano1);
        }catch (SeleccionInvalidaException ignored){}

        mafioso1.accionNocturna(fase, ciudadano2);

        fase.finalizar();

        // Assert
        assertFalse(ciudadano2.estaVivo(),
                "La votación de un padrino muerto no debería tener efecto");
    }

    @Test
    public void test08UnDetectiveMuertoNoPuedeInvestigar(){
        // Act
        detective.morir();

        // Assert
        assertThrows(SeleccionInvalidaException.class,
                () -> detective.accionNocturna(fase, ciudadano1),
                "Un detective muerto no debería poder investigar");
    }

    @Test
    public void test09unaFaseNocturnaObtieneCorrectamenteUnProtegidoDeFaseNocturnaData(){
        FaseNocturnaData data = new FaseNocturnaData(ciudadano1, ciudadano2, new Candidato(medico));
        fase = new FaseNocturna(data);

        assertThrows(NoSePuedeProtegerDosVecesSeguidasException.class,
                () -> medico.accionNocturna(fase, ciudadano1),
                "Construyendose una fase desde un FaseNocturnaData, no deberia permitir proteger al ultimoprotegido");
    }

    @Test
    public void test10unaFaseNocturnaObtieneCorrectamenteUnInvestigadoDeFaseNocturnaData(){
        FaseNocturnaData data = new FaseNocturnaData(ciudadano1, ciudadano2, new CandidatoNulo());
        fase = new FaseNocturna(data);

        assertThrows(NoSePuedeInvestigarDosVecesSeguidasException.class,
                () -> detective.accionNocturna(fase, ciudadano2),
                "Construyendose una fase desde un FaseNocturnaData, no deberia permitir investigar al ultimoInvestigado");
    }
}
