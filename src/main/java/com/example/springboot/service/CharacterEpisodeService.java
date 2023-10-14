package com.example.springboot.service;

import com.example.springboot.model.CharacterDto;

public interface CharacterEpisodeService {
	CharacterDto findCharacterEpisodeByName(String name);
}
