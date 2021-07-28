package oauth.OAuth.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto { //생성자를 만든 이유는 객체 생성 시 값을 넣어서 만들어주기 위해서.
    private String grade;
    private double level;
    private String blackholed_at;
    private String name;

    public UserDto(String grade, double level, String blackholed_at, String name) {
        this.grade = grade;
        this.level = level;
        this.blackholed_at = blackholed_at;
        this.name = name;
    }
}
