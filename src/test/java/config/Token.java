package config;

public enum Token {

    client_id("0oawj0jrpxdRCKt1x0h7"),
    client_secret("5tmq8lT1ChCMGP-HOvhY2UFozhHUT7-b1KkXYrnn"),
    grant_type("client_credentials"),
    scope("amt_grp-sandbox-dextra");

    private final String token;


    Token(String token) {
        this.token = token;

    }

    public String getAuth() {
        return token;
    }

    @Override
    public String toString() {
        return token;
    }
}
