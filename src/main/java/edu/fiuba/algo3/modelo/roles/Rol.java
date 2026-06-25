package edu.fiuba.algo3.modelo.roles;
import edu.fiuba.algo3.modelo.acciones.AccionNocturna;
import edu.fiuba.algo3.modelo.acciones.Votar;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.acciones.AccionDiurna;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.visitors.Visitante;

public abstract class Rol {
    protected Visitante visitante;

    public Rol verBando(Rol visitable){
        return visitante.visitar(visitable);
    }
    public abstract Rol aceptar(Visitante visitante);
    public abstract AccionNocturna accionNocturna(FaseNocturna faseNocturna, Jugador base, Jugador objetivo);
    public abstract AccionDiurna accionDiurna(FaseDiurna fase, Jugador base, Jugador objetivo);

    public AccionDiurna votar(FaseDiurna fase, Jugador base, Jugador objetivo) {
        return new Votar(fase, base, objetivo);
    }

    @Override
    public boolean equals(Object o) {
        return o != null && this.getClass() == o.getClass();
    }
}
