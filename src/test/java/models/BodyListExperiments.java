package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;
import java.util.Locale;

@Getter
@Setter
public class BodyListExperiments {

    private String InvalidParam;

    public BodyListExperiments listExperimentsInvalid(){
        InvalidParam = "";
        return this;
    }
}
