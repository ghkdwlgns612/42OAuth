package oauth.OAuth.service.parse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import oauth.OAuth.dto.TokenDto;

import javax.servlet.http.HttpServletRequest;

public interface Parse {
    public JsonNode parseJsonNode(HttpServletRequest request, ObjectMapper objectMapper, TokenDto tokenDto) throws JsonProcessingException;
}
