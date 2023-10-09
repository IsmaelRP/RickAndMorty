package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CharacterNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 2661749999545303896L;

	public CharacterNotFoundException(String message) {
        super(message);
    }
}
