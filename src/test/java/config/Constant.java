package config;

public enum Constant {

    DATASET_ID("3dcd5569-1c7d-4d4d-890b-5c66b8c54710");

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
