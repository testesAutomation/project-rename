package models.datasets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;
import com.github.javafaker.File;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseCreateDatasets {

    public String id;
    public String name;
    public String experimentId;
    //public Parent parent;
    public String creationDate;
    public String lastUpdateDate;
    public String conclusionDate;
    public int size;
    //public Status status;
    public int numRows;
    public int numColumns;
    public String defaultTarget;



}
