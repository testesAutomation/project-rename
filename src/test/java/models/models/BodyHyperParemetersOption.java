package models.models;

import config.Constant;

import java.util.ArrayList;

public class BodyHyperParemetersOption {

    public String name;
    public String value;
    public BodyRange range;
    public String searchStrategy;
    public ArrayList<String> options;

    public BodyHyperParemetersOption param1(){
        this.name = Constant.NAME_PARAM.toString();
        this.value = Constant.VALUE_PARAM.toString();
        return this;
    }

    public BodyHyperParemetersOption param2(){
        this.name = Constant.NAME_PARAM.toString();
        this.range = new BodyRange();
        this.searchStrategy = Constant.SEARCH_PARAM.toString();
        return this;
    }

    public BodyHyperParemetersOption param3(){
        this.name = Constant.NAME_PARAM.toString();
        this.options = new ArrayList<>();
        options.add(Constant.NAME_PARAM.toString());
        return this;
    }
}
