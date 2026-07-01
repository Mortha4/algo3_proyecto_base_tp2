package edu.fiuba.algo3.modelo.fase;
import edu.fiuba.algo3.modelo.excepciones.JugadorNoNominadoException;
import edu.fiuba.algo3.modelo.excepciones.NoHuboDecisionException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import java.util.*;

public class Votacion {
    private Candidato prioritario;
    private final Set<Candidato> candidatos;

    public Votacion() {
        this.candidatos = new HashSet<>();
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
        this.prioritario = new Candidato(objetivo);
    }

    public Candidato obtenerMasVotado() {
        if(candidatos.isEmpty()) {
            return new CandidatoNulo();
        }

        Candidato masVotado = candidatos.iterator().next();
        List<Candidato> empatados = new ArrayList<>();

        for (Candidato candidato : candidatos) {
            if (candidato.empataCon(masVotado)) {
                empatados.add(candidato);
            } else if (candidato.esMasVotadoQue(masVotado)) {
                masVotado = candidato;
                empatados = new ArrayList<>(List.of(masVotado));
            }
        }
        if (empatados.size() > 1) {
            if (empatados.contains(prioritario)) {
                return prioritario;
            }
            throw new NoHuboDecisionException();
        }
        return masVotado;
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
