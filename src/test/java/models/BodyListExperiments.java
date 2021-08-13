package models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
public class BodyListExperiments {

    @JsonIgnore
    private Faker faker;
    private String page;
    private String size;
    private String sort;

    public BodyListExperiments(){
        faker = new Faker(new Locale("pt-BR"));
        page = faker.options().option("0", "1", "2", "3");
        size = "10";
        sort = "creationDate%2Cdesc";

    }
}
