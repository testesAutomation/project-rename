package models.backtest;

import config.Paraments;
import models.models.ResponseModels;

public class BodyCreateBackTests {

    public String name;
    public String datasetId;
    public String target;
    public String modelId;
    public String timeFrameStart;
    public String timeFrameEnd;

    public BodyCreateBackTests validBody(ResponseModels responseModels){
        name = Paraments.NAME_BACKTEST.toString();
        datasetId = Paraments.DATASET_ID.toString();
        target = Paraments.TARGET.toString();
        modelId = responseModels.getId();
        timeFrameStart = Paraments.TIMEFRAMESTART.toString();
        timeFrameEnd = Paraments.TIMEFRAMEEND.toString();
        return this;
    }

    public BodyCreateBackTests invalidBody(){
        name = Paraments.NAME_BACKTEST.toString();
        datasetId = "";
        target = Paraments.TARGET.toString();
        modelId = "";
        timeFrameStart = Paraments.TIMEFRAMESTART.toString();
        timeFrameEnd = Paraments.TIMEFRAMEEND.toString();
        return this;
    }
}
