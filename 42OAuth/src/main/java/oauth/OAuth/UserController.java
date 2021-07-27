package oauth.OAuth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.nio.charset.Charset;

@Controller
public class UserController extends HttpServlet {

    ObjectMapper objectMapper = new ObjectMapper();
    Token token = new Token();

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String code,
                        @RequestParam(required = false) String error) throws IOException {
        if (error != null)
            return "index";
        else {
            String queryString = ""
                    + "grant_type=" + "authorization_code" + "&"
                    + "client_id=" + "ca8ebc5cbee6e3047bf84a8dfd51f69d9732484f4f5a91794af7c01bb31ea857" + "&"
                    + "client_secret=" + "88554039980701b168e11a21a5c09c1069bfc432122bc672d1a009022b91519f" + "&"
                    + "code=" + code + "&"
                    + "redirect_uri=" + "http://localhost:8080/login";
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity entity = new HttpEntity(httpHeaders);
            ResponseEntity<String> resp = restTemplate.exchange("https://api.intra.42.fr/oauth/token?" + queryString, HttpMethod.POST, entity,String.class);
            token = objectMapper.readValue(resp.getBody(), Token.class);
            return "login";
        }
    }

    @GetMapping("/select")
    public String Select() {
        System.out.println(token.getAccess_token());
        System.out.println(token.getRefresh_token());
        return "select";
    }
}
