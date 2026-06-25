package edu.fiuba.algo3.vistas;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.Ganador;
import edu.fiuba.algo3.modelo.fase.faseData.FaseData;

public interface Notificable {
    void actualizar(FaseData data);
    void actualizar(Ganador ganador);
}
