package models.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class ResponseModels {

    public String id;
    public String name;
    public String businessCase;
    public String algorithm;
    public ResponseTrainingInformation trainingInformation;
    public ArrayList<Object> preProcessings;
    public String useExperianData;
    public String parentDatasetId;
    public String creationDate;
    public String lastUpdateDate;
    public ResponseStatus status;
    public String target;
    public ArrayList<Object> ignoredVariables;
    public ResponseDeploy deploy;
    public String timeFrameStart;
    public String timeFrameEnd;
}
