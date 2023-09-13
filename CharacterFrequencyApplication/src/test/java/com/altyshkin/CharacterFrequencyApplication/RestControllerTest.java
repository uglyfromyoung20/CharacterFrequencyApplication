package com.altyshkin.CharacterFrequencyApplication;

import com.altyshkin.CharacterFrequencyApplication.controller.RestController;
import com.altyshkin.CharacterFrequencyApplication.exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class RestControllerTest {

    @Test
    public void testGetCharacterFrequency() throws NotFoundException {
        // Arrange
        RestController controller = new RestController();
        String inputString = "aaaee";
        Map<Character, Integer> expectedFrequencyMap = new HashMap<>();
        expectedFrequencyMap.put('a', 3);
        expectedFrequencyMap.put('e', 2);
        // Act
        Map<Character, Integer> actualFrequencyMap = controller.getCharacterFrequency(inputString).getBody();

        // Assert
        Assertions.assertEquals(expectedFrequencyMap, actualFrequencyMap);
    }

}