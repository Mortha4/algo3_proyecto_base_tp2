package edu.fiuba.algo3.modelo.fase;
import edu.fiuba.algo3.modelo.acciones.AccionDiurna;

public class FaseDiurna extends Fase{

    public FaseDiurna(){
        super();
    }

    public void ejecutar(AccionDiurna comando) {
        comando.execute();
    }
}
