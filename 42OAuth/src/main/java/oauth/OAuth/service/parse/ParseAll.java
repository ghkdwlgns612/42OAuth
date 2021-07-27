package oauth.OAuth.service.parse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import oauth.OAuth.dto.TokenDto;
import oauth.OAuth.service.make.Make;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public class ParseAll implements Parse{

    private final Make make;

    @Autowired
    public ParseAll(Make make) {
        this.make = make;
    }

    @Override
    public JsonNode parseJsonNode(HttpServletRequest request, ObjectMapper objectMapper, TokenDto tokenDto) throws JsonProcessingException {
        String username = request.getParameter("username");
        ResponseEntity<String> resp = make.makeAPI(username,tokenDto);
        JsonNode jsonNode = objectMapper.readTree(resp.getBody()); //Json의 내용이 많아 JsonNode사용.
        return jsonNode;
    }
}
