package edu.fiuba.algo3.entrega_1;


import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.*;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MazoTest {


    @Test
    public void test03MazoPara5JugadoresTieneLaCantidadCorrectaDeRoles(){
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
        assertEquals(5, cantMafiosos + cantMedico + cantDetective + cantCiudadanos);


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
        assertEquals(7, cantMafiosos + cantMedico + cantDetective + cantCiudadanos);


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
        assertEquals(10, cantMafiosos + cantMedico + cantDetective + cantCiudadanos +cantSheriff +cantPadrino,"Composicion de roles invalido");


    }

    @Test
    public void test04ElMazoCon5JugadoresSeGeneraAleatoriamenteConPrimeraCarta(){
        //arrange
        int cantidadJugadores = 5,cantidadMafiososInicio=0 ,cantidadCiudadanosInicio=0,cantidadDetectiveInicio=0,cantidadMedicoInicio=0;
        CreadorDeMazo creador = new CreadorDeMazo();
        List<Rol> mazo;
        Rol primerRol;

        //act

        for (int i=0 ; i <= 500 ; i++){
            mazo = creador.crearMazo(cantidadJugadores);
            primerRol = mazo.get(0);

            if(Objects.equals(primerRol.getTipo(), "Mafioso")){
                cantidadMafiososInicio++;
            }else if(Objects.equals(primerRol.getTipo(), "Ciudadano")){
                cantidadCiudadanosInicio++;
            }else if(Objects.equals(primerRol.getTipo(), "Medico")){
                cantidadMedicoInicio++;
            }else if(Objects.equals(primerRol.getTipo(), "Detective")){
                cantidadDetectiveInicio++;
            }

        }

        //assert
        assertTrue(cantidadMafiososInicio >0 ,"el mafioso nunca salio primero");
        assertTrue(cantidadCiudadanosInicio >0 ,"el ciudadano nunca salio primero");
        assertTrue(cantidadMedicoInicio >0 ,"el medico nunca salio primero");
        assertTrue(cantidadDetectiveInicio >0 ,"el detective nunca salio primero");

    }

    @Test
    public void test05ElMazoCon7JugadoresSeGeneraAleatoriamenteConPrimeraCarta(){
        //arrange
        int cantidadJugadores = 7,cantidadMafiososInicio=0 ,cantidadCiudadanosInicio=0,cantidadDetectiveInicio=0,cantidadMedicoInicio=0;
        CreadorDeMazo creador = new CreadorDeMazo();
        List<Rol> mazo;
        Rol primerRol;

        //act

        for (int i=0 ; i <= 500 ; i++){
            mazo = creador.crearMazo(cantidadJugadores);
            primerRol = mazo.get(0);

            if(Objects.equals(primerRol.getTipo(), "Mafioso")){
                cantidadMafiososInicio++;
            }else if(Objects.equals(primerRol.getTipo(), "Ciudadano")){
                cantidadCiudadanosInicio++;
            }else if(Objects.equals(primerRol.getTipo(), "Medico")){
                cantidadMedicoInicio++;
            }else if(Objects.equals(primerRol.getTipo(), "Detective")){
                cantidadDetectiveInicio++;
            }

        }

        //assert
        assertTrue(cantidadMafiososInicio >0 ,"el mafioso nunca salio primero");
        assertTrue(cantidadCiudadanosInicio >0 ,"el ciudadano nunca salio primero");
        assertTrue(cantidadMedicoInicio >0 ,"el medico nunca salio primero");
        assertTrue(cantidadDetectiveInicio >0 ,"el detective nunca salio primero");

    }

    @Test
    public void test06ElMazoCon5JugadoresSeGeneraAleatoriamenteConPrimeraCarta(){
        //arrange
        int cantidadJugadores = 10,cantidadMafiososInicio=0 ,cantidadCiudadanosInicio=0,cantidadDetectiveInicio=0,cantidadMedicoInicio=0,cantPadrinoInicio=0,cantSheriffInicio=0;
        CreadorDeMazo creador = new CreadorDeMazo();
        List<Rol> mazo;
        Rol primerRol;

        //act

        for (int i=0 ; i <= 500 ; i++){
            mazo = creador.crearMazo(cantidadJugadores);
            primerRol = mazo.get(0);

            if(Objects.equals(primerRol.getTipo(), "Mafioso")){
                cantidadMafiososInicio++;
            }else if(Objects.equals(primerRol.getTipo(), "Ciudadano")){
                cantidadCiudadanosInicio++;
            }else if(Objects.equals(primerRol.getTipo(), "Medico")){
                cantidadMedicoInicio++;
            }else if(Objects.equals(primerRol.getTipo(), "Detective")){
                cantidadDetectiveInicio++;
            }else if(Objects.equals(primerRol.getTipo(), "Sheriff")){
                cantSheriffInicio++;
            }else if(Objects.equals(primerRol.getTipo(), "Padrino")){
                cantPadrinoInicio++;
            }

        }

        //assert
        assertTrue(cantidadMafiososInicio >0 ,"el mafioso nunca salio primero");
        assertTrue(cantidadCiudadanosInicio >0 ,"el ciudadano nunca salio primero");
        assertTrue(cantidadMedicoInicio >0 ,"el medico nunca salio primero");
        assertTrue(cantidadDetectiveInicio >0 ,"el detective nunca salio primero");
        assertTrue(cantPadrinoInicio >0 ,"el padrino nunca salio primero");
        assertTrue(cantSheriffInicio >0,"el sheriff nunca salio primero");

    }
    

}
