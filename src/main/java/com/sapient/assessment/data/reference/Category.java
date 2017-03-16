package com.sapient.assessment.data.reference;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Category {
    private final CategoryKey categoryKey;

    private final String name;

    private final List<SubCategory> subCategories;

    public Category() {
        // Jackson deserialization
        subCategories = null;
        name = null;
        categoryKey = null;
    }

    public Category(CategoryKey categoryKey, String name, List<SubCategory> subCategories) {
        this.categoryKey = categoryKey;
        this.name = name;
        this.subCategories = subCategories;
    }

    @JsonProperty
    public CategoryKey getCategoryKey() {
        return categoryKey;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public List<SubCategory> getSubCategories() {
        return subCategories;
    }
}