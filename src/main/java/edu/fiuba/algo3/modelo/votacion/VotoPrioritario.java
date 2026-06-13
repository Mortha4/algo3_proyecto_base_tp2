package edu.fiuba.algo3.modelo.votacion;
import edu.fiuba.algo3.modelo.AccionNocturnaCommand;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class VotoPrioritario implements AccionNocturnaCommand {
    private Votacion receptor;
    private Jugador objetivo;

    public VotoPrioritario(Votacion receptor, Jugador objetivo){
        this.receptor = receptor;
        this.objetivo = objetivo;
    }

    @Override
    public void ejecutar() {
        receptor.votarPrioritario(objetivo);
    }
}
