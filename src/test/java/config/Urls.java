package config;

public enum Urls {

    TOKEN (""),
    ROOT_EXPERIMENTS ("");

    private String url;

    Urls (String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return url;

    }
}