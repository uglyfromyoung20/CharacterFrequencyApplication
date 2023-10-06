package com.altyshkin.CharacterFrequencyApplication.controller;

import com.altyshkin.CharacterFrequencyApplication.exception.HandleMaxException;
import com.altyshkin.CharacterFrequencyApplication.exception.HandleMinException;
import com.altyshkin.CharacterFrequencyApplication.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Страница не найдена");
    }

    @ExceptionHandler(value = {HandleMaxException.class})
    public ResponseEntity<String> handleSizeException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Длина строки должна быть меньше 12");
    }

    @ExceptionHandler()
    public ResponseEntity<String> handleSizeMinException(HandleMinException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Длина строки должна быть 1 или более символов");
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<String> handleNotFoundException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Некорректный запрос. попробуйте ввести Url: http://localhost:8080/character-frequency?inputString= ");
    }


}