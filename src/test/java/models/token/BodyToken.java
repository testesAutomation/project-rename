package models.token;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BodyToken {

    private String client_id;
    private String client_secret;
    private String grant_type;
    private String scope;

    public BodyToken(){
        client_id =  System.getenv("CLIENT_ID");
        client_secret = System.getenv("CLIENT_SECRET");
        grant_type = System.getenv("GRANT_TYPE");
        scope = System.getenv("SCOPE");
    }
}
