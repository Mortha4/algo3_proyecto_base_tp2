package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.excepciones.CantidadDeJugadoresException;
import edu.fiuba.algo3.modelo.mazo.Pequenia;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PequeniaTest {
    private Pequenia configuracionPequenia;

    @BeforeEach
    public void arrange() {
        configuracionPequenia = new Pequenia(5);
    }

    private int cantidadSegunRol(Rol rol) {
        int cantidad = 0;

        List<Rol> roles = configuracionPequenia.obtenerRoles();

        for (Rol r: roles){
            if(r.equals(rol)){
                cantidad++;
            }
        }

        return cantidad;
    }

    @Test
    public void test01SeCrearConfiguracionPequeniaCon5Roles(){
        // Arrange
        int cantidadDeRoles = 5;

        // Act
        Pequenia configuracionPequenia = new Pequenia(cantidadDeRoles);

        // Assert
        assertEquals(cantidadDeRoles, configuracionPequenia.obtenerRoles().size(),
                "Se debería poder crear configuración grande con " + cantidadDeRoles + " roles");
    }

    @Test
    public void test02SeCrearConfiguracionPequeniaCon6Roles(){
        // Arrange
        int cantidadDeRoles = 6;

        // Act
        Pequenia configuracionPequenia = new Pequenia(cantidadDeRoles);

        // Assert
        assertEquals(cantidadDeRoles, configuracionPequenia.obtenerRoles().size(),
                "Se debería poder crear configuración grande con " + cantidadDeRoles + " roles");
    }

    @Test
    public void test03NoSeCrearConfiguracionPequeniaCon4Roles(){
        // Arrange
        int cantidadDeRoles = 4;

        // Act y Assert
        assertThrows(CantidadDeJugadoresException.class, () -> new Pequenia(cantidadDeRoles),
                "No se debería poder crear configuración grande con " + cantidadDeRoles + " roles");
    }

    @Test
    public void test04NoSeCrearConfiguracionPequeniaCon7Roles(){
        // Arrange
        int cantidadDeRoles = 7;

        // Act y Assert
        assertThrows(CantidadDeJugadoresException.class, () -> new Pequenia(cantidadDeRoles),
                "No se debería poder crear configuración grande con " + cantidadDeRoles + " roles");
    }

    @Test
    public void test05SeCreaConfiguracionPequeniaSinSheriff(){
        // Arrange
        int cantidadDeSheriffs = 0;

        // Act
        int result = cantidadSegunRol(new Sheriff());

        // Assert
        assertEquals(cantidadDeSheriffs, result,
                "No deberían crearse sheriff");
    }

    @Test
    public void test06SeCreaConfiguracionPequeniaCon0o1Detective(){
        // Act
        int cantidadDeDetectives = cantidadSegunRol(new Detective());

        // Assert
        assertTrue((cantidadDeDetectives == 0 || cantidadDeDetectives == 1),
                "Deberían crearse 0 o 1 detectives");
    }

    @Test
    public void test07SeCreaConfiguracionPequeniaSinPadrino(){
        // Arrange
        int cantidadDePadrinos = 0;

        // Act
        int result = cantidadSegunRol(new Padrino());

        // Assert
        assertEquals(cantidadDePadrinos, result,
                "No debería crearse padrino");
    }

    @Test
    public void test08SeCreaConfiguracionPequeniaCon0o1Medico(){
        // Act
        int cantidadDeMedicos = cantidadSegunRol(new Medico());

        // Assert
        assertTrue((cantidadDeMedicos == 0 || cantidadDeMedicos == 1),
                "Deberían crearse 0 o 1 medicos");
    }

    @Test
    public void test09SeCreaConfiguracionPequeniaCon1o2Mafiosos(){
        // Act
        int cantidadDeMafiosos = cantidadSegunRol(new Mafioso());

        // Assert
        assertTrue((cantidadDeMafiosos == 1 || cantidadDeMafiosos == 2),
                "Deberían crearse 1 o 2 mafiosos");
    }

    @Test
    public void test10SeCreaConfiguracionPequeniaConCon2o3CiudadanosPara5Roles(){
        // Act
        int cantidadDeCiudadanos = cantidadSegunRol(new Ciudadano());

        // Assert
        assertTrue((cantidadDeCiudadanos == 2 || cantidadDeCiudadanos == 3),
                "Deberían crearse 2 o 3 ciudadanos para 5 roles");
    }
}
