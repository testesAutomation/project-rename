package models.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import static config.Constant.DATASET_ID;

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
        public TrainingParameters trainingParameters;
        public double trainingProportion;

        public BodyCreateModels newBodyCreateModels(){
                this.name = "TestAutomationModels";
                this.datasetId = DATASET_ID.toString();
                this.useExperianData = false;
                this.target = "default_serasa_12m";
                ignoredVariables = new ArrayList<>();
                this.ignoredVariables.add("default_serasa_12m");
                this.timeFrameStart = "2020-03";
                this.timeFrameEnd = "2020-03";
                preProcessings = new ArrayList<>();
                this.businessCase = "credit";
                trainingParameters = new TrainingParameters();
                this.trainingProportion = 0.7;

          return this;
        }

}
