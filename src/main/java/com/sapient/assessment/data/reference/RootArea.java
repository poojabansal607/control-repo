package com.sapient.assessment.data.reference;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class RootArea {
    private final RootAreaKey rootAreaKey;

    private final String name;

    private final List<Category> categories;

    public RootArea() {
        // Jackson deserialization
        categories = null;
        name = null;
        rootAreaKey = null;
    }

    public RootArea(RootAreaKey rootAreaKey, String name, List<Category> categories) {
        this.rootAreaKey = rootAreaKey;
        this.name = name;
        this.categories = categories;
    }

    @JsonProperty
    public RootAreaKey getRootAreaKey() {
        return rootAreaKey;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public List<Category> getCategories() {
        return categories;
    }
    
   /* public void setCategories(List<Category> categories){
    	this.categories= categories;
    	
    	
    }
    */
    
    
}