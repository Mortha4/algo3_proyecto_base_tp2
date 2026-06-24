package edu.fiuba.algo3.modelo.fase;
import edu.fiuba.algo3.modelo.acciones.Accion;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.roles.Rol;

public class FaseNocturna extends Fase {

    private Jugador ultimoProtegido;
    private Candidato protegido;
    private Jugador ultimoInvestigado;

    public FaseNocturna() {
        super();
    }

    public FaseNocturna(FaseNocturnaData info) {
        super();
        info.darProtegidoPara(this);
        info.darInvestigadoPara(this);
    }

    public void setUltimoProtegido(Jugador ultimoProtegido){
        this.ultimoProtegido = ultimoProtegido;
    }

    public void setUltimoInvestigado(Jugador ultimoInvestigado){
        this.ultimoInvestigado = ultimoInvestigado;
    }

    public void ejecutarComando(Accion comando) {
        comando.execute();
    }

    public void registrarVotoPrioritario(Jugador votante, Jugador objetivo) {
        this.votacion.registrarVotoPrioritario(votante, objetivo);
    }

    public void proteger(Jugador objetivo) {
        if (objetivo.equals(ultimoProtegido)) {
            throw new NoSePuedeProtegerDosVecesSeguidasException();
        }
        this.protegido = new Candidato(objetivo);
        ultimoProtegido = objetivo;
    }

    public Rol investigar(Jugador base, Jugador objetivo) {
        if (objetivo.equals(ultimoInvestigado)) {
            throw new NoSePuedeInvestigarDosVecesSeguidasException();
        }
        ultimoInvestigado = objetivo;
        return base.verBando(objetivo);
    }

    @Override
    protected void otrasExcepciones(Candidato objetivo) {
        if (objetivo.equals(this.protegido)) {
            throw new ObjetivoProtegidoException();
        }
    }

    public FaseNocturnaData exportarInfo(){
        return new FaseNocturnaData(ultimoProtegido, ultimoInvestigado, votacion.obtenerMasVotado());
    }
}
