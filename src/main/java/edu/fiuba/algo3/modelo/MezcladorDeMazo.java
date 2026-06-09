package edu.fiuba.algo3.modelo;

import java.util.Collections;
import java.util.List;
import edu.fiuba.algo3.modelo.roles.*;

public class MezcladorDeMazo {

    public List<Rol> mezclar(List<Rol> mazo){
        Collections.shuffle(mazo);
        return mazo;
    }

    
}
