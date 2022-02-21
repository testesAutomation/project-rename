package models.models;

import config.Constant;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class BodyTrainingParameters {

    public String algorithm;
    public String optimizationMetric;
    public ArrayList<BodyHyperParemetersOption> hyperParemetersOptions;

    public BodyTrainingParameters(){
        this.algorithm = Constant.TRAININGPARAMS.toString();
        this.optimizationMetric = Constant.OPTIMIZATIONMETHOD.toString();
        hyperParemetersOptions = new ArrayList<>();
        BodyHyperParemetersOption parameters = new BodyHyperParemetersOption();
        hyperParemetersOptions.add(parameters.param1());
        hyperParemetersOptions.add(parameters.param2());
        hyperParemetersOptions.add(parameters.param3());

    }

}
