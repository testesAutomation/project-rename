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
    private File testUploadFile ;


    public BodyCreateDatasets() {
        this.faker = new Faker();
        this.name  = faker.lorem().characters(9);
        this.experimentId = "3578102f-64cf-4826-b804-e8b864f901d5";
        this.testUploadFile = new File("src/test/resources/datasets.csv"); //Specify your own location and file

    }
}
