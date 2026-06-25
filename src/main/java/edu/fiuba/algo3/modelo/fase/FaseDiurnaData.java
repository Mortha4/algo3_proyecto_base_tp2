package edu.fiuba.algo3.modelo.fase;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class FaseDiurnaData extends FaseData{
    private final Jugador revelador;
    private final Jugador revelado;

    public FaseDiurnaData(Candidato masVotado, Jugador revelador, Jugador revelado) {
        super(masVotado);
        this.revelado = revelado;
        this.revelador = revelador;
    }

    public void darReveladoPara(FaseDiurna faseDiurna){
        faseDiurna.setRevelado(revelado);
    }
    public void darReveladorPara(FaseDiurna faseDiurna){
        faseDiurna.setSheriff(revelador);
    }
}
