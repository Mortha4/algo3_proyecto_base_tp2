package edu.fiuba.algo3.modelo.fase;
import edu.fiuba.algo3.modelo.excepciones.JugadorNoNominadoException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import java.util.*;

public class Votacion {
    private Candidato prioritario;
    private final Set<Candidato> candidatos;
    private final CriterioDeDesempate criterioDeDesempate;

    public Votacion(CriterioDeDesempate criterioDeDesempate) {
        this.candidatos = new HashSet<>();
        this.criterioDeDesempate = criterioDeDesempate;
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

    public List<Candidato> obtenerMasVotado() {
        List<Candidato> masVotados = new ArrayList<>();
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
                return List.of(prioritario);
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
