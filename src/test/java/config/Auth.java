package config;

public enum Auth {

    USER("6049045fdc81cc3acaf8f603"),
    PASSWORD("206f8faca3cc18cdf5409406"),
    USERINVALID(""),
    PASSWORDINVALID("");

    private final String auth;

    Auth(String auth) {
        this.auth = auth;

    }

    public String getAuth() {
        return auth;
    }

    @Override
    public String toString() {
        return auth;
    }


}
