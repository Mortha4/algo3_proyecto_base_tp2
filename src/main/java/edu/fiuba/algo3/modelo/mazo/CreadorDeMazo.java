package edu.fiuba.algo3.modelo.mazo;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Rol;
import java.util.List;

public abstract class CreadorDeMazo {
    protected int cantidadDeRoles;

    protected void rellenarConCiudadanos(List<Rol> roles){
        for(int i = roles.size(); i < cantidadDeRoles; i++){
            roles.add(new Ciudadano());
        }
    }
    public abstract List<Rol> obtenerRoles();
}
