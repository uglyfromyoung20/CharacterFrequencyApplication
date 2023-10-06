package com.altyshkin.CharacterFrequencyApplication.controller;

import com.altyshkin.CharacterFrequencyApplication.exception.HandleMaxException;
import com.altyshkin.CharacterFrequencyApplication.exception.HandleMinException;
import com.altyshkin.CharacterFrequencyApplication.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @GetMapping("/character-frequency")
    public ResponseEntity<Map<Character, Integer>> getCharacterFrequency(
            @RequestParam @NonNull String inputString
    ) throws NotFoundException, HandleMinException, HandleMaxException {
        if (inputString.length() > 12) {
            throw new HandleMaxException();
        }
        if (inputString.length() < 1) {
            throw new HandleMinException();
        }
        // Вычисление частоты встречи символов
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : inputString.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Сортировка по убыванию частоты встречи символа
        Map<Character, Integer> sortedMap = frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return ResponseEntity.ok(sortedMap);
    }

}


