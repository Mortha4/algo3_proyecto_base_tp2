package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.roles.*;

import java.util.*;


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

        if (cantidadJugadores >= 7 && cantidadJugadores <= 9) {
            int cantidadMafiosos = random.nextBoolean() ? 3 : 2;

            for (int i = 0; i < cantidadMafiosos; i++) {
                mazo.add(new Mafioso());
            }

            mazo.add(new Detective());
            mazo.add(new Medico());

            for (int i = 0; i < cantidadJugadores - cantidadMafiosos - 2; i++) {
                mazo.add(new Ciudadano());
            }
        }

        if (cantidadJugadores >= 10 && cantidadJugadores <= 12) {
            int cantidadMafiosos = 2 ;

            for (int i = 0; i < cantidadMafiosos; i++) {
                mazo.add(new Mafioso());
            }

            mazo.add(new Detective());
            mazo.add(new Medico());
            mazo.add(new Padrino());
            mazo.add(new Sheriff());


            for (int i = 0; i < cantidadJugadores - cantidadMafiosos - 4; i++) {
                mazo.add(new Ciudadano());
            }
        }
        Collections.shuffle(mazo);
        return mazo;
    }


}
