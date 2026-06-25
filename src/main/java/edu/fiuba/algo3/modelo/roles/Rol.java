package edu.fiuba.algo3.modelo.roles;
import edu.fiuba.algo3.modelo.acciones.Accion;
import edu.fiuba.algo3.modelo.acciones.Nada;
import edu.fiuba.algo3.modelo.acciones.Votar;
import edu.fiuba.algo3.modelo.condicionesDeVictoria.condiciones.CondicionDeVictoria;
import edu.fiuba.algo3.modelo.fase.Fase;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.visitors.Visitante;

public abstract class Rol {
    protected Visitante visitante;

    public Rol verBando(Rol visitable){
        return visitante.visitar(visitable);
    }
    public abstract Rol aceptar(Visitante visitante);
    public abstract void contarRol(CondicionDeVictoria condicion);
    public abstract Accion accion(FaseNocturna faseNocturna, Jugador base, Jugador objetivo);
    public abstract Accion accion(FaseDiurna fase, Jugador base, Jugador objetivo);
    public Accion noActuar(){
        return new Nada();
    }
    public Accion votar(Fase fase, Jugador base, Jugador objetivo) {
        return new Votar(fase, base, objetivo);
    }

    @Override
    public boolean equals(Object o) {
        return o != null && this.getClass() == o.getClass();
    }
}
