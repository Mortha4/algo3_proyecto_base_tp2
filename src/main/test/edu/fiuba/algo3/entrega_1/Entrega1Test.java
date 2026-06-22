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
    public void test01MazoPara5JugadoresTieneLaDistribucionCorrectaDeRoles(){
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
        assertTrue(cantMafiosos == 1 || cantMafiosos == 2,
                "Un mazo para 5 jugadores debería tener 1 o 2 mafiosos");
        assertEquals(1, cantMedico + cantDetective,
                "Un mazo para 5 jugadores debería tener exactamente un rol especial");
        assertTrue(cantCiudadanos == 2 || cantCiudadanos == 3,
                "Un mazo para 5 jugadores debería tener 2 o 3 ciudadanos");
    }

    @Test
    public void test02MazoPara7JugadoresTieneLaDistribucionCorrectaDeRoles(){
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
        assertTrue(cantMafiosos >= 2 && cantMafiosos <= 3,
                "Un mazo para 7 jugadores debería tener 2 o 3 mafiosos");
        assertEquals(2, cantMedico + cantDetective,
                "Un mazo para 7 jugadores debería tener exactamente 2 roles especiales");
        assertTrue(cantCiudadanos == 2 || cantCiudadanos == 3,
                "Un mazo para 7 jugadores debería tener 2 o 3 ciudadanos");
    }

    @Test
    public void test03MazoPara10JugadoresTieneLaDistribucionCorrectaDeRoles(){
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
        assertEquals(3, cantMafiosos,
                "Un mazo para 10 jugadores debería tener exactamente 3 mafiosos");
        assertEquals(1,cantMedico,
                "Un mazo para 10 jugadores debería tener exactamente un médico");
        assertEquals(1,cantPadrinos,
                "Un mazo para 10 jugadores debería tener exactamente un padrino");
        assertEquals(1,cantDetective,
                "Un mazo para 10 jugadores debería tener exactamente un detective");
        assertEquals(1,cantSheriff,
                "Un mazo para 10 jugadores debería tener exactamente un sheriff");
        assertEquals(3, cantCiudadanos,
                "Un mazo para 10 jugadores debería tener exactamente 3 ciudadanos");
    }

    @Test
    public void test04NoSePuedeCrearUnMazoConMenosDe5Roles(){
        // Arrange
        int cantidadDeRoles = 4;

        // Act y Assert
        assertThrows(CantidadDeJugadoresException.class, ()-> new Mazo(cantidadDeRoles),
                "No debería poder crearse un mazo con menos de 5 roles");
    }

    @Test
    public void test05NoSePuedeCrearUnMazoConMasDe12Roles(){
        // Arrange
        int cantidadDeRoles = 13;

        // Act y Assert
        assertThrows(CantidadDeJugadoresException.class, ()-> new Mazo(cantidadDeRoles),
                "No debería poder crearse un mazo con más de 12 roles");
    }

    @Test
    public void test06UnMazoDe5RolesCambiaElOrdenAlMezclarse(){
        //arrange
        Mazo mazo = new Mazo(5);
        List<Rol> mazoOriginal = new ArrayList<>(mazo.getRoles());

        //act
        mazo.mezclar();

        //assert
        assertNotEquals(mazoOriginal, mazo.getRoles(),
                "Un mazo de 5 roles debería cambiar el orden de sus cartas al mezclarse");
    }

    @Test
    public void test07UnMazoDe5RolesMantieneSuTamanioAlMezclarse(){
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
                "Un mazo de 5 roles debería mantener su tamaño al mezclarse");
    }

    @Test
    public void test08UnMazoDe5RolesMantieneSusRolesAlMezclarse(){
        // arrange
        Mazo mazo = new Mazo(5);
        List<Rol> mazoOriginal = new ArrayList<>(mazo.getRoles());

        // act
        mazo.mezclar();

        // assert
        assertTrue(mazoOriginal.containsAll(mazo.getRoles()),
                "Un mazo de 5 roles debería conservar las mismas cartas al mezclarse");
    }

    @Test
    public void test09UnMazoDe7RolesMantieneSuTamanioAlMezclarse(){
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
                "Un mazo de 7 roles debería mantener su tamaño al mezclarse");
    }

    @Test
    public void test10UnMazoDe7RolesMantieneSusRolesAlMezclarse(){
        Mazo mazo = new Mazo(7);
        List<Rol> mazoOriginal = new ArrayList<>(mazo.getRoles());

        // act
        mazo.mezclar();

        // assert
        assertTrue(mazoOriginal.containsAll(mazo.getRoles()),
                "Un mazo de 7 roles debería conservar las mismas cartas al mezclarse");
    }

    @Test
    public void test11UnMazoDe7RolesCambiaElOrdenAlMezclarse(){
        //arrange
        Mazo mazo = new Mazo(7);
        List<Rol> mazoOriginal = new ArrayList<>(mazo.getRoles());

        //act
        mazo.mezclar();

        //assert
        assertNotEquals(mazoOriginal, mazo.getRoles(),
                "Un mazo de 7 roles debería cambiar el orden de sus cartas al mezclarse");
    }

    @Test
    public void test12UnMazoDe10RolesCambiaElOrdenAlMezclarse(){
        //arrange
        Mazo mazo = new Mazo(10);
        List<Rol> mazoOriginal = new ArrayList<>(mazo.getRoles());

        //act
        mazo.mezclar();

        //assert
        assertNotEquals(mazoOriginal, mazo.getRoles(),
                "Un mazo de 10 roles debería cambiar el orden de sus cartas al mezclarse");
    }

    @Test
    public void test13UnMazoDe10RolesMantieneSusRolesAlMezclarse(){
        Mazo mazo = new Mazo(10);
        List<Rol> mazoOriginal = new ArrayList<>(mazo.getRoles());

        // act
        mazo.mezclar();

        // assert
        assertTrue(mazoOriginal.containsAll(mazo.getRoles()),
                "Un mazo de 10 roles debería conservar las mismas cartas al mezclarse");
    }

    @Test
    public void test14UnMazoDe10RolesMantieneSuTamanioAlMezclarse(){
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
                "Un mazo de 10 roles debería mantener su tamaño al mezclarse");
    }

    @Test
    public void test15UnJugadorNoPuedeVerElRolDeOtroJugador(){
        // Arrange
        Jugador ciudadano1 = new Jugador(new Ciudadano(), "ciudadano1");
        Jugador ciudadano2 = new Jugador(new Ciudadano(), "ciudadano2");

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> ciudadano1.verRol(ciudadano2),
                "Un jugador no debería poder ver el rol de otro jugador");
    }

    @Test
    public void test16UnJugadorPuedeVerSuPropioRol(){
        // Arrange
        Medico medico = new Medico();
        Jugador jugador = new Jugador(medico, "medico");

        // Act y Assert
        assertEquals(medico, jugador.verRol(jugador),
                "Un jugador debería poder ver su propio rol");
    }

    @Test
    public void test17UnMafiosoPuedeIdentificarAOtroMafioso(){
        // Arrange
        Mafioso mafioso = new Mafioso();
        Mafioso mafiosoObservado = new Mafioso();

        // Act
        Rol result = mafioso.verBando(mafiosoObservado);

        // Assert
        assertEquals(mafiosoObservado, result,
                "Un mafioso debería poder identificar a otro mafioso");
    }

    @Test
    public void test18UnMafiosoNoPuedeIdentificarAUnCiudadano(){
        // Arrange
        Mafioso mafioso = new Mafioso();
        Ciudadano ciudadanoObservado = new Ciudadano();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> mafioso.verBando(ciudadanoObservado),
                "Un mafioso no debería poder identificar a un ciudadano");
    }

    @Test
    public void test19UnMafiosoNoPuedeIdentificarAUnSheriff(){
        // Arrange
        Mafioso mafioso = new Mafioso();
        Sheriff sheriffObservado = new Sheriff();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> mafioso.verBando(sheriffObservado),
                "Un mafioso no debería poder identificar a un sheriff");
    }

    @Test
    public void test20UnMafiosoNoPuedeIdentificarAUnDetective(){
        // Arrange
        Mafioso mafioso = new Mafioso();
        Detective detectiveObservado = new Detective();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> mafioso.verBando(detectiveObservado),
                "Un mafioso no debería poder identificar a un detective");
    }

    @Test
    public void test21UnMafiosoNoPuedeIdentificarAUnMedico(){
        // Arrange
        Mafioso mafioso = new Mafioso();
        Medico medicoObservado = new Medico();

        // Act y Assert
        assertThrows(NoVisibleException.class, () -> mafioso.verBando(medicoObservado),
                "Un mafioso no debería poder identificar a un médico");
    }

    @Test
    public void test22UnMafiosoPuedeIdentificarAUnPadrinoComoMafioso(){
        // Arrange
        Mafioso mafioso = new Mafioso();
        Padrino padrinoObservado = new Padrino();

        // Act
        Rol result = mafioso.verBando(padrinoObservado);

        // Assert
        assertEquals(new Mafioso(), result,
                "Un mafioso debería identificar a un padrino como mafioso");
    }

    @Test
    public void test23LaMafiaPuedeEliminarAUnaVictimaValida() {
        // Arrange
        Jugador ciudadano1 = new Jugador(new Ciudadano(), "ciudadano1");
        Jugador mafioso1 = new Jugador(new Mafioso(), "mafioso1");
        FaseNocturna fase = new FaseNocturna();

        // Act
        mafioso1.accionNocturna(fase, ciudadano1);
        fase.finalizar();

        // Assert
        assertFalse(ciudadano1.estaVivo(),
                "La mafia debería poder eliminar a una víctima válida");
    }

    @Test
    public void test24LaMafiaNoPuedeSeleccionarAUnaVictimaMuerta() {
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
    public void test25ElMedicoPuedeProtegerAlJugadorElegidoPorLaMafia(){
        // Arrange
        Jugador ciudadano1 = new Jugador(new Ciudadano(), "ciudadano1");
        Jugador mafioso1 = new Jugador(new Mafioso(), "mafioso1");
        Jugador medico = new Jugador(new Medico(), "medico");
        FaseNocturna fase = new FaseNocturna();

        // Act
        mafioso1.accionNocturna(fase, ciudadano1);
        medico.accionNocturna(fase, ciudadano1);

        // Assert
        assertThrows(ObjetivoProtegidoException.class, fase::finalizar,
                "La fase nocturna debería indicar que el objetivo de la mafia fue protegido por el médico");
    }

    @Test
    public void test26LaMafiaEliminaAUnJugadorNoProtegido(){
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
        assertFalse(ciudadano1.estaVivo(),
                "La mafia debería eliminar a un jugador que no fue protegido por el médico");
    }

    @Test
    public void test27LaMafiaNoPuedeEliminarAOtroMafioso(){
        // Arrange
        Jugador mafioso1 = new Jugador(new Mafioso(), "mafioso1");
        Jugador mafioso2 = new Jugador(new Mafioso(), "mafioso2");
        FaseNocturna fase = new FaseNocturna();

        // Act y Assert
        assertThrows(VotacionEntreMafiososException.class,
                () -> mafioso1.accionNocturna(fase, mafioso2),
                "La mafia no debería poder eliminar a otro mafioso");
    }
}
