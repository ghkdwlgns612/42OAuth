package oauth.OAuth;

import com.fasterxml.jackson.databind.ObjectMapper;
import oauth.OAuth.service.make.Make;
import oauth.OAuth.service.make.MakeAll;
import oauth.OAuth.service.parse.Parse;
import oauth.OAuth.service.parse.ParseAll;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public Make make() {
        return new MakeAll();
    }
    @Bean
    public Parse parse() {
        return new ParseAll(make());
    }
}
