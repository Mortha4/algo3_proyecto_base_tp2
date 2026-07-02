package edu.fiuba.algo3.modelo.fase;

import java.util.List;

public class SinMuerte implements CriterioDeDesempate {
    @Override
    public Candidato desempatar(List<Candidato> empatados) {
        return new CandidatoNulo();
    }
}
