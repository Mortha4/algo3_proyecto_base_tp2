package edu.fiuba.algo3.vistas;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.GanaLaMafia;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.GananLosCiudadanos;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.NoHayGanador;
import edu.fiuba.algo3.modelo.fase.faseData.FaseData;

public interface Notificable {
    void actualizar(FaseData data);
    void actualizar(GanaLaMafia ganador);
    void actualizar(GananLosCiudadanos ganador);
    void actualizar(NoHayGanador noHayGanador);
}
