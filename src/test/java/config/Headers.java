package config;

public enum Headers {

    AUTHORIZATION ("Authorization"),
    BEARER ("Bearer ");

    private String header;

    Headers(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }

    @Override
    public String toString() {
        return header;

    }
}
