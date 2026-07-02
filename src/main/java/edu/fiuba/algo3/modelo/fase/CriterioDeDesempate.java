package edu.fiuba.algo3.modelo.fase;
import java.util.List;

public interface CriterioDeDesempate {
    Candidato desempatar(List<Candidato> empatados);
}
