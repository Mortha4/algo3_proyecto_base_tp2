package edu.fiuba.algo3.modelo.fase;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class FaseNocturna extends Fase {

    private Jugador ultimoProtegido;
    private Candidato protegido;
    private Jugador ultimoInvestigado;

    public FaseNocturna() {
        super();
    }

    public FaseNocturna(Jugador ultimoInvestigado, Jugador ultimoProtegido) {
        super();
        this.ultimoProtegido = ultimoProtegido;
        this.ultimoInvestigado = ultimoInvestigado;
    }

    public void registrarVotoPrioritario(Jugador objetivo) {
        this.votacion.registrarVotoPrioritario(objetivo);
    }

    public void proteger(Jugador objetivo) {
        if (objetivo.equals(ultimoProtegido)) {
            throw new NoSePuedeProtegerDosVecesSeguidas();
        }
        this.protegido = new Candidato(objetivo);
        ultimoProtegido = objetivo;
    }

    public void investigar(Jugador base, Jugador objetivo) {
        if (objetivo.equals(ultimoInvestigado)) {
            throw new NoSePuedeInvestigarDosVecesSeguidas();
        }
        base.verBando(objetivo);
        ultimoInvestigado = objetivo;
    }

    @Override
    public void otrasExcepciones(Candidato objetivo) {
        if (objetivo.equals(this.protegido)) {
            throw new ObjetivoProtegidoException();
        }
    }
}
