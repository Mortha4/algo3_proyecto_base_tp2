package edu.fiuba.algo3.unitarios.fase;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeInvestigarDosVecesSeguidasException;
import edu.fiuba.algo3.modelo.excepciones.NoSePuedeProtegerDosVecesSeguidasException;
import edu.fiuba.algo3.modelo.fase.CandidatoNulo;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.fase.faseData.FaseNocturnaData;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.Ciudadano;
import edu.fiuba.algo3.modelo.roles.Detective;
import edu.fiuba.algo3.modelo.roles.Medico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FaseNocturnaDataTest {
    Jugador medico;
    Jugador detective;
    Jugador ciudadano1;
    Jugador ciudadano2;
    FaseNocturna fase;
    FaseNocturna fase2;

    @BeforeEach
    public void setUp(){
        medico = new Jugador(new Medico(), "medico");
        detective = new Jugador(new Detective(), "detective");
        ciudadano1 = new Jugador(new Ciudadano(), "protegido");
        ciudadano2 = new Jugador(new Ciudadano(), "investigado");
        fase = new FaseNocturna();
    }

    @Test
    public void test01guardaCorrectamenteElProtegido(){
        medico.accion(fase, ciudadano1);
        FaseNocturnaData data = fase.exportarInfo(new CandidatoNulo());
        fase2 = new FaseNocturna(data);

        assertThrows(NoSePuedeProtegerDosVecesSeguidasException.class,
                () -> medico.accion(fase2, ciudadano1),
                "Se deberia guardar correctamente el protegido");
    }

    @Test
    public void test02guardaCorrectamenteElInvestigado(){
        detective.accion(fase, ciudadano2);
        FaseNocturnaData data = fase.exportarInfo(new CandidatoNulo());
        fase2 = new FaseNocturna(data);


        assertThrows(NoSePuedeInvestigarDosVecesSeguidasException.class,
                () -> detective.accion(fase2, ciudadano2) ,
                "Se deberia guardar correctamente el investigado");
    }
}
