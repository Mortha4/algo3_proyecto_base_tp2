package edu.fiuba.algo3.modelo.mazo;
import edu.fiuba.algo3.modelo.roles.*;

import java.util.ArrayList;
import java.util.List;

public class Grande extends CreadorDeMazo {

    public Grande(int cantidadDeRoles){
        this.cantidadDeRoles = cantidadDeRoles;
    }

    public List<Rol> obtenerRoles() {
        List<Rol> roles = new ArrayList<>();
        roles.add(new Sheriff());
        roles.add(new Detective());
        roles.add(new Padrino());
        roles.add(new Medico());
        for(int i = 0; i < 3; i++){
            roles.add(new Mafioso());
        }
        rellenarConCiudadanos(roles);
        return roles;
    }
}
