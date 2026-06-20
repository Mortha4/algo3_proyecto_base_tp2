package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.excepciones.CantidadDeJugadoresException;
import edu.fiuba.algo3.modelo.mazo.Grande;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GrandeTest {
    private Grande configuracionGrande;

    @BeforeEach
    public void arrange() {
        configuracionGrande = new Grande(10);
    }

    private int cantidadSegunRol(Rol rol) {
        int cantidad = 0;

        List<Rol> roles = configuracionGrande.obtenerRoles();

        for (Rol r: roles){
            if(r.equals(rol)){
                cantidad++;
            }
        }

        return cantidad;
    }

    @Test
    public void test01SeCrearConfiguracionGrandeCon10Roles(){
        // Arrange
        int cantidadDeRoles = 10;

        // Act
        Grande configuracionGrande = new Grande(cantidadDeRoles);

        // Assert
        assertEquals(cantidadDeRoles, configuracionGrande.obtenerRoles().size(),
                "Se debería poder crear configuración grande con " + cantidadDeRoles + " roles");
    }

    @Test
    public void test02SeCrearConfiguracionGrandeCon12Roles(){
        // Arrange
        int cantidadDeRoles = 12;

        // Act
        Grande configuracionGrande = new Grande(cantidadDeRoles);

        // Assert
        assertEquals(cantidadDeRoles, configuracionGrande.obtenerRoles().size(),
                "Se debería poder crear configuración grande con " + cantidadDeRoles + " roles");
    }

    @Test
    public void test03NoSeCrearConfiguracionGrandeCon9Roles(){
        // Arrange
        int cantidadDeRoles = 9;

        // Act y Assert
        assertThrows(CantidadDeJugadoresException.class, () -> new Grande(cantidadDeRoles),
                "No se debería poder crear configuración grande con " + cantidadDeRoles + " roles");
    }

    @Test
    public void test04NoSeCrearConfiguracionGrandeCon13Roles(){
        // Arrange
        int cantidadDeRoles = 13;

        // Act y Assert
        assertThrows(CantidadDeJugadoresException.class, () -> new Grande(cantidadDeRoles),
                "No se debería poder crear configuración grande con " + cantidadDeRoles + " roles");
    }

    @Test
    public void test05SeCreaConfiguracionGrandeCon1Sheriff(){
        // Arrange
        int cantidadDeSheriffs = 1;

        // Act
        int result = cantidadSegunRol(new Sheriff());

        // Assert
        assertEquals(cantidadDeSheriffs, result,
                "Debería crearse " + cantidadDeSheriffs + " sheriff");
    }

    @Test
    public void test06SeCreaConfiguracionGrandeCon1Detective(){
        // Arrange
        int cantidadDeDetectives = 1;

        // Act
        int result = cantidadSegunRol(new Detective());

        // Assert
        assertEquals(cantidadDeDetectives, result,
                "Debería crearse " + cantidadDeDetectives + " detective");
    }

    @Test
    public void test07SeCreaConfiguracionGrandeCon1Padrino(){
        // Arrange
        int cantidadDePadrinos = 1;

        // Act
        int result = cantidadSegunRol(new Padrino());

        // Assert
        assertEquals(cantidadDePadrinos, result,
                "Debería crearse " + cantidadDePadrinos + " padrino");
    }

    @Test
    public void test08SeCreaConfiguracionGrandeCon1Medico(){
        // Arrange
        int cantidadDeMedicos = 1;

        // Act
        int result = cantidadSegunRol(new Medico());

        // Assert
        assertEquals(cantidadDeMedicos, result,
                "Debería crearse " + cantidadDeMedicos + " médico");
    }

    @Test
    public void test09SeCreaConfiguracionGrandeCon3Mafiosos(){
        // Arrange
        int cantidadDeMafiosos = 3;

        // Act
        int result = cantidadSegunRol(new Mafioso());

        // Assert
        assertEquals(cantidadDeMafiosos, result,
                "Deberían crearse " + cantidadDeMafiosos + " mafiosos");
    }

    @Test
    public void test10SeCreaConfiguracionGrandeConCon3CiudadanosPara10Roles(){
        // Arrange
        int cantidadDeCiudadanos = 3;

        // Act
        int result = cantidadSegunRol(new Ciudadano());

        // Assert
        assertEquals(cantidadDeCiudadanos, result,
                "Deberían crearse " + cantidadDeCiudadanos + " ciudadanos para 10 roles");
    }
}
