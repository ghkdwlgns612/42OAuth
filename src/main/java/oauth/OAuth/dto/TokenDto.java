package oauth.OAuth.dto;

import lombok.Data;

@Data
public class TokenDto {
    private String access_token;
    private String refresh_token;
    private String token_type;
    private int expires_in;
    private String scope;
    private int created_at;
}
