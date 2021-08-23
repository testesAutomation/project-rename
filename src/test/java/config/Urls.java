package config;

public enum Urls {

    TOKEN ("https://experian-brb.oktapreview.com/oauth2/ausqshum9bHg4fRzc0h7/v1/token"),
    ROOT_EXPERIMENTS ("https://amt-homolog.datalabserasaexperian.com.br/api/v2");

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