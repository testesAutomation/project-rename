package models.models;

import config.Constant;

import java.util.ArrayList;

public class HyperParemetersOption {

    public String name;
    public String value;
    public Range range;
    public String searchStrategy;
    public ArrayList<String> options;

    public HyperParemetersOption param1(){
        this.name = Constant.NAME_PARAM.toString();
        this.value = Constant.VALUE_PARAM.toString();
        return this;
    }

    public HyperParemetersOption param2(){
        this.name = Constant.NAME_PARAM.toString();
        this.range = new Range();
        this.searchStrategy = Constant.SEARCH_PARAM.toString();
        return this;
    }

    public HyperParemetersOption param3(){
        this.name = Constant.NAME_PARAM.toString();
        this.options = new ArrayList<>();
        options.add(Constant.NAME_PARAM.toString());
        return this;
    }
}
