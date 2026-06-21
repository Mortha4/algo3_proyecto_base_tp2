package edu.fiuba.algo3.modelo.fase;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class FaseNocturnaData extends FaseData{
    private final Jugador protegido;
    private final Jugador investigado;

    public FaseNocturnaData(Jugador protegido, Jugador investigado, Candidato masVotado) {
        super(masVotado);
        this.protegido = protegido;
        this.investigado = investigado;
    }

    public void darProtegidoPara(FaseNocturna fase) {
        fase.setUltimoProtegido(protegido);
    }

    public void darInvestigadoPara(FaseNocturna fase){
        fase.setUltimoInvestigado(investigado);
    }
}
