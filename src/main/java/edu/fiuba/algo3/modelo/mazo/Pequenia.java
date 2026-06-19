package edu.fiuba.algo3.modelo.mazo;
import edu.fiuba.algo3.modelo.roles.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pequenia extends CreadorDeMazo {
    private final Random random = new Random();

    public Pequenia(int cantidadDeRoles){
        this.cantidadDeRoles = cantidadDeRoles;
    }
    @Override
    public List<Rol> obtenerRoles() {
        List<Rol> roles = new ArrayList<>();
        if(random.nextBoolean()) {
            roles.add(new Detective());
        } else {
            roles.add(new Medico());
        }

        int cantidadDeMafiosos;

        if(random.nextBoolean()) {
            cantidadDeMafiosos = 1;
        } else {
            cantidadDeMafiosos = 2;
        }
        for(int i = 0; i < cantidadDeMafiosos; i++){
            roles.add(new Mafioso());
        }
        rellenarConCiudadanos(roles);
        return roles;
    }
}
