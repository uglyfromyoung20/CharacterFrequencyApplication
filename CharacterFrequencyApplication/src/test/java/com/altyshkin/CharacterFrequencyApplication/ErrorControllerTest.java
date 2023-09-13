package com.altyshkin.CharacterFrequencyApplication;

import com.altyshkin.CharacterFrequencyApplication.controller.ErrorController;
import com.altyshkin.CharacterFrequencyApplication.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorControllerTest {

    private final ErrorController errorController = new ErrorController();

    @Test
    void handleException_ShouldReturnInternalServerError() {
        // Arrange
        Exception ex = new Exception("Test exception");

        // Act
        ResponseEntity<String> response = errorController.handleNotFoundException(ex);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Некорректный запрос. попробуйте ввести Url: http://localhost:8080/character-frequency?inputString= ", response.getBody());
    }

    @Test
    void handleException_ShouldReturnInternalServerError1() {
        NotFoundException ex = new NotFoundException();

        ResponseEntity<String> response = errorController.handleSizeException(ex);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        assertEquals("Длина строки должна быть меньше 12", response.getBody());

    }
}
