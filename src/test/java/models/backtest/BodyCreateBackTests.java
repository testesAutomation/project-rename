package models.backtest;

import config.Constant;
import models.models.ResponseModels;

public class BodyCreateBackTests {

    public String name;
    public String datasetId;
    public String target;
    public String modelId;
    public String timeFrameStart;
    public String timeFrameEnd;

    public BodyCreateBackTests validBody(ResponseModels responseModels){
        name = Constant.NAME_BACKTEST.toString();
        datasetId = Constant.DATASET_ID.toString();
        target = Constant.TARGET.toString();
        modelId = responseModels.getId();
        timeFrameStart = Constant.TIMEFRAMESTART.toString();
        timeFrameEnd = Constant.TIMEFRAMEEND.toString();
        return this;
    }

    public BodyCreateBackTests invalidBody(){
        name = Constant.NAME_BACKTEST.toString();
        datasetId = "";
        target = Constant.TARGET.toString();
        modelId = "";
        timeFrameStart = Constant.TIMEFRAMESTART.toString();
        timeFrameEnd = Constant.TIMEFRAMEEND.toString();
        return this;
    }
}
