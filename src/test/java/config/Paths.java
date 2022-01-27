package config;

public enum Paths {

    PATH_MODELS("/models"),
    PATH_MODELS_BY_ID("/models/{id_models}");

    private String paths;

    Paths(String paths) {
        this.paths = paths;
    }

    public String getPaths() {
        return paths;
    }

    @Override
    public String toString() {
        return paths;

    }
}