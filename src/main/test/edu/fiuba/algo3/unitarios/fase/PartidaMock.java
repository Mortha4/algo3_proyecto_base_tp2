package edu.fiuba.algo3.unitarios.fase;
import edu.fiuba.algo3.modelo.fase.*;
import edu.fiuba.algo3.modelo.fase.faseData.FaseDiurnaData;
import edu.fiuba.algo3.modelo.fase.faseData.FaseNocturnaData;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.JugadorNulo;
import edu.fiuba.algo3.modelo.partida.Partida;
import edu.fiuba.algo3.vistas.Notificable;
import java.util.List;
import java.util.Set;

public class PartidaMock extends Partida {

    public PartidaMock(List<String> nombres) {
        super(nombres);}
    public void iniciar(){}
    public void cambiarFase() {}
    public void hacerDeNoche(){}
    public void hacerDeDia(){}
    public void hacerBallotage(Set<Candidato> empatados, CriterioDeDesempate criterio, Jugador sheriff, Jugador revelado) {}
    public void apilarData(FaseDiurnaData data){}
    public void apilarData(FaseNocturnaData data){}
    public List<Jugador> getJugadores(){
        return List.of(new JugadorNulo());
    }
    public Fase getFaseActual(){
        return new FaseDiurna(new SinMuerte());
    }
    @Override
    public void agregarNotificable(Notificable notificable) {}
}
