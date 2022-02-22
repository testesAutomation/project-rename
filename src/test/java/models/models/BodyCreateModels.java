package models.models;

import config.Paraments;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import static config.Paraments.DATASET_ID;

@Getter
@Setter
public class BodyCreateModels {

        public String name;
        public String datasetId;
        public Boolean useExperianData;
        public String target;
        public ArrayList<String> ignoredVariables;
        public String timeFrameStart;
        public String timeFrameEnd;
        public ArrayList<Object> preProcessings;
        public String businessCase;
        public BodyTrainingParameters trainingParameters;
        public double trainingProportion;

        public BodyCreateModels newBodyCreateModels(){
                this.name = Paraments.NAME.toString();
                this.datasetId = DATASET_ID.toString();
                this.useExperianData = false;
                this.target = Paraments.TARGET.toString();
                ignoredVariables = new ArrayList<>();
                this.ignoredVariables.add(Paraments.IGNOREDVARIABLES.toString());
                this.timeFrameStart = Paraments.TIMEFRAMESTART.toString();
                this.timeFrameEnd = Paraments.TIMEFRAMEEND.toString();
                preProcessings = new ArrayList<>();
                this.businessCase = Paraments.BUSINESSCASE.toString();
                trainingParameters = new BodyTrainingParameters();
                this.trainingProportion = Double.parseDouble(Paraments.TRAININGPROPORTION.toString());

          return this;
        }

}
