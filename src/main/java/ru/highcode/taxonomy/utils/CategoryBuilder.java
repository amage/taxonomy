package ru.highcode.taxonomy.utils;

import ru.highcode.taxonomy.Category;
import ru.highcode.taxonomy.Classification;

public class CategoryBuilder {
    private Category currentCategory;

    public CategoryBuilder() {
        // no op
    }

    public Category build() {
        return currentCategory;
    }

    public CategoryBuilder root(String id, Classification classification) {
        if (currentCategory != null) {
            throw new IllegalStateException("currentCategory != null");
        }
        currentCategory = new Category(id, classification);
        return this;
    }
}
