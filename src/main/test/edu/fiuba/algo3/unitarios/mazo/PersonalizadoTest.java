package edu.fiuba.algo3.unitarios.mazo;

import edu.fiuba.algo3.modelo.excepciones.CantidadDeJugadoresException;
import edu.fiuba.algo3.modelo.mazo.Personalizado;
import edu.fiuba.algo3.modelo.roles.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

public class PersonalizadoTest {
    private Set<Supplier<Rol>> constructores;
    private Boolean hayMedicos;
    private Boolean haySheriff;
    private Boolean hayPadrinos;
    private Boolean hayDetectives;

    @BeforeEach
    public void inicializarSet(){
        constructores = new HashSet<>();
    }

    public void hayRoles(List<Rol> roles){
        hayDetectives = false;
        hayMedicos = false;
        hayPadrinos = false;
        haySheriff = false;
        for(Rol rol: roles){
            if(rol.getClass() == Medico.class){
                hayMedicos = true;
            }
            if(rol.getClass() == Sheriff.class){
                haySheriff = true;
            }
            if(rol.getClass() == Padrino.class){
                hayPadrinos = true;
            }
            if(rol.getClass() == Detective.class){
                hayDetectives = true;
            }
        }
    }
    

    @Test
    public void test01CreaUnMedicoCorrectamente(){
        // Arrange
        constructores.add(Medico::new);

        // Act
        Personalizado personalizado = new Personalizado(constructores, 10);
        List<Rol> cartas = personalizado.obtenerRoles();

        // Assert
        assertEquals(Medico.class, cartas.get(0).getClass(),
                "Crear un mazo personalizado con un médico debería crear un medico");
    }

    @Test
    public void test02CreaUnSheriffCorrectamente(){
        // Arrange
        constructores.add(Sheriff::new);

        // Act
        Personalizado personalizado = new Personalizado(constructores, 10);
        List<Rol> cartas = personalizado.obtenerRoles();

        // Assert
        assertEquals(Sheriff.class, cartas.get(0).getClass(),
                "Crear un mazo personalizado con un Sheriff debería crear un medico");
    }

    @Test
    public void test03CreaUnDetectiveCorrectamente(){
        // Arrange
        constructores.add(Detective::new);

        // Act
        Personalizado personalizado = new Personalizado(constructores, 10);
        List<Rol> cartas = personalizado.obtenerRoles();

        // Assert
        assertEquals(Detective.class, cartas.get(0).getClass(),
                "Crear un mazo personalizado con un Detective debería crear un medico");
    }

    @Test
    public void test04CreaUnPadrinoCorrectamente(){
        // Arrange
        constructores.add(Padrino::new);

        // Act
        Personalizado personalizado = new Personalizado(constructores, 10);
        List<Rol> cartas = personalizado.obtenerRoles();

        // Assert
        assertEquals(Padrino.class, cartas.get(0).getClass(),
                "Crear un mazo personalizado con un Padrino debería crear un medico");
    }

    @Test
    public void test05ConAlgunosRolesSeCreaCorrectamente(){
        // Arrange
        constructores.add(Sheriff::new);
        constructores.add(Medico::new);

        // Act
        Personalizado personalizado = new Personalizado(constructores, 10);
        List<Rol> cartas = personalizado.obtenerRoles();
        hayRoles(cartas);

        // Assert
        assertTrue(hayMedicos && haySheriff,
                "Creando un mazo con un medico y un sheriff, deberian estar ambos.");
    }

    @Test
    public void test06ConAlgunosRolesNoHayRolesQueNoSeAgregaron(){
        // Arrange
        constructores.add(Sheriff::new);
        constructores.add(Medico::new);

        // Act
        Personalizado personalizado = new Personalizado(constructores, 10);
        List<Rol> cartas = personalizado.obtenerRoles();
        hayRoles(cartas);

        // Assert
        assertFalse(hayDetectives || hayPadrinos,
                "Creando un mazo con un medico y un sheriff, no debería haber ningún otro rol especial.");
    }

    @Test
    public void test07NoSePermiteCrearCon5Jugadores(){
        // Act y Assert
        assertThrows(CantidadDeJugadoresException.class,
                () -> new Personalizado(constructores, 4),
                "Al crear un mazo de 4 jugadores deberia lanzar excepcion.");
    }
    @Test
    public void test08NoSePermiteCrearCon13Jugadores(){
        // Act y Assert
        assertThrows(CantidadDeJugadoresException.class,
                () -> new Personalizado(constructores, 13),
                "Al crear un mazo de 4 jugadores deberia lanzar excepcion.");
    }

    @Test
    public void test09SePermiteCrearCon5Jugadores(){
        // Act y Assert
        assertDoesNotThrow( () -> new Personalizado(constructores, 5),
                "Al crear un mazo de 4 jugadores deberia lanzar excepcion.");
    }
    @Test
    public void test10SePermiteCrearCon12Jugadores(){
        // Act y Assert
        assertDoesNotThrow( () -> new Personalizado(constructores, 12),
                "Al crear un mazo de 4 jugadores deberia lanzar excepcion.");
    }


}
