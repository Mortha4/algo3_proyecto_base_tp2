package edu.fiuba.algo3.modelo.configuraciones;

import java.util.List;
import java.util.Random;

import edu.fiuba.algo3.modelo.roles.*;

public class ConfiguracionDeMazoMediana implements ConfiguracionDeMazo {
    private Random random = new Random();

    @Override
    public boolean aplicaPara(int cantidadJugadores) {
        return cantidadJugadores>=7 && cantidadJugadores<= 9;
    }

    @Override
    public void agregarRolesEspeciales(List<Rol> mazo) {
        mazo.add(new Medico());
        mazo.add(new Detective());

    }

    @Override
    public int obtenerCantidadMafiosos() {
        return random.nextBoolean() ? 3 : 2;
    }
}
