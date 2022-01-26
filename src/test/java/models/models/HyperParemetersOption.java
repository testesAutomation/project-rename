package models.models;

import java.util.ArrayList;

public class HyperParemetersOption {

    public String name;
    public String value;
    public Range range;
    public String searchStrategy;
    public ArrayList<String> options;

    public HyperParemetersOption param1(){
        this.name = "string";
        this.value = "string";
        return this;
    }

    public HyperParemetersOption param2(){
        this.name = "string";
        this.range = new Range();
        this.searchStrategy = "quniform";
        return this;
    }

    public HyperParemetersOption param3(){
        this.name = "string";
        this.options = new ArrayList<>();
        options.add("string");
        return this;
    }
}
