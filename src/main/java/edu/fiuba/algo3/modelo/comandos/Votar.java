package edu.fiuba.algo3.modelo.comandos;

import edu.fiuba.algo3.modelo.excepciones.NoVisibleException;
import edu.fiuba.algo3.modelo.excepciones.NoVotableException;
import edu.fiuba.algo3.modelo.fase.Fase;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.excepciones.SeleccionInvalidaException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.Mafioso;

public class Votar implements Command {
    private Jugador objetivo;
    private Fase fase;

    public Votar(FaseDiurna fase, Jugador votante, Jugador objetivo) {
        setFase(fase);
        setObjetivo(votante, objetivo);
    }

    public Votar(FaseNocturna fase, Jugador votante, Jugador objetivo) {
        setFase(fase);
        setObjetivo(votante, objetivo);

        try{
            votante.verBando(objetivo);
            throw new NoVotableException();
        }catch (NoVisibleException ignored){}
    }

    private void setFase(Fase fase) {
        this.fase = fase;
    }

    private void setObjetivo(Jugador votante, Jugador objetivo) {
        if((!objetivo.estaVivo()) || votante.equals(objetivo)) {
            throw new SeleccionInvalidaException();
        }
        this.objetivo = objetivo;
    }


    @Override
    public void execute() {
        fase.registrarVoto(objetivo);
    }
}
