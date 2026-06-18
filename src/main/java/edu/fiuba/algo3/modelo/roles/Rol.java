package edu.fiuba.algo3.modelo.roles;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.comandos.Command;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.visitors.Visitante;

import java.util.Objects;

public abstract class Rol {
    protected Visitante visitante;

    public Rol verBando(Rol visitable){
        return visitante.visitar(visitable);
    }

    public abstract Rol aceptar(Visitante visitante);

    public abstract Command accionNocturna(FaseNocturna faseNocturna, Jugador base, Jugador objetivo);

    @Override
    public boolean equals(Object o) {
        return o != null && getClass() == o.getClass();
    }
}
