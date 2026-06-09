package edu.fiuba.algo3.modelo;

import java.util.Collections;
import java.util.List;

public class MezcladorDeMazo {

    public List<Rol> mezclar(List<Rol> mazo){
        Collections.shuffle(mazo);
        return mazo;
    }

    
}
