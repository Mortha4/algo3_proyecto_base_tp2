package edu.fiuba.algo3.entrega_1;


import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class MazoTest {


    @Test
    public void test01MazoPara5JugadoresTieneLaCantidadCorrectaDeRoles(){
        //arrange
        int cantidadJugadores = 5;
        long cantMafiosos , cantCiudadanos , cantDetective ,cantMedico ;
        CreadorDeMazo creador = new CreadorDeMazo();
        List<Rol> mazo = creador.crearMazo(cantidadJugadores);

        //act
        cantMafiosos = mazo.stream().filter(rol -> Objects.equals(rol.getTipo(), "Mafioso")).count();
        cantMedico = mazo.stream().filter(rol -> Objects.equals(rol.getTipo(), "Medico")).count();
        cantDetective = mazo.stream().filter(rol -> Objects.equals(rol.getTipo(), "Detective")).count();
        cantCiudadanos = mazo.stream().filter(rol -> Objects.equals(rol.getTipo(), "Ciudadano")).count();

        //assert

        assertEquals(5, mazo.size(), "Tamaño de mazo invalido");
        assertTrue(cantMafiosos >= 1 && cantMafiosos <= 2, "Cantidad de mafiosos invalida");
        assertEquals(1, cantMedico + cantDetective,  "Solamente se permite un rol especial");
        assertTrue(cantCiudadanos >= 2 && cantCiudadanos <= 3,"Cantidad de ciudadano invalida");


    }

    @Test
    public void test02MazoPara7JugadoresTieneLaCantidadCorrectaDeRoles(){
        //arrange
        int cantidadJugadores = 7;
        long cantMafiosos , cantCiudadanos , cantDetective ,cantMedico ;
        CreadorDeMazo creador = new CreadorDeMazo();
        List<Rol> mazo = creador.crearMazo(cantidadJugadores);

        //act
        cantMafiosos = mazo.stream().filter(rol -> Objects.equals(rol.getTipo(),"Mafioso")).count();
        cantMedico = mazo.stream().filter(rol -> Objects.equals(rol.getTipo(),"Medico")).count();
        cantDetective = mazo.stream().filter(rol -> Objects.equals(rol.getTipo(),"Detective")).count();
        cantCiudadanos = mazo.stream().filter(rol -> Objects.equals(rol.getTipo(),"Ciudadano")).count();

        //assert

        assertEquals(7, mazo.size(), "Tamaño de mazo invalido");
        assertTrue(cantMafiosos >= 2 && cantMafiosos <= 3, "Cantidad de mafiosos invalida");
        assertEquals(2, cantMedico + cantDetective,  "Solamente se permiten 2 roles especiales");
        assertTrue(cantCiudadanos >= 2 && cantCiudadanos <= 3,"Cantidad de ciudadano invalida");



    }

    @Test
    public void test03MazoPara10JugadoresTieneLaCantidadCorrectaDeRoles(){
        //arrange
        int cantidadJugadores = 10;
        long cantMafiosos , cantCiudadanos , cantDetective ,cantMedico ,cantPadrino ,cantSheriff ;
        CreadorDeMazo creador = new CreadorDeMazo();
        List<Rol> mazo = creador.crearMazo(cantidadJugadores);

        //act
        cantMafiosos = mazo.stream().filter(rol -> Objects.equals(rol.getTipo(),"Mafioso")).count();
        cantMedico = mazo.stream().filter(rol -> Objects.equals(rol.getTipo(),"Medico")).count();
        cantDetective = mazo.stream().filter(rol -> Objects.equals(rol.getTipo(),"Detective")).count();
        cantCiudadanos = mazo.stream().filter(rol -> Objects.equals(rol.getTipo(),"Ciudadano")).count();
        cantPadrino = mazo.stream().filter(rol -> Objects.equals(rol.getTipo(),"Padrino")).count();
        cantSheriff = mazo.stream().filter(rol -> Objects.equals(rol.getTipo(),"Sheriff")).count();

        //assert

        assertEquals(10, mazo.size(), "Tamaño de mazo invalido");
        assertEquals(2,cantMafiosos,"cantidad de mafiosos invalido");
        assertEquals(1,cantMedico,"solamente existe un unico medico");
        assertEquals(1,cantPadrino,"error solo debe existir un padrino");
        assertEquals(1,cantDetective,"error solo debe existir un detective");
        assertEquals(1,cantSheriff,"error solo debe existir un sheriff");
        assertEquals(4,cantCiudadanos,"Cantidad de ciudadano invalida");


    }

    @Test
    public void test04UnMazoConDetective_Medico_Ciudadano_Y_2MafiososSeMezclaAleatoriamente(){
        //arrange
        MezcladorDeMazo mezclador = new MezcladorDeMazo();
        Medico unMedico = new Medico();
        Detective unDetective = new Detective();
        Ciudadano unCiudadano = new Ciudadano();
        Mafioso unMafioso0 = new Mafioso();
        Mafioso unMafioso1 = new Mafioso();
        List<Rol> mazoOriginal = new ArrayList<>(List.of(unDetective,unMedico,unCiudadano,unMafioso0,unMafioso1));
        List<Rol> mazoMezclado = new ArrayList<>((mazoOriginal));

        //act

        mezclador.mezclar(mazoMezclado);

        //assert

        assertEquals(mazoOriginal.size(),mazoMezclado.size(),"El mazo mezclado debe tener la misma cantidad de cartas que el mazo sin mezclar");
        assertTrue(mazoMezclado.containsAll(mazoOriginal), "El mazo mezclado debe contener exactamente las mismas cartas");
        assertNotEquals(mazoOriginal, mazoMezclado, "El mezclador debería haber cambiado el orden de los elementos");
        

    }

    @Test
    public void test05UnMazoConDetective_Medico_Ciudadano_2Mafiosos_Padrino_y_SheriffSeMezclaAleatoriamente(){
        //arrange
        MezcladorDeMazo mezclador = new MezcladorDeMazo();
        Medico unMedico = new Medico();
        Detective unDetective = new Detective();
        Ciudadano unCiudadano = new Ciudadano();
        Mafioso unMafioso0 = new Mafioso();
        Mafioso unMafioso1 = new Mafioso();
        Padrino unPadrino = new Padrino();
        Sheriff unSheriff = new Sheriff();
        List<Rol> mazoOriginal = new ArrayList<>(List.of(unDetective,unMedico,unCiudadano,unMafioso0,unMafioso1,unPadrino,unSheriff));
        List<Rol> mazoMezclado = new ArrayList<>((mazoOriginal));

        //act

        mezclador.mezclar(mazoMezclado);

        //assert

        assertEquals(mazoOriginal.size(),mazoMezclado.size(),"El mazo mezclado debe tener la misma cantidad de cartas que el mazo sin mezclar");
        assertTrue(mazoMezclado.containsAll(mazoOriginal), "El mazo mezclado debe contener exactamente las mismas cartas");
        assertNotEquals(mazoOriginal, mazoMezclado, "El mezclador debería haber cambiado el orden de los elementos");


    }

}
