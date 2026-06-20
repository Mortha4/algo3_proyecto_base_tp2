package edu.fiuba.algo3.modelo.fase;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class FaseNocturnaData {
    private final Jugador protegido;
    private final Jugador investigado;
    private final Candidato masVotado;

    public FaseNocturnaData(Jugador protegido, Jugador investigado, Candidato masVotado) {
        this.protegido = protegido;
        this.investigado = investigado;
        this.masVotado = masVotado;
    }

    public Jugador getProtegido() {
        return protegido;
    }

    public Jugador getInvestigado() {
        return investigado;
    }

    public Candidato getMasVotado() {
        return masVotado;
    }
}
