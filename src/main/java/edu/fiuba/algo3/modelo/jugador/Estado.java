package edu.fiuba.algo3.modelo.jugador;
import edu.fiuba.algo3.modelo.fase.*;
import edu.fiuba.algo3.modelo.roles.Rol;

public interface Estado {
    boolean estaVivo();
    void accionNocturna(FaseNocturna faseNocturna, Jugador ejecutor, Jugador objetivo, Rol rol);
    void accionDiurna(FaseDiurna faseDiurna, Jugador ejecuror, Jugador objetivo, Rol rol);
}
