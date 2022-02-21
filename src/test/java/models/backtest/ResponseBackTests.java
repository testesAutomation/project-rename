package models.backtest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseBackTests {
    public String id;
    public String name;
    public String target;
    public String datasetId;
    public String modelId;
    public ResponseStatus status;
    public String creationDate;
    public String conclusionDate;
    public String timeFrameStart;
    public String timeFrameEnd;
    public String analystReport;
}
