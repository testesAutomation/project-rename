package models.models;

import java.util.ArrayList;

public class TrainingParameters {

    public String algorithm;
    public String optimizationMetric;
    public ArrayList<HyperParemetersOption> hyperParemetersOptions;

    public TrainingParameters(){
        this.algorithm = "LightGBM";
        this.optimizationMetric = "ksScore";
        hyperParemetersOptions = new ArrayList<>();
        HyperParemetersOption parameters = new HyperParemetersOption();
        hyperParemetersOptions.add(parameters.param1());
        hyperParemetersOptions.add(parameters.param2());
        hyperParemetersOptions.add(parameters.param3());

    }

}
