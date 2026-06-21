package edu.fiuba.algo3.modelo.fase;

import edu.fiuba.algo3.modelo.Partida;

public abstract class FaseData {
    protected final Candidato masVotado;

    public FaseData(Candidato masVotado) {
        this.masVotado = masVotado;
    }

    public void darMasVotadoPara(Partida partida){
        partida.recibirMasVotado(masVotado);
    }
}
