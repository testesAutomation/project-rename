package models.experiments;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseCreatesExperiments {

    private String id;
    private String name;
    private String creationDate;
    private String lastUpdateDate;
    private String image;
    private String description;
    private int datasetCount;


}
