package edu.fiuba.algo3.unitarios.fase;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.fase.FaseNocturnaData;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Detective;
import edu.fiuba.algo3.modelo.roles.Mafioso;
import edu.fiuba.algo3.modelo.roles.Medico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FaseNocturnaDataTest {
    Jugador medico;
    Jugador detective;
    Jugador ciudadano1;
    Jugador ciudadano2;
    Jugador mafioso;
    FaseNocturna fase;

    @BeforeEach
    public void setUp(){
        medico = new Jugador(new Medico(), "medico");
        detective = new Jugador(new Detective(), "detective");
        ciudadano1 = new Jugador(new Ciudadano(), "protegido");
        ciudadano2 = new Jugador(new Ciudadano(), "investigado");
        mafioso = new Jugador(new Mafioso(), "mafioso");
        fase = new FaseNocturna();
    }

    @Test
    public void test01guardaCorrectamenteElProtegido(){
        medico.accionNocturna(fase, ciudadano1);
        mafioso.accionNocturna(fase, ciudadano2);

        FaseNocturnaData data = fase.exportarInfo();
        assertEquals(data.getProtegido(), ciudadano1,
                "Se deberia guardar correctamente el protegido");
    }

    @Test
    public void test02guardaCorrectamenteElInvestigado(){
        detective.accionNocturna(fase, ciudadano2);
        mafioso.accionNocturna(fase, ciudadano2);
        FaseNocturnaData data = fase.exportarInfo();

        assertEquals(ciudadano2, data.getInvestigado(),
                "Se deberia guardar correctamente el investigado");
    }

    @Test
    public void test03guardaCorrectamenteElMasVotado(){
        mafioso.accionNocturna(fase, ciudadano1);
        FaseNocturnaData data = fase.exportarInfo();

        assertTrue(data.getMasVotado().esIgualQue(ciudadano1),
                "Se deberia guardar correctamente el mas votado");
    }
}
