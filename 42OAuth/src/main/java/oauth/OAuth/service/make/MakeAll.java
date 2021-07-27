package oauth.OAuth.service.make;

import com.fasterxml.jackson.databind.JsonNode;
import oauth.OAuth.dto.TokenDto;
import oauth.OAuth.dto.UserDto;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class MakeAll implements Make{
    @Override
    public UserDto makeUserDto(JsonNode jsonNode) {
        UserDto userDto = new UserDto(jsonNode.get(0).get("grade").asText()
                , jsonNode.get(0).get("level").asDouble()
                , jsonNode.get(0).get("blackholed_at").asText().substring(0,10)
                , jsonNode.get(0).get("user").get("login").asText());
        return userDto;
    }

    @Override
    public ResponseEntity<String> makeAPI(String username, TokenDto tokenDto) {
        String queryString = "https://api.intra.42.fr/v2/users/" + username + "/cursus_users?access_token=" + tokenDto.getAccess_token();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity entity = new HttpEntity(httpHeaders);
        ResponseEntity<String> resp = restTemplate.exchange(queryString, HttpMethod.GET, entity,String.class);
        return resp;
    }

    @Override
    public ResponseEntity<String> makeToken(String code) {
        String queryString = ""
                + "grant_type=" + "authorization_code" + "&"
                + "client_id=" + "ca8ebc5cbee6e3047bf84a8dfd51f69d9732484f4f5a91794af7c01bb31ea857" + "&"
                + "client_secret=" + "88554039980701b168e11a21a5c09c1069bfc432122bc672d1a009022b91519f" + "&"
                + "code=" + code + "&"
                + "redirect_uri=" + "http://localhost:8080/login";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity entity = new HttpEntity(httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange("https://api.intra.42.fr/oauth/token?" + queryString, HttpMethod.POST, entity,String.class);
        return response;
    }
}
