package com.example.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.CharacterDto;
import com.example.springboot.service.CharacterEpisodeService;

@RestController
public class CharacterEpisodeController {

	private final CharacterEpisodeService characterService;

    public CharacterEpisodeController(CharacterEpisodeService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/search-character-appearance")
    public CharacterDto searchCharacterByName(@RequestParam String name) {
        return characterService.findCharacterEpisodeByName(name);
    }
    
}
