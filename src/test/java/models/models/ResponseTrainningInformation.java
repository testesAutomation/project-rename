package models.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseTrainningInformation {

    public String algorithm;
    public String userDefinedAlgorithm;
    public String optimizationMetric;
    public String trainingProportion;
}
