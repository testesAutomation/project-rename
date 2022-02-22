package config;

public enum Paths {

    PATH_MODELS("/models"),
    PATH_MODELS_BY_ID("/models/{id_models}"),
    PATH_BACKTEST("/backtests"),
    PATH_BACKTEST_BY_ID("/backtests/{id_backtests}"),
    PATH_BACKTEST_ANALYST("/backtests/{id_backtests}/analystReport");

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