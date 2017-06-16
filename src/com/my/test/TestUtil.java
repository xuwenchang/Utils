package com.my.test;

public enum TestUtil {
    INSTANCES;
    private String animal;
    private String dog;
    private String cat;
    public String getDog(){
        dog = "dog";
        return dog;
    }
    public String getCat(){
        cat = "cat";
        return cat;
    }
}
