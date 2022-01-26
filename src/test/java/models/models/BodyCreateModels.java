package models.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class BodyCreateModels {

        public String name;
        public String datasetId;
        public String useExperianData;
        public String target;
        public ArrayList<String> ignoredVariables;
        public String timeFrameStart;
        public String timeFrameEnd;
        public ArrayList<PreProcessing> preProcessings;

        public void newBodyCreateModels(){

        }

}
