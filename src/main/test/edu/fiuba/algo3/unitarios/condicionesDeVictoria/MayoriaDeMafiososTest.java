package edu.fiuba.algo3.unitarios.condicionesDeVictoria;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones.MayoriaDeMafiosos;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.GanaLaMafia;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.NoHayGanador;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Mafioso;
import edu.fiuba.algo3.modelo.roles.Padrino;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MayoriaDeMafiososTest {
    private List<Jugador> jugadores;
    private Jugador mafioso;
    private Jugador padrino;
    private Jugador ciudadano;
    private Jugador ciudadano2;
    private MayoriaDeMafiosos condicion;

    @BeforeEach
    public void arrange(){
        jugadores = new ArrayList<>();
        mafioso = new Jugador(new Mafioso(), "mafioso");
        padrino = new Jugador(new Padrino(), "mafioso");
        ciudadano = new Jugador(new Ciudadano(), "ciudadano");
        ciudadano2 = new Jugador(new Ciudadano(), "ciudadano2");
    }

    @Test
    public void test01ConIgualdadDeBandosGanaLaMafia(){
        // Arrange
        jugadores.addAll(List.of(mafioso, padrino, ciudadano, ciudadano2));
        condicion = new MayoriaDeMafiosos(jugadores);

        // Act y Assert
        assertEquals(GanaLaMafia.class, condicion.chequear().getClass(),
                "Con 2 ciudadanos y 2 mafiosos deberia devolver un GanaLaMafia");
    }

    @Test
    public void test02ConMayoriaDeMafiososGanaLaMafia(){
        // Arrange
        jugadores.addAll(List.of(mafioso, padrino, ciudadano));
        condicion = new MayoriaDeMafiosos(jugadores);

        // Act y Assert
        assertEquals(GanaLaMafia.class, condicion.chequear().getClass(),
                "Con 1 ciudadano y 2 mafiosos deberia devolver un GanaLaMafia");
    }

    @Test
    public void test03ConMayoriaDeCiudadanosNoHayGanador(){
        // Arrange
        jugadores.addAll(List.of(mafioso, ciudadano2, ciudadano));
        condicion = new MayoriaDeMafiosos(jugadores);

        // Act y Assert
        assertEquals(NoHayGanador.class, condicion.chequear().getClass(),
                "Con 2 ciudadanos y 1 mafioso deberia devolver un NoHayGanador");
    }

    @Test
    public void test04ConIgualdadDeBandosPeroUnMuertoNoHayGanador(){
        // Arrange
        mafioso.morir();
        jugadores.addAll(List.of(mafioso, padrino, ciudadano, ciudadano2));
        condicion = new MayoriaDeMafiosos(jugadores);

        // Act y Assert
        assertEquals(NoHayGanador.class, condicion.chequear().getClass(),
                "Con 2 ciudadanos, 1 mafioso vivo y 1 mafioso muerto deberia devolver un NoHayGanador");
    }

    @Test
    public void test05ConMayoriaDeMafiososPeroMuertosNoHayGanador(){
        // Arrange
        mafioso.morir();
        padrino.morir();
        jugadores.addAll(List.of(mafioso, padrino, ciudadano));
        condicion = new MayoriaDeMafiosos(jugadores);

        // Act y Assert
        assertEquals(NoHayGanador.class, condicion.chequear().getClass(),
                "Con 1 ciudadano y 2 mafiosos muertos deberia devolver un NoHayGanador");
    }
}
