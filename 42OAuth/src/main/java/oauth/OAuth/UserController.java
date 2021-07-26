package oauth.OAuth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;

@Controller
public class UserController extends HttpServlet {

    String auth_code;

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String code,
                        @RequestParam(required = false) String error,
                        Model model) throws IOException {
        if (error != null)
            return "index";
        else {
            auth_code = code;
            String queryString = ""
                    + "grant_type=" + "authorization_code" + "&"
                    + "client_id=" + "ca8ebc5cbee6e3047bf84a8dfd51f69d9732484f4f5a91794af7c01bb31ea857" + "&"
                    + "client_secret=" + "88554039980701b168e11a21a5c09c1069bfc432122bc672d1a009022b91519f" + "&"
                    + "code=" + auth_code + "&"
                    + "redirect_uri=" + "http://localhost:8080/login" + "&"
                    + "scope=public";
            model.addAttribute("code",auth_code);
            System.out.println("auth_code = " + auth_code);
            return "login";
        }
    }

    @GetMapping("/select")
    public String Select(ModelAndView modelAndView) {

        return "select";
    }
}
