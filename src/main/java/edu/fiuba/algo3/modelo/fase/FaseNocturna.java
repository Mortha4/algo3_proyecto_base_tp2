package edu.fiuba.algo3.modelo.fase;
import edu.fiuba.algo3.modelo.partida.Partida;
import edu.fiuba.algo3.modelo.acciones.Accion;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.fase.faseData.FaseNocturnaData;
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

    public void ejecutar(Accion comando) {
        comando.execute();
    }

    public void registrarVotoPrioritario(Jugador objetivo) {
        this.votacion.registrarVotoPrioritario(objetivo);
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
    protected void excepcionesDeSentencia(Candidato objetivo) {
        if (objetivo.equals(this.protegido)) {
            throw new ObjetivoProtegidoException();
        }
    }

    @Override
    public void registrarVoto(Jugador votante, Jugador objetivo) {
        this.votacion.registrarVoto(objetivo);
    }

    @Override
    public void cambiar(Partida partida) {
        partida.apilarData(exportarInfo());
        partida.hacerDeDia();
    }

    public FaseNocturnaData exportarInfo(){
        return new FaseNocturnaData(ultimoProtegido, ultimoInvestigado, votacion.obtenerMasVotado());
    }
}
