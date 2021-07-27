package oauth.OAuth.service.make;

import com.fasterxml.jackson.databind.JsonNode;
import oauth.OAuth.dto.TokenDto;
import oauth.OAuth.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface Make {
   public UserDto makeUserDto(JsonNode jsonNode);
   public ResponseEntity<String> makeAPI(String username, TokenDto tokenDto);
   public ResponseEntity<String> makeToken(String code);
}
