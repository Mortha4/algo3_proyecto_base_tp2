package edu.fiuba.algo3.modelo.fase;
import edu.fiuba.algo3.modelo.excepciones.JugadorNoNominadoException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import java.util.*;

public class Votacion {
    private Candidato prioritario;
    private final Set<Candidato> candidatos;

    public Votacion() {
        this.candidatos = new HashSet<>();
    }

    public Votacion(Set<Candidato> empatados) {
        this.candidatos = empatados;
    }

    public void registrarVoto(Jugador objetivo) {
        Candidato candidato = buscarCandidato(objetivo);
        candidato.sumarVoto();
    }

    public void agregarCandidato(Jugador nominador, Jugador nominado){
        Candidato candidato = nominador.crearCandidato(nominado);
        candidatos.add(candidato);
    }

    public void registrarVotoPrioritario(Jugador objetivo) {
        registrarVoto(objetivo);
        this.prioritario = buscarCandidato(objetivo);
    }

    public Set<Candidato> obtenerMasVotado() {
        Set<Candidato> masVotados = new HashSet<>();
        if(candidatos.isEmpty()) {
            return masVotados;
        }

        Candidato masVotado = candidatos.iterator().next();
        masVotados.add(masVotado);

        for (Candidato candidato : candidatos) {
            if (candidato.empataCon(masVotado)) {
                masVotados.add(candidato);
            } else if (candidato.esMasVotadoQue(masVotado)) {
                masVotado = candidato;
                masVotados.clear();
                masVotados.add(masVotado);
            }
        }
        if (masVotados.size() > 1) {
            if (masVotados.contains(prioritario)) {
                return Set.of(prioritario);
            }
        }
        return masVotados;
    }

    public Candidato buscarCandidato(Jugador objetivo){
        for(Candidato candidato: candidatos){
            if(candidato.esIgualQue(objetivo)){
                return candidato;
            }
        }
        throw new JugadorNoNominadoException();
    }
}
