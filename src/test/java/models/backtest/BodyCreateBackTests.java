package models.backtest;

import config.Paraments;

public class BodyCreateBackTests {

    public String name;
    public String datasetId;
    public String target;
    public String modelId;
    public String timeFrameStart;
    public String timeFrameEnd;

    public BodyCreateBackTests validBody(){
        name = Paraments.NAME_BACKTEST.toString();
        datasetId = Paraments.DATASET_ID.toString();
        target = Paraments.TARGET.toString();
        modelId = Paraments.MODELS_ID.toString();
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
