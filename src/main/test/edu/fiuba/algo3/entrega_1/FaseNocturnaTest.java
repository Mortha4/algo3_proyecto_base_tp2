package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.FaseNocturna;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Mafioso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FaseNocturnaTest {
    @Test
    public void test01LaMafiaPuedeSeleccionarVictimaValida() {
        Jugador ciudadano = new Jugador(new Ciudadano());
        Jugador mafioso = new Jugador(new Mafioso());

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(ciudadano);
        jugadores.add(mafioso);

        FaseNocturna faseNocturna = new FaseNocturna(jugadores);
    }
}
