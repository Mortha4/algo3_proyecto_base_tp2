package edu.fiuba.algo3.entrega_1;


import jdk.jshell.JShell;
import org.junit.Test;
import edu.fiuba.algo3.modelo.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MazoTest {


    @Test
    public void test01MazoPara5Jugadores(){
        //arrange
        int cantidadJugadores = 5;
        long cantMafiosos , cantCiudadanos , cantDetective ,cantMedico ;
        CreadorDeMazo creador = new CreadorDeMazo();
        List<Rol> mazo = creador.crearMazo(cantidadJugadores);

        //act
        cantMafiosos = mazo.stream().filter(rol -> rol instanceof Mafioso).count();
        cantMedico = mazo.stream().filter(rol -> rol instanceof Medico).count();
        cantDetective = mazo.stream().filter(rol -> rol instanceof Detective).count();
        cantCiudadanos = mazo.stream().filter(rol -> rol instanceof Ciudadano).count();

        //assert

        assertEquals(5, mazo.size(), "Tamaño de mazo invalido");
        assertTrue(cantMafiosos >= 1 && cantMafiosos <= 2, "Cantidad de mafiosos invalida");
        assertEquals(1, cantMedico + cantDetective,  "Solamente se permite un rol especial");
        assertEquals(5, cantMafiosos + cantMedico + cantDetective + cantCiudadanos);


    }

    @Test
    public void test02MazoPara7Jugadores(){
        //arrange
        int cantidadJugadores = 7;
        long cantMafiosos , cantCiudadanos , cantDetective ,cantMedico ;
        CreadorDeMazo creador = new CreadorDeMazo();
        List<Rol> mazo = creador.crearMazo(cantidadJugadores);

        //act
        cantMafiosos = mazo.stream().filter(rol -> rol instanceof Mafioso).count();
        cantMedico = mazo.stream().filter(rol -> rol instanceof Medico).count();
        cantDetective = mazo.stream().filter(rol -> rol instanceof Detective).count();
        cantCiudadanos = mazo.stream().filter(rol -> rol instanceof Ciudadano).count();

        //assert

        assertEquals(7, mazo.size(), "Tamaño de mazo invalido");
        assertTrue(cantMafiosos >= 2 && cantMafiosos <= 3, "Cantidad de mafiosos invalida");
        assertEquals(2, cantMedico + cantDetective,  "Solamente se permiten 2 roles especiales");
        assertEquals(7, cantMafiosos + cantMedico + cantDetective + cantCiudadanos);


    }

    @Test
    public void test03MazoPara10Jugadores(){
        //arrange
        int cantidadJugadores = 10;
        long cantMafiosos , cantCiudadanos , cantDetective ,cantMedico ,cantPadrino ,cantSheriff ;
        CreadorDeMazo creador = new CreadorDeMazo();
        List<Rol> mazo = creador.crearMazo(cantidadJugadores);

        //act
        cantMafiosos = mazo.stream().filter(rol -> rol instanceof Mafioso).count();
        cantPadrino = mazo.stream().filter(rol -> rol instanceof Padrino).count();
        cantSheriff = mazo.stream().filter(rol -> rol instanceof Sheriff).count();
        cantMedico = mazo.stream().filter(rol -> rol instanceof Medico).count();
        cantDetective = mazo.stream().filter(rol -> rol instanceof Detective).count();
        cantCiudadanos = mazo.stream().filter(rol -> rol instanceof Ciudadano).count();

        //assert

        assertEquals(7, mazo.size(), "Tamaño de mazo invalido");
        assertEquals(3,cantMafiosos,"cantidad de mafiosos invalido");
        assertEquals(1,cantMedico,"solamente existe un unico medico");
        assertEquals(1,cantPadrino,"error solo debe existir un padrino");
        assertEquals(1,cantDetective,"error solo debe existir un detective");
        assertEquals(7, cantMafiosos + cantMedico + cantDetective + cantCiudadanos +cantSheriff +cantPadrino,"Composicion de roles invalido");


    }
    

}
