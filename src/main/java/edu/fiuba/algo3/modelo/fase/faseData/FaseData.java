package edu.fiuba.algo3.modelo.fase.faseData;
import edu.fiuba.algo3.modelo.fase.Candidato;

public abstract class FaseData {
    protected final Candidato masVotado;

    public FaseData(Candidato masVotado) {
        this.masVotado = masVotado;
    }
}