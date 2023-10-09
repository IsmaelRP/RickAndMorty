package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CharacterEpisode implements Serializable {

	private static final long serialVersionUID = 8484645382186205730L;

	private String name;
	
	private List<String> episodes;
	
	private LocalDate firstAppearance;

}
