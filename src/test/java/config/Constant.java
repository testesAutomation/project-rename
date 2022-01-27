package config;

public enum Constant {

    DATASET_ID("3dcd5569-1c7d-4d4d-890b-5c66b8c54710"),
    INVALID_DATASET_ID("3dcd556910"),
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
    OPTIMIZATIONMETHOD("ksScore");

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
