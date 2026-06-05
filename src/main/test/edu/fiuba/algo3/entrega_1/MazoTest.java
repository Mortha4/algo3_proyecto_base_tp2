package edu.fiuba.algo3.entrega_1;


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
    

}
