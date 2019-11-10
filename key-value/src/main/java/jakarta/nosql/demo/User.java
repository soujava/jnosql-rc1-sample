package jakarta.nosql.demo;

import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

import java.util.Map;

@Entity
public class User {

    @Id
    private String nick;

    private String email;

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
