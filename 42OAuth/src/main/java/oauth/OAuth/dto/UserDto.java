package oauth.OAuth.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
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


/**
 "grade":"Learner"
 ,"level":2.04
 ,"skills":[{"id":1,"name":"Algorithms & AI","level":2.16},{"id":3,"name":"Rigor","level":2.01},{"id":10,"name":"Network & system administration","level":1.41},{"id":4,"name":"Unix","level":1.07},{"id":2,"name":"Imperative programming","level":0.71}]
 ,"blackholed_at":"2021-12-31T00:42:00.000Z"
 ,"id":120256
 ,"begin_at":"2021-05-03T00:42:00.000Z"
 ,"end_at":null,"cursus_id":21,"has_coalition":true
 ,"created_at":"2021-04-23T11:41:25.114Z"
 ,"updated_at":"2021-04-23T11:41:25.114Z"
 ,"user":{"id":86991,"login":"jihuhwan","url":"https://api.intra.42.fr/v2/users/jihuhwan","created_at":"2021-03-23T02:01:28.770Z","updated_at":"2021-07-08T09:00:06.724Z"}
 ,"cursus":{"id":21,"created_at":"2019-07-29T08:45:17.896Z","name":"42cursus","slug":"42cursus"}}

 **/