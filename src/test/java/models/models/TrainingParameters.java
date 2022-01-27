package models.models;

import config.Constant;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class TrainingParameters {

    public String algorithm;
    public String optimizationMetric;
    public ArrayList<HyperParemetersOption> hyperParemetersOptions;

    public TrainingParameters(){
        this.algorithm = Constant.TRAININGPARAMS.toString();
        this.optimizationMetric = Constant.OPTIMIZATIONMETHOD.toString();
        hyperParemetersOptions = new ArrayList<>();
        HyperParemetersOption parameters = new HyperParemetersOption();
        hyperParemetersOptions.add(parameters.param1());
        hyperParemetersOptions.add(parameters.param2());
        hyperParemetersOptions.add(parameters.param3());

    }

}
