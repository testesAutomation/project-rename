package config;

public enum Paraments {

    DATASET_ID("3dcd5569-1c7d-4d4d-890b-5c66b8c54710"),
    MODELS_ID(""),
    NAME("TestAutomationModels"),
    TECHNICAL_ANALYST("Test Automation BackTests"),
    INVALID_BACKTESTS_ID("234123412313133132313132"),
    BACKTESTS_COMPANY("serasa_12m"),
    BACKTESTS_TITLE("serasa_13m"),
    BACKTESTS_CONCLUSION("serasa_14m"),
    NAME_BACKTEST("TestAutomationBackTest"),
    NAME_PARAM("string"),
    VALUE_PARAM("string"),
    SEARCH_PARAM("quniform"),
    TARGET("default_serasa_12m"),
    IGNOREDVARIABLES("default_serasa_12m"),
    TIMEFRAMESTART("2020-03"),
    TIMEFRAMEEND("2020-03"),
    BUSINESSCASE("credit"),
    TRAININGPROPORTION("0.7"),
    TRAININGPARAMS("LightGBM"),
    OPTIMIZATIONMETHOD("ksScore");

    private String paraments;

    Paraments(String paraments) {
        this.paraments = paraments;
    }

    public String getParaments() {
        return paraments;
    }

    @Override
    public String toString() {
        return paraments;

    }
}
