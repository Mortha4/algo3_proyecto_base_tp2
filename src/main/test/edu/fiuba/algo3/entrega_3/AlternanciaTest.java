package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.partida.Partida;
import edu.fiuba.algo3.modelo.fase.Fase;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class AlternanciaTest {
    private List<Jugador> mafiosos;
    private List<Jugador> ciudadanos;
    private Jugador unCiudadano;
    private Jugador otroCiudadano;
    private Jugador unMafioso;
    private Jugador detective = null;
    private Jugador medico = null;
    private Partida partida;
    private Fase faseActual;

    public void arrangeDe5Jugadores(){
        partida = new Partida(List.of("1", "2", "3", "4", "5"));
        partida.iniciar();
        faseActual = partida.getFaseActual();
        ciudadanos = new ArrayList<>();
        mafiosos = new ArrayList<>();
        for(Jugador jugador: partida.getJugadores()){
            Rol rol = jugador.getRol();
            if(rol instanceof Mafioso) {
                mafiosos.add(jugador);
            } else if (rol instanceof Ciudadano){
                ciudadanos.add(jugador);
            } else if (rol instanceof Detective){
                detective = jugador;
            } else if (rol instanceof Medico){
                medico = jugador;
            }
        }
        unCiudadano = ciudadanos.get(0);
        otroCiudadano = ciudadanos.get(1);
        unMafioso = mafiosos.get(0);
    }

    @Test
    public void test01TranscurreUnaRondaCorrectamente(){
        // Act

        // Fase Nocturna
        arrangeDe5Jugadores();
        unMafioso.nominar(faseActual, unCiudadano);
        unMafioso.votar(faseActual, unCiudadano);
        partida.cambiarFase();

        // Fase Diurna
        faseActual = partida.getFaseActual();
        otroCiudadano.nominar(faseActual, unMafioso);
        otroCiudadano.votar(faseActual, unMafioso);
        partida.cambiarFase();

        assertFalse(unCiudadano.estaVivo() && unMafioso.estaVivo(),
                "Si se nomino y voto a un ciudadano en la noche y a un mafioso de dia, deberían eliminarse");
    }

    @Test
    public void test02SeActivanLosRolesEnElOrdenCorrecto(){
        // Act

        // Fase Nocturna
        arrangeDe5Jugadores();
        unMafioso.nominar(faseActual, unCiudadano);
        for(Jugador mafioso: mafiosos){
            mafioso.votar(faseActual, unCiudadano);
        }
        if(detective != null){
            detective.accion((FaseNocturna)faseActual, unMafioso);
        } else if (medico != null){
            medico.accion((FaseNocturna) faseActual, otroCiudadano);
        }
        partida.cambiarFase();

        // Fase Diurna
        faseActual = partida.getFaseActual();
        otroCiudadano.nominar(faseActual, unMafioso);
        otroCiudadano.votar(faseActual, unMafioso);
        partida.cambiarFase();

        assertFalse(unCiudadano.estaVivo() && unMafioso.estaVivo(),
                "Si se nomino y voto a un ciudadano en la noche y a un mafioso de dia, deberían eliminarse");
    }
}
