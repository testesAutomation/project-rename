package config;

public enum Paths {

    PATH_EXPERIMENTS("/experiments"),
    PATH_DATASETS("/datasets"),
    PATH_DATASETS_BY_ID("/datasets/{id_datasets}"),
    PATH_DATASETS_TIMEFRAMES("/datasets/{id_datasets}/timeFrames"),
    PATH_DATASETS_COLUMNS("/datasets/{id_datasets}/columns");

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