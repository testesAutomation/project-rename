package models.datasets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;
import com.github.javafaker.File;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BodyCreateDatasets {

    @JsonIgnore
    private Faker faker;
    private String name;
    private String experimentId;
    private File file;

    public BodyCreateDatasets() {
        this.faker = new Faker();
        this.name  = faker.lorem().characters(9);
        this.experimentId = "3578102f-64cf-4826-b804-e8b864f901d5";

    }
}
