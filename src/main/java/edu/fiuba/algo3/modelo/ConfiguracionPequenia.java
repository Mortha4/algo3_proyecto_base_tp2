package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Random;
import edu.fiuba.algo3.modelo.roles.*;

public class ConfiguracionPequenia implements ConfiguracionDeMazo{
    private Random random = new Random();

    @Override
    public boolean aplicaPara(int cantidadJugadores) {
        return cantidadJugadores>=5  && cantidadJugadores <= 6;
    }

    @Override
    public void agregarRolesEspeciales(List<Rol> mazo) {
        if(random.nextBoolean()){
            mazo.add(new Detective());
        }else{
            mazo.add(new Medico());
        }

    }

    @Override
    public int obtenerCantidadMafiosos() {
        return random.nextBoolean() ? 2 : 1;
    }
}
