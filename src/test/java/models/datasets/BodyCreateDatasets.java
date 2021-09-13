package models.datasets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
public class BodyCreateDatasets {

    @JsonIgnore
    private Faker faker;
    private String name;
    private String experimentId;
    private File file;


}
