package models.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

import static config.Constant.*;

@Getter
@Setter
public class BodyModelsColumns {

    public Integer page;
    public Integer size;
    public String sort;
    public Boolean includeExperian;
    public Boolean onlyRelevant;
    public String name;

    public BodyModelsColumns(){
        page = Integer.getInteger(PAGE.toString());
        size = Integer.getInteger(SIZE.toString());
        sort = SORT.toString();
        includeExperian = Boolean.valueOf(INCLUDE_EXPERIAN.toString());
        onlyRelevant = Boolean.valueOf(ONLY_RELEVANT.toString());
        name = NAME_MODELS_COLUMNS.toString();
    }

}
