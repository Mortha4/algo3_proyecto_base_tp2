package edu.fiuba.algo3.modelo.fase;

public abstract class FaseData {
    protected final Candidato masVotado;

    public FaseData(Candidato masVotado) {
        this.masVotado = masVotado;
    }
}