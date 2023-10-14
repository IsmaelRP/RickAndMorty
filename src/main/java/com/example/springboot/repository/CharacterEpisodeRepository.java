package com.example.springboot.repository;

import com.example.springboot.model.CharacterEpisode;

public interface CharacterEpisodeRepository {
	CharacterEpisode findByName(String name);
}
