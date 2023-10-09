package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.CharacterEpisode;
import service.CharacterEpisodeService;

@RestController
public class CharacterEpisodeController {

	private final CharacterEpisodeService characterService;

    public CharacterEpisodeController(CharacterEpisodeService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/search-character-appearance")
    public CharacterEpisode searchCharacterByName(@RequestParam String name) {
        return characterService.findCharacterEpisodeByName(name);
    }
    
}
