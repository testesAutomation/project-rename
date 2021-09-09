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
        this.experimentId  = faker.lorem().characters(8) +
                "-" + faker.lorem().characters(4) +
                "-"+ faker.lorem().characters(4) +
                "-"+ faker.lorem().characters(4) +
                "-"+ faker.lorem().characters(12);

    }
}
