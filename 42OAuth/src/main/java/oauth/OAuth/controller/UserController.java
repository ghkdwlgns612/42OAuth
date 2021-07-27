package oauth.OAuth.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import oauth.OAuth.dto.TokenDto;
import oauth.OAuth.dto.UserDto;
import oauth.OAuth.service.make.Make;
import oauth.OAuth.service.parse.Parse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class UserController extends HttpServlet {

    private final Make make;
    private final Parse parse;
    ObjectMapper objectMapper = new ObjectMapper();
    TokenDto tokenDto = new TokenDto();

    @Autowired
    public UserController(Make make, Parse parse) {
        this.make = make;
        this.parse = parse;
    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String code,
                        @RequestParam(required = false) String error) throws IOException {
        if (error != null)
            return "index";
        else {
            ResponseEntity<String> resp = make.makeToken(code); //액세스토큰 및 리프레쉬 토큰생성 후 받아오기.
            tokenDto = objectMapper.readValue(resp.getBody(), TokenDto.class); //token객체에 값 넣기.
            return "login";
        }
    }

    @GetMapping("/select")
    public String Select(Model model) {
        model.addAttribute("token", tokenDto); //Token을 Thymleaf에서 사용하도록 Model설정
        return "search";
    }

    @GetMapping("/render")
    public String displayProfile(HttpServletRequest request, Model model) throws JsonProcessingException {
        JsonNode jsonNode = parse.parseJsonNode(request, objectMapper,tokenDto);//Json을 노드에 저장.
        UserDto userDto = make.makeUserDto(jsonNode);//Json내용 중 필요한 것을 뽑아 UserDto객체에 저장.
        model.addAttribute("user",userDto); //Thymleaf에서 사용하도록 Model설정.
        return "render";
    }
}
