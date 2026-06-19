package edu.fiuba.algo3.modelo.mazo;
import edu.fiuba.algo3.modelo.roles.Detective;
import edu.fiuba.algo3.modelo.roles.Mafioso;
import edu.fiuba.algo3.modelo.roles.Medico;
import edu.fiuba.algo3.modelo.roles.Rol;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mediana extends CreadorDeMazo {
    private final Random random = new Random();

    public Mediana(int cantidadDeRoles){
        this.cantidadDeRoles = cantidadDeRoles;
    }

    public List<Rol> obtenerRoles() {
        List<Rol> roles = new ArrayList<>();
        roles.add(new Detective());
        roles.add(new Medico());

        int cantidadDeMafiosos;

        if(random.nextBoolean()){
            cantidadDeMafiosos = 2;
        } else {
            cantidadDeMafiosos = 3;
        }
        for(int i = 0; i < cantidadDeMafiosos; i++){
            roles.add(new Mafioso());
        }
        rellenarConCiudadanos(roles);
        return roles;
    }
}
