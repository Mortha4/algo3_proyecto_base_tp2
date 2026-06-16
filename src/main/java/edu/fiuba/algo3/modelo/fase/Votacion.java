package edu.fiuba.algo3.modelo.fase;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import java.util.*;

public class Votacion {
    private Candidato prioritario = null;
    private Set<Candidato> candidatos;

    public Votacion() {
        this.candidatos = new HashSet<>();
    }

    public void registrarVoto(Jugador objetivo) {
        Candidato candidato = new Candidato(objetivo);
        candidatos.add(candidato);
        candidato.sumarVoto();
    }

    public void registrarVotoPrioritario(Jugador objetivo) {
        registrarVoto(objetivo);
        this.prioritario = new Candidato(objetivo);
    }

    public Candidato obtenerMasVotado() {
        Candidato masVotado = candidatos.iterator().next();
        List<Candidato> empatados = new ArrayList<>();
        empatados.add(masVotado);

        for (Candidato candidato : candidatos) {
            if(candidato.esMasVotadoQue(masVotado)) {
                masVotado = candidato;
                empatados = new ArrayList<>(List.of(masVotado));
            } else if (candidato.empataCon(masVotado)) {
                empatados.add(candidato);
            }
        }

        if (empatados.size() > 1) {
            if(empatados.contains(prioritario)) {
                return prioritario;
            }
            return null;
        }
        return masVotado;
    }
}
