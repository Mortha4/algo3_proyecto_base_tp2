package edu.fiuba.algo3.unitarios.fase;

import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.fase.SinMuerte;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Detective;
import edu.fiuba.algo3.modelo.roles.Medico;
import org.junit.jupiter.api.BeforeEach;

public class FaseDiurnaDataTest {
    Jugador medico;
    Jugador detective;
    Jugador ciudadano1;
    Jugador ciudadano2;
    FaseDiurna fase;
    @BeforeEach
    public void arrange(){
        medico = new Jugador(new Medico(), "medico");
        detective = new Jugador(new Detective(), "detective");
        ciudadano1 = new Jugador(new Ciudadano(), "protegido");
        ciudadano2 = new Jugador(new Ciudadano(), "investigado");
        fase = new FaseDiurna(new SinMuerte());
    }
}
