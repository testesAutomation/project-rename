package config;

public enum Paths {

    PATH_MODELS("/models"),
    PATH_MODELS_BY_ID("/models/{id_models}"),
    PATH_MODELS_DATASET_COMPATIBLE("/models/{id_models}/datasets/compatible"),
    PATH_MODELS_PREPROCESSING("/models/{id_models}/preprocessing"),
    PATH_MODELS_COLUMNS("/models/{id_models}/columns");

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