package jakarta.nosql.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

import java.util.Map;

@Entity
public class User {

    @Id
    @JsonProperty
    private String nick;

    @JsonProperty
    private String email;

    @JsonProperty
    private Map<String, String> settings;

    public void update(User user) {
        this.email = user.email;
        this.settings = user.settings;
    }

    @Override
    public String toString() {
        return "User{" +
                "nick='" + nick + '\'' +
                ", email='" + email + '\'' +
                ", settings=" + settings +
                '}';
    }

}
