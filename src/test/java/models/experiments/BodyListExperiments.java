package models.experiments;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BodyListExperiments {

    private String InvalidParam;

    public BodyListExperiments listExperimentsInvalid(){
        InvalidParam = "";
        return this;
    }
}
