package edu.fiuba.algo3.modelo.comandos;

import edu.fiuba.algo3.modelo.fase.FaseNocturna;

public interface Command {
    void execute(FaseNocturna faseNocturna);
}
