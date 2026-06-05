package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CreadorDeMazo {
    private final Random random = new Random();

    //constructor



    //metodo
    public List<Rol> crearMazo(int cantidadJugadores) {
        List<Rol> mazo = new ArrayList<>();

        if (cantidadJugadores >= 5 && cantidadJugadores <= 6) {
            int cantidadMafiosos = random.nextBoolean() ? 2 : 1;

            for (int i = 0; i < cantidadMafiosos; i++) {
                mazo.add(new Mafioso());
            }

            if(random.nextBoolean()){
                mazo.add(new Detective());
            }else{
                mazo.add(new Medico());
            }


            for (int i = 0; i < cantidadJugadores - cantidadMafiosos - 1; i++) {
                mazo.add(new Ciudadano());
            }
        }
        return mazo;
    }


}
