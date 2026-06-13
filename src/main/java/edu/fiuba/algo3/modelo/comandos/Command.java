package edu.fiuba.algo3.modelo.comandos;

import edu.fiuba.algo3.modelo.FaseNocturna;

public interface Command {
    void execute(FaseNocturna faseNocturna);
}
