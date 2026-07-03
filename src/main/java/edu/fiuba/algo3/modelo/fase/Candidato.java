package edu.fiuba.algo3.modelo.fase;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Candidato {
    private final Jugador jugador;
    private int votos = 0;

    public Candidato(Jugador jugador){
        this.jugador = jugador;
    }

    public boolean esMasVotadoQue(Candidato otroCandidato){
        return !otroCandidato.esMasVotadoQue(this.votos);
    }

    public boolean esMasVotadoQue(int votosDeOtro){
        return this.votos > votosDeOtro;
    }

    public boolean empataCon(Candidato otroCandidato){
        return otroCandidato.empataCon(this.votos);
    }

    public boolean empataCon(int otrosVotos){
        return this.votos == otrosVotos;
    }

    public void sumarVoto(){
        votos++;
    }

    public void morir(){
        jugador.morir();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Candidato candidato = (Candidato) o;
        return jugador.equals(candidato.jugador);
    }

    @Override
    public int hashCode() {
        return jugador.hashCode();
    }

    public boolean esIgualQue(Jugador objetivo) {
        return this.jugador.equals(objetivo);
    }
}
