package edu.fiuba.algo3.modelo;

import java.util.List;

public class ConfiguracionGrande implements ConfiguracionDeMazo{
    @Override
    public boolean aplicaPara(int cantidadJugadores) {
        return cantidadJugadores>=10 && cantidadJugadores<= 12;
    }

    @Override
    public void agregarRolesEspeciales(List<Rol> mazo) {
        mazo.add(new Detective());
        mazo.add(new Medico());
        mazo.add(new Padrino());
        mazo.add(new Sheriff());

    }


    @Override
    public int obtenerCantidadMafiosos() {
        return 2;
    }
}
