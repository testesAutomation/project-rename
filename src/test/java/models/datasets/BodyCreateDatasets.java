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
    private File file;


    public BodyCreateDatasets() {
        this.faker = new Faker();

    }
}
