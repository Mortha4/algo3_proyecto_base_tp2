package edu.fiuba.algo3.unitarios.partida;

import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.Ganador;
import edu.fiuba.algo3.modelo.fase.FaseData;
import edu.fiuba.algo3.vistas.Notificable;

public class NotificableMock implements Notificable {
    private int vecesInvocadoData = 0;
    private int vecesInvocadoGanador = 0;

    @Override
    public void actualizar(FaseData data) {
        vecesInvocadoData++;
    }

    @Override
    public void actualizar(Ganador ganador) {
        vecesInvocadoGanador++;
    }

    public int getVecesInvocadoData(){
        return vecesInvocadoData;
    }
    public int getVecesInvocadoGanador(){
        return vecesInvocadoGanador;
    }
}
