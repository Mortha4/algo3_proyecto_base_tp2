package edu.fiuba.algo3.modelo.fase;
import java.util.Set;

public class SinMuerte implements CriterioDeDesempate {
    @Override
    public Candidato desempatar(Set<Candidato> empatados) {
        if(empatados.size() == 1){
            return empatados.iterator().next();
        }
        return new CandidatoNulo();
    }
}
