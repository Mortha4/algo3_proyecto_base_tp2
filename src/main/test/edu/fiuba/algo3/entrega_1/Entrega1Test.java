package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mazo.Mazo;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Entrega1Test {
    @Test
    public void test01MazoPara5JugadoresTieneLaCantidadCorrectaDeRoles(){
        //arrange
        int cantidadJugadores = 5, cantMafiosos = 0, cantCiudadanos = 0, cantDetective = 0, cantMedico = 0;
        Mazo mazo = new Mazo(cantidadJugadores);

        //act
        for(int i=0; i < cantidadJugadores; i++){
            Rol rol = mazo.agarrarCarta();
            if(rol instanceof Ciudadano) cantCiudadanos++;
            if(rol instanceof Mafioso) cantMafiosos++;
            if(rol instanceof Detective) cantDetective++;
            if(rol instanceof Medico) cantMedico++;
        }

        //assert
        assertTrue(cantMafiosos == 1 || cantMafiosos == 2, "Cantidad de mafiosos invalida");
        assertEquals(1, cantMedico + cantDetective,  "Solamente se permite un rol especial");
        assertTrue(cantCiudadanos == 2 || cantCiudadanos == 3,"Cantidad de ciudadano invalida");
    }

    @Test
    public void test02MazoPara7JugadoresTieneLaCantidadCorrectaDeRoles(){
        //arrange
        int cantidadJugadores = 7, cantMafiosos = 0, cantCiudadanos = 0, cantDetective = 0, cantMedico = 0;
        Mazo mazo = new Mazo(cantidadJugadores);

        //act
        for(int i=0; i < cantidadJugadores; i++){
            Rol rol = mazo.agarrarCarta();
            if(rol instanceof Ciudadano) cantCiudadanos++;
            if(rol instanceof Mafioso) cantMafiosos++;
            if(rol instanceof Detective) cantDetective++;
            if(rol instanceof Medico) cantMedico++;
        }
        //assert
        assertTrue(cantMafiosos >= 2 && cantMafiosos <= 3, "Cantidad de mafiosos invalida");
        assertEquals(2, cantMedico + cantDetective,  "Solamente se permiten 2 roles especiales");
        assertTrue(cantCiudadanos == 2 || cantCiudadanos == 3,"Cantidad de ciudadano invalida");
    }

    @Test
    public void test03MazoPara10JugadoresTieneLaCantidadCorrectaDeRoles(){
        //arrange
        int cantidadJugadores = 10, cantMafiosos = 0, cantCiudadanos = 0,
                cantDetective = 0, cantMedico = 0, cantPadrinos = 0, cantSheriff = 0;
        Mazo mazo = new Mazo(cantidadJugadores);

        //act
        for(int i=0; i < cantidadJugadores; i++){
            Rol rol = mazo.agarrarCarta();
            if(rol instanceof Ciudadano) cantCiudadanos++;
            if(rol instanceof Mafioso) cantMafiosos++;
            if(rol instanceof Detective) cantDetective++;
            if(rol instanceof Medico) cantMedico++;
            if(rol instanceof Padrino) cantPadrinos++;
            if(rol instanceof Sheriff) cantSheriff++;
        }
        //assert
        assertEquals(3, cantMafiosos, "Cantidad de mafiosos invalido");
        assertEquals(1,cantMedico,"solo debe existir un medico");
        assertEquals(1,cantPadrinos,"solo debe existir un padrino");
        assertEquals(1,cantDetective,"solo debe existir un detective");
        assertEquals(1,cantSheriff,"solo debe existir un sheriff");
        assertEquals(3, cantCiudadanos, "Cantidad de ciudadano invalida");
    }

    @Test
    public void test04UnMazoDe4RolesLanzaExcepcion(){
        // Arrange
        int cantidadDeRoles = 4;

        // Act y Assert
        assertThrows(CantidadDeJugadoresException.class, ()-> new Mazo(cantidadDeRoles),
                "No se puede crear un mazo con menos de 5 roles.");
    }

    @Test
    public void test05UnMazoDe13RolesLanzaExcepcion(){
        // Arrange
        int cantidadDeRoles = 13;

        // Act y Assert
        assertThrows(CantidadDeJugadoresException.class, ()-> new Mazo(cantidadDeRoles),
                "No se puede crear un mazo con mas de 12 roles.");
    }

    @Test
    public void test06UnMazoDe5RolesSeMezcla(){
        //arrange
        Mazo mazo = new Mazo(5);
        List<Rol> mazoOriginal = new ArrayList<>(mazo.getRoles());

        //act
        mazo.mezclar();

        //assert
        assertNotEquals(mazoOriginal, mazo.getRoles(),
                "El mezclador debería haber cambiado el orden de los elementos");
    }

    @Test
    public void test07UnMazoDe5RolesMantieneSuTamanioAlMezclar(){
        // arrange
        Mazo mazo = new Mazo(5);

        // act
        mazo.mezclar();
        for(int i = 0; i < 5; i++){
            mazo.agarrarCarta();
        }

        // assert
        assertThrows(NoHayMasCartasException.class,
                mazo::agarrarCarta,
                "El tamaño del mazo cambio al mezclarlo");
    }

    @Test
    public void test08UnMazoCon5RolesMantieneSusRolesAlMezclar(){
        // arrange
        Mazo mazo = new Mazo(5);
        List<Rol> mazoOriginal = new ArrayList<>(mazo.getRoles());

        // act
        mazo.mezclar();

        // assert
        assertTrue(mazoOriginal.containsAll(mazo.getRoles()),
                "El mazo mezclado no contiene las mismas cartas");
    }

    @Test
    public void test09UnMazoCon7RolesMantieneSuTamanioAlMezclar(){
        // arrange
        Mazo mazo = new Mazo(7);
        // act
        mazo.mezclar();
        for(int i = 0; i < 7; i++){
            mazo.agarrarCarta();
        }

        // assert
        assertThrows(NoHayMasCartasException.class,
                mazo::agarrarCarta,
                "El tamaño del mazo cambio al mezclarlo");
    }

    @Test
    public void test10UnMazoCon7RolesMantieneSusRolesAlMezclar(){
        Mazo mazo = new Mazo(7);
        List<Rol> mazoOriginal = new ArrayList<>(mazo.getRoles());

        // act
        mazo.mezclar();

        // assert
        assertTrue(mazoOriginal.containsAll(mazo.getRoles()),
                "El mazo mezclado no contiene las mismas cartas");
    }

    @Test
    public void test11UnMazoCon7RolesSeMezcla(){
        //arrange
        Mazo mazo = new Mazo(7);
        List<Rol> mazoOriginal = new ArrayList<>(mazo.getRoles());

        //act
        mazo.mezclar();

        //assert
        assertNotEquals(mazoOriginal, mazo.getRoles(),
                "El mezclador debería haber cambiado el orden de los elementos");
    }

    @Test
    public void test12UnMazoCon10RolesSeMezcla(){
        //arrange
        Mazo mazo = new Mazo(10);
        List<Rol> mazoOriginal = new ArrayList<>(mazo.getRoles());

        //act
        mazo.mezclar();

        //assert
        assertNotEquals(mazoOriginal, mazo.getRoles(),
                "El mezclador debería haber cambiado el orden de los elementos");
    }

    @Test
    public void test13UnMazoCon10RolesMantieneSusRolesAlMezclar(){
        Mazo mazo = new Mazo(10);
        List<Rol> mazoOriginal = new ArrayList<>(mazo.getRoles());

        // act
        mazo.mezclar();

        // assert
        assertTrue(mazoOriginal.containsAll(mazo.getRoles()),
                "El mazo mezclado no contiene las mismas cartas");
    }

    @Test
    public void test14UnMazoCon10RolesMantieneSuTamanioAlMezclar(){
        // arrange
        Mazo mazo = new Mazo(10);
        // act
        mazo.mezclar();
        for(int i = 0; i < 10; i++){
            mazo.agarrarCarta();
        }

        // assert
        assertThrows(NoHayMasCartasException.class,
                mazo::agarrarCarta,
                "El tamaño del mazo cambio al mezclarlo");
    }

    @Test
    public void test15JugadorNoPuedeVerElRolDeOtroJugador(){
        // Arrange
        Jugador ciudadano1 = new Jugador(new Ciudadano(), "ciudadano1");
        Jugador ciudadano2 = new Jugador(new Ciudadano(), "ciudadano2");

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> ciudadano1.verRol(ciudadano2), "Un jugador puede ver el rol de otro");
    }

    @Test
    public void test16JugadorPuedeVerSuRol(){
        // Arrange
        Medico medico = new Medico();
        Jugador jugador = new Jugador(medico, "medico");

        // Act y Assert
        assertEquals(medico, jugador.verRol(jugador));
    }

    @Test
    public void test17MafiosoPuedeVerUnMafioso(){
        // Arrange
        Mafioso mafioso = new Mafioso();
        Mafioso mafiosoObservado = new Mafioso();

        // Act
        Rol result = mafioso.verBando(mafiosoObservado);

        // Assert
        assertEquals(result, mafiosoObservado, "El mafioso no pudo ver el bando de otro mafioso");
    }

    @Test
    public void test18MafiosoNoPuedeVerUnCiudadano(){
        // Arrange
        Mafioso mafioso = new Mafioso();
        Ciudadano ciudadanoObservado = new Ciudadano();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> mafioso.verBando(ciudadanoObservado),
                "El mafioso no pudo ver el bando de un ciudadano");
    }

    @Test
    public void test19MafiosoNoPuedeVerUnSheriff(){
        // Arrange
        Mafioso mafioso = new Mafioso();
        Sheriff sheriffObservado = new Sheriff();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> mafioso.verBando(sheriffObservado),
                "El mafioso no pudo ver el bando de un sheriff");
    }

    @Test
    public void test20MafiosoNoPuedeVerUnDetective(){
        // Arrange
        Mafioso mafioso = new Mafioso();
        Detective detectiveObservado = new Detective();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> mafioso.verBando(detectiveObservado),
                "El mafioso no pudo ver el bando de un detective");
    }

    @Test
    public void test21MafiosoNoPuedeVerUnMedico(){
        // Arrange
        Mafioso mafioso = new Mafioso();
        Medico medicoObservado = new Medico();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> mafioso.verBando(medicoObservado),
                "El mafioso no pudo ver el bando de un medico");
    }

    @Test
    public void test22MafiosoPuedeVerUnPadrino(){
        // Arrange
        Mafioso mafioso = new Mafioso();
        Padrino padrinoObservado = new Padrino();

        // Act
        Rol result = mafioso.verBando(padrinoObservado);

        // Assert
        assertEquals(new Mafioso(), result, "El mafioso no pudo observar un padrino.");
    }

    @Test
    public void test23LaMafiaPuedeSeleccionarVictimaValida() {
        // Arrange
        Jugador ciudadano1 = new Jugador(new Ciudadano(), "ciudadano1");
        Jugador mafioso1 = new Jugador(new Mafioso(), "mafioso1");
        FaseNocturna fase = new FaseNocturna();

        // Act
        mafioso1.accionNocturna(fase, ciudadano1);
        fase.finalizar();

        // Assert
        assertFalse(ciudadano1.estaVivo(),"La mafia no pudo matar a una víctima valida");
    }

    @Test
    public void test24LaMafiaNoPuedeSeleccionarVictimaMuerta() {
        // Arrange
        Jugador ciudadano1 = new Jugador(new Ciudadano(), "ciudadano1");
        Jugador mafioso1 = new Jugador(new Mafioso(), "mafioso1");
        FaseNocturna fase = new FaseNocturna();

        ciudadano1.morir();

        // Act y Assert
        assertThrows(ObjetivoMuertoException.class, () -> mafioso1.accionNocturna(fase, ciudadano1),
                "La mafia seleccionó una víctima invalida");
    }

    @Test
    public void test25ElMedicoProtegeAlMismoJugadorQueEligioLaMafia(){
        // Arrange
        Jugador ciudadano1 = new Jugador(new Ciudadano(), "ciudadano1");
        Jugador mafioso1 = new Jugador(new Mafioso(), "mafioso1");
        Jugador medico = new Jugador(new Medico(), "medico");
        FaseNocturna fase = new FaseNocturna();

        // Act
        mafioso1.accionNocturna(fase, ciudadano1);
        medico.accionNocturna(fase, ciudadano1);

        // Assert
        assertThrows(ObjetivoProtegidoException.class, fase::finalizar,"El medico protegió al objetivo de la mafia");
    }

    @Test
    public void test26LaMafiaEligeAUnJugadorNoProtegido(){
        // Arrange
        Jugador ciudadano1 = new Jugador(new Ciudadano(), "ciudadano1");
        Jugador ciudadano2= new Jugador(new Ciudadano(), "ciudadano2");
        Jugador mafioso1 = new Jugador(new Mafioso(), "mafioso1");
        Jugador medico = new Jugador(new Medico(), "medico");
        FaseNocturna fase = new FaseNocturna();

        // Act
        mafioso1.accionNocturna(fase, ciudadano1);
        medico.accionNocturna(fase, ciudadano2);
        fase.finalizar();

        // Assert
        assertFalse(ciudadano1.estaVivo(),"El objetivo fue eliminado");
    }

    @Test
    public void test27NoSePuedeMatarAOtroMafioso(){
        // Arrange
        Jugador mafioso1 = new Jugador(new Mafioso(), "mafioso1");
        Jugador mafioso2 = new Jugador(new Mafioso(), "mafioso2");
        FaseNocturna fase = new FaseNocturna();

        // Act y Assert
        assertThrows(VotarMismoRolException.class,
                () -> mafioso1.accionNocturna(fase, mafioso2),
                "Los mafiosos pudieron eliminar a otro mafioso1");
    }
}
