package edu.fiuba.algo3.modelo.fase;
import java.util.Set;

public interface CriterioDeDesempate {
    Candidato desempatar(Set<Candidato> empatados);
}
