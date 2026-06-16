package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.comandos.Votar;
import edu.fiuba.algo3.modelo.fase.FaseDiurna;
import edu.fiuba.algo3.modelo.fase.FaseNocturna;
import edu.fiuba.algo3.modelo.roles.Rol;

public class Vivo implements Estado {
    @Override
    public boolean estaVivo() {
        return true;
    }

    public void accionNocturna(FaseNocturna faseNocturna, Jugador ejecutor, Jugador objetivo, Rol rol){
        faseNocturna.ejecutar(rol.accionNocturna(faseNocturna, ejecutor, objetivo));
    }

    public void accionDiurna(FaseDiurna faseDiurna, Jugador ejecutor, Jugador objetivo){
        faseDiurna.ejecutar(new Votar(faseDiurna, ejecutor, objetivo));
    }
}
