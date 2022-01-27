package models.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseTrainingInformation {

    public String algorithm;
    public String userDefinedAlgorithm;
    public String optimizationMetric;
    public String trainingProportion;
}
