package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.comandos.Command;
import edu.fiuba.algo3.modelo.excepciones.NoHuboDecisionException;
import edu.fiuba.algo3.modelo.excepciones.ObjetivoProtegidoException;
import edu.fiuba.algo3.modelo.excepciones.SeleccionInvalidaException;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class FaseNocturna {
    private final Votacion votacionMafia;
    private Candidato protegido;

    public FaseNocturna() {
        this.votacionMafia = new Votacion();
    }

    public void ejecutar(Command comando) {
        comando.execute(this);
    }

    public void registrarVoto(Jugador objetivo) {
        this.votacionMafia.registrarVoto(objetivo);
    }

    public void registrarVotoPrioritario(Jugador objetivo) {
        this.votacionMafia.registrarVotoPrioritario(objetivo);
    }

    public void proteger(Jugador objetivo){
        this.protegido = new Candidato(objetivo);
    }

    public void finalizar() {
        Candidato objetivo = this.votacionMafia.obtenerMasVotado();

        if(objetivo == null){
            throw new NoHuboDecisionException();
        } else if (objetivo.equals(this.protegido)){
            throw new ObjetivoProtegidoException();
        } else if (!objetivo.estaVivo()) {
            throw new SeleccionInvalidaException();
        }

        objetivo.morir();
    }
}
