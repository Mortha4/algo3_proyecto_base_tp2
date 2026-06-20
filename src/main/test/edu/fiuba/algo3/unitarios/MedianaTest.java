package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.excepciones.CantidadDeJugadoresException;
import edu.fiuba.algo3.modelo.mazo.Mediana;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MedianaTest {
    private Mediana configuracionMediana;

    @BeforeEach
    public void arrange() {
        configuracionMediana = new Mediana(7);
    }

    private int cantidadSegunRol(Rol rol) {
        int cantidad = 0;

        List<Rol> roles = configuracionMediana.obtenerRoles();

        for (Rol r: roles){
            if(r.equals(rol)){
                cantidad++;
            }
        }

        return cantidad;
    }

    @Test
    public void test01SeCrearConfiguracionMedianaCon7Roles(){
        // Arrange
        int cantidadDeRoles = 7;

        // Act
        Mediana configuracionMediana = new Mediana(cantidadDeRoles);

        // Assert
        assertEquals(cantidadDeRoles, configuracionMediana.obtenerRoles().size(),
                "Se debería poder crear configuración grande con " + cantidadDeRoles + " roles");
    }

    @Test
    public void test02SeCrearConfiguracionMedianaCon9Roles(){
        // Arrange
        int cantidadDeRoles = 9;

        // Act
        Mediana configuracionMediana = new Mediana(cantidadDeRoles);

        // Assert
        assertEquals(cantidadDeRoles, configuracionMediana.obtenerRoles().size(),
                "Se debería poder crear configuración grande con " + cantidadDeRoles + " roles");
    }

    @Test
    public void test03NoSeCrearConfiguracionMedianaCon6Roles(){
        // Arrange
        int cantidadDeRoles = 6;

        // Act y Assert
        assertThrows(CantidadDeJugadoresException.class, () -> new Mediana(cantidadDeRoles),
                "No se debería poder crear configuración grande con " + cantidadDeRoles + " roles");
    }

    @Test
    public void test04NoSeCrearConfiguracionMedianaCon10Roles(){
        // Arrange
        int cantidadDeRoles = 10;

        // Act y Assert
        assertThrows(CantidadDeJugadoresException.class, () -> new Mediana(cantidadDeRoles),
                "No se debería poder crear configuración grande con " + cantidadDeRoles + " roles");
    }

    @Test
    public void test05SeCreaConfiguracionMedianaSinSheriff(){
        // Arrange
        int cantidadDeSheriffs = 0;

        // Act
        int result = cantidadSegunRol(new Sheriff());

        // Assert
        assertEquals(cantidadDeSheriffs, result,
                "No deberían crearse sheriff");
    }

    @Test
    public void test06SeCreaConfiguracionMedianaCon1Detective(){
        // Arrange
        int cantidadDeDetectives = 1;

        // Act
        int result = cantidadSegunRol(new Detective());

        // Assert
        assertEquals(cantidadDeDetectives, result,
                "Debería crearse " + cantidadDeDetectives + " detective");
    }

    @Test
    public void test07SeCreaConfiguracionMedianaSinPadrino(){
        // Arrange
        int cantidadDePadrinos = 0;

        // Act
        int result = cantidadSegunRol(new Padrino());

        // Assert
        assertEquals(cantidadDePadrinos, result,
                "No debería crearse padrino");
    }

    @Test
    public void test08SeCreaConfiguracionMedianaCon1Medico(){
        // Arrange
        int cantidadDeMedicos = 1;

        // Act
        int result = cantidadSegunRol(new Medico());

        // Assert
        assertEquals(cantidadDeMedicos, result,
                "Debería crearse " + cantidadDeMedicos + " médico");
    }

    @Test
    public void test09SeCreaConfiguracionMedianaCon2o3Mafiosos(){
        // Act
        int cantidadDeMafiosos = cantidadSegunRol(new Mafioso());

        // Assert
        assertTrue((cantidadDeMafiosos == 2 || cantidadDeMafiosos == 3),
                "Deberían crearse 2 o 3 mafiosos");
    }

    @Test
    public void test10SeCreaConfiguracionMedianaConCon2o3CiudadanosPara7Roles(){
        // Act
        int cantidadDeCiudadanos = cantidadSegunRol(new Ciudadano());

        // Assert
        assertTrue((cantidadDeCiudadanos == 2 || cantidadDeCiudadanos == 3),
                "Deberían crearse 2 o 3 ciudadanos para 7 roles");
    }
}