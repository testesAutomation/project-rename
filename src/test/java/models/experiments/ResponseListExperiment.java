package models.experiments;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseListExperiment {

    private String id;
    private String name;
    private String creationDate;
    private String lastUpdateDate;
    private String image;
    private String description;
    private int datasetCount;
}
