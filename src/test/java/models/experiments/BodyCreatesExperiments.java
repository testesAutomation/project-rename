package models.experiments;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

@Getter
@Setter
public class BodyCreatesExperiments {

    @JsonIgnore
    private Faker faker;
    private String id;
    private String name;
    private String image;
    private String description;

    public BodyCreatesExperiments validBody(){
        faker = new Faker(new Locale("pt-BR"));
        id = faker.lorem().characters(8) +
                "-" + faker.lorem().characters(4) +
                "-"+ faker.lorem().characters(4) +
                "-"+ faker.lorem().characters(4) +
                "-"+ faker.lorem().characters(12);
        name = "Experiment automation test " + faker.number().randomDigit();
        description = "rest-assured test";
        image= "data:image/png;base64,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";
        return this;
    }

    public BodyCreatesExperiments invalidBody(){
        faker = new Faker(new Locale("pt-BR"));
        id = faker.lorem().characters(10) + "-" + faker.number().numberBetween(1000000, 9999999);
        name = "";
        description = "rest-assured test";
        image= "data:image/png;base64,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";
        return this;
    }


}

