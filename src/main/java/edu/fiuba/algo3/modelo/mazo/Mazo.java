package edu.fiuba.algo3.modelo.mazo;
import edu.fiuba.algo3.modelo.excepciones.NoHayMasCartasException;
import edu.fiuba.algo3.modelo.roles.*;
import java.util.*;

public class Mazo {
    private ConfiguracionDeMazo configuracion;
    private List<Rol> cartas = new ArrayList<>();

    public Mazo(int cantidadDeCartas) {
        this.configuracion = CreadorDeConfiguracion.crearConfig(cantidadDeCartas);
        crearRoles();
        rellenar(cantidadDeCartas);
    }

    public Mazo(int cantidadDeCartas, ConfiguracionDeMazo configuracion) {
        this.configuracion = configuracion;
        crearRoles();
        rellenar(cantidadDeCartas);
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

    private void agregar(Integer cantidad, Rol rol) {
        if(cantidad != null){
            for(int i = 0; i<cantidad; i++){
                cartas.add(rol);
            }
        }
    }

    private void rellenar(int cantidadDeCartas){
        for(int i = cartas.size(); i < cantidadDeCartas; i++){
            cartas.add(new Ciudadano());
        }
    }

    private void crearRoles() {
        Map<String, Integer> config = new HashMap<>();
        configuracion.obtenerConfig(config);
        agregar(config.get("Detective"), new Detective());
        agregar(config.get("Sheriff"), new Sheriff());
        agregar(config.get("Padrino"), new Padrino());
        agregar(config.get("Medico"), new Medico());
        agregar(config.get("Mafioso"), new Mafioso());
    }
}
