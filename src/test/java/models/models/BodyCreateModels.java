package models.models;

import config.Constant;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import static config.Constant.DATASET_ID;
import static javax.swing.Action.NAME;

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
                this.name = Constant.NAME.toString();
                this.datasetId = DATASET_ID.toString();
                this.useExperianData = false;
                this.target = Constant.TARGET.toString();
                ignoredVariables = new ArrayList<>();
                this.ignoredVariables.add(Constant.IGNOREDVARIABLES.toString());
                this.timeFrameStart = Constant.TIMEFRAMESTART.toString();
                this.timeFrameEnd = Constant.TIMEFRAMEEND.toString();
                preProcessings = new ArrayList<>();
                this.businessCase = Constant.BUSINESSCASE.toString();
                trainingParameters = new TrainingParameters();
                this.trainingProportion = Double.parseDouble(Constant.TRAININGPROPORTION.toString());

          return this;
        }

}
