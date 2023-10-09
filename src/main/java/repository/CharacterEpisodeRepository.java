package repository;

import model.CharacterEpisode;

public interface CharacterEpisodeRepository {
	CharacterEpisode findByName(String name);
}
