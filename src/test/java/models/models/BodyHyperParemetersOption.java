package models.models;

import config.Paraments;

import java.util.ArrayList;

public class BodyHyperParemetersOption {

    public String name;
    public String value;
    public BodyRange range;
    public String searchStrategy;
    public ArrayList<String> options;

    public BodyHyperParemetersOption param1(){
        this.name = Paraments.NAME_PARAM.toString();
        this.value = Paraments.VALUE_PARAM.toString();
        return this;
    }

    public BodyHyperParemetersOption param2(){
        this.name = Paraments.NAME_PARAM.toString();
        this.range = new BodyRange();
        this.searchStrategy = Paraments.SEARCH_PARAM.toString();
        return this;
    }

    public BodyHyperParemetersOption param3(){
        this.name = Paraments.NAME_PARAM.toString();
        this.options = new ArrayList<>();
        options.add(Paraments.NAME_PARAM.toString());
        return this;
    }
}
