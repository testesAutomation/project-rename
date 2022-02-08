package config;

public enum Constant {

    DATASET_ID("3dcd5569-1c7d-4d4d-890b-5c66b8c54710"),
    INVALID_DATASET_ID("3dcd556910"),
    INVALID_MODELS_ID("3dcd5569102322"),
    NAME("TestAutomationModels"),
    NAMEUPDATED("UpdatedTestAutomationModels"),
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
    OPTIMIZATIONMETHOD("ksScore"),
    PAGE("0"),
    SIZE("10"),
    SORT("desc"),
    INCLUDE_EXPERIAN("false"),
    ONLY_RELEVANT("false"),
    NAME_MODELS_COLUMNS("default_serasa_12m"),;

    private String constant;

    Constant(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }

    @Override
    public String toString() {
        return constant;

    }
}
