package config;

public enum Token {

    client_id(""),
    client_secret(""),
    grant_type(""),
    scope("");

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
