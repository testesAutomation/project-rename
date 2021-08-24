package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseListExperiment {

    @JsonIgnore
    private String id;
    private String name;
    private String creationDate;
    private String lastUpdateDate;
    private String image;
    private String description;
    private int datasetCount;
}
