package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.fase.faseData.FaseData;
import edu.fiuba.algo3.vistas.Notificable;

public interface Observable {
    void agregarNotificable(Notificable notificable);
    void notificar(FaseData data);
}
