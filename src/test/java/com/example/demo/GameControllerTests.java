package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;


public class GameControllerTests {
   @Test
    public void gameTest() {
        // Arrange
        GameService mockGameService = mock(GameService.class);
        when(mockGameService.checkGuess(anyInt())).thenReturn("Test message");
        GameController controller = new GameController(mockGameService);
        ModelMap model = new ModelMap();

        // Act
        String viewName = controller.game(50, model);

        // Assert
        assertEquals("game", viewName);
        assertTrue(model.containsAttribute("message"));
        verify(mockGameService, times(1)).checkGuess(50);
    }   
}