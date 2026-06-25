package edu.fiuba.algo3.modelo.mazo;
import edu.fiuba.algo3.modelo.excepciones.NoHayMasCartasException;
import edu.fiuba.algo3.modelo.roles.*;
import java.util.*;

public class Mazo {
    private final List<Rol> cartas;

    public Mazo(int cantidadDeCartas) {
        CreadorDeMazo configuracion = CreadorDeConfiguracion.crearConfigAutomatica(cantidadDeCartas);
        cartas = configuracion.obtenerRoles();
    }

    public Rol agarrarCarta(){
        try{
            return cartas.remove(0);
        }catch (IndexOutOfBoundsException e){
            throw new NoHayMasCartasException();
        }
    }

    public void mezclar(){
        List<Rol> copia = new ArrayList<>(cartas);
        do{
            Collections.shuffle(this.cartas);
        }while(copia.equals(cartas));

    }

    public List<Rol> getRoles(){
        return List.copyOf(cartas);
    }
}
