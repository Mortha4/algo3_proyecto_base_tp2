package edu.fiuba.algo3.unitarios.partida;

import edu.fiuba.algo3.modelo.partida.Partida;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObservableTest {
    private Partida partida;


    @BeforeEach
    public void arrange(){
        partida = new Partida(List.of("1", "2", "3", "4", "5"));
        partida.iniciar();
    }

    @Test
    public void test01PartidaNotificaLuegoDeCadaNocheASusNotificables(){
        // Arrange
        arrange();
        // Act
        NotificableMock notificable = new NotificableMock();
        partida.agregarNotificable(notificable);
        partida.cambiarFase();
        // Assert
        assertEquals(1, notificable.getVecesInvocadoData(),
                "Al terminar una noche, deberia invocarse por cada notificable una vez notificar (FaseData data)");
    }

    @Test
    public void test02PartidaNotificaLuegoDeCadaDiaASusNotificables(){
        // Arrange
        NotificableMock notificable = new NotificableMock();
        arrange();
        // Act
        partida.cambiarFase();
        partida.agregarNotificable(notificable);
        partida.cambiarFase();
        // Assert
        assertEquals(1, notificable.getVecesInvocadoData(),
                "Al terminar un día, deberia invocarse por cada notificable una vez notificar (FaseData data)");
    }

    @Test
    public void test03LosNotificablesRecibenLas4CondicionesDeVictoriaTrasUnaFaseNocturna(){
        // Arrange
        NotificableMock notificable = new NotificableMock();
        arrange();
        // Act
        partida.agregarNotificable(notificable);
        partida.cambiarFase();
        // Assert
        assertEquals(4, notificable.getVecesInvocadoGanador(),
                "Los notificables son notificados por cada una de las condiciones de victoria.");
    }

    @Test
    public void test04LosNotificablesRecibenLas4CondicionesDeVictoriaTrasUnaFaseDiurna(){
        // Arrange
        NotificableMock notificable = new NotificableMock();
        arrange();
        // Act
        partida.cambiarFase();
        partida.agregarNotificable(notificable);
        partida.cambiarFase();
        // Assert
        assertEquals(4, notificable.getVecesInvocadoGanador(),
                "Los notificables son notificados por cada una de las condiciones de victoria.");
    }
}
