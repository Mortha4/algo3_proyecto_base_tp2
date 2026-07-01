package edu.fiuba.algo3.unitarios.partida;

import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.GanaLaMafia;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.Ganador;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.GananLosCiudadanos;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.ganadores.NoHayGanador;
import edu.fiuba.algo3.modelo.fase.faseData.FaseData;
import edu.fiuba.algo3.vistas.Notificable;

public class NotificableMock implements Notificable {
    private int vecesInvocadoData = 0;
    private int vecesInvocadoMafia = 0;
    private int vecesInvocadoCiudadanos = 0;
    private int vecesInvocadoNoHayGanador = 0;
    private int vecesInvocadoGanador = 0;

    @Override
    public void actualizar(FaseData data) {
        vecesInvocadoData++;
    }
    @Override
    public void actualizar(GanaLaMafia ganador) {
        vecesInvocadoMafia++;
        vecesInvocadoGanador++;
    }
    @Override
    public void actualizar(GananLosCiudadanos ganador) {
        vecesInvocadoCiudadanos++;
        vecesInvocadoGanador++;
    }
    @Override
    public void actualizar(NoHayGanador noHayGanador){
        vecesInvocadoNoHayGanador++;
        vecesInvocadoGanador++;
    }
    public int getVecesInvocadoData(){
        return vecesInvocadoData;
    }
    public int getVecesInvocadoCiudadanos(){
        return vecesInvocadoCiudadanos;
    }
    public int getVecesInvocadoNoHayGanador(){
        return vecesInvocadoNoHayGanador;
    }
    public int getVecesInvocadoMafia(){
        return vecesInvocadoMafia;
    }
    public int getVecesInvocadoGanador(){
        return vecesInvocadoGanador;
    }
}
