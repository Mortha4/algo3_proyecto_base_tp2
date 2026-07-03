package edu.fiuba.algo3.modelo.fase;

import edu.fiuba.algo3.modelo.excepciones.NoHuboDecisionException;

public class SinMuerte implements CriterioDeDesempate {
    @Override
    public void desempatar() {
        throw new NoHuboDecisionException();
    }
}
