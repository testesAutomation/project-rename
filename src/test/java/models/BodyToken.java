package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

@Getter
@Setter
public class BodyToken {

    @JsonIgnore
    private String client_id;
    private String client_secret;
    private String grant_type;
    private String scope;

    public BodyToken(){
        client_id = "0oawj0jrpxdRCKt1x0h7";
        client_secret = "5tmq8lT1ChCMGP-HOvhY2UFozhHUT7-b1KkXYrnn";
        grant_type = "client_credentials";
        scope = "amt_grp-sandbox-dextra";
    }
}
