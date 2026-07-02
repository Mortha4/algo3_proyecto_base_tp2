package edu.fiuba.algo3.modelo.fase.faseData;
import edu.fiuba.algo3.modelo.fase.Candidato;
import edu.fiuba.algo3.modelo.fase.CriterioDeDesempate;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class FaseDiurnaData extends FaseData {
    private final Jugador revelador;
    private final Jugador revelado;
    private final CriterioDeDesempate criterioDeDesempate;

    public FaseDiurnaData(Candidato masVotado, Jugador revelador, Jugador revelado, CriterioDeDesempate criterioDeDesempate) {
        super(masVotado);
        this.revelado = revelado;
        this.revelador = revelador;
        this.criterioDeDesempate = criterioDeDesempate;
    }

    public void darReveladoPara(FaseDiurna faseDiurna){
        faseDiurna.setRevelado(revelado);
    }
    public void darReveladorPara(FaseDiurna faseDiurna){
        faseDiurna.setSheriff(revelador);
    }
    public void darCriterioPara(FaseDiurna fase){
        fase.setVotacion(criterioDeDesempate);
    }
}
