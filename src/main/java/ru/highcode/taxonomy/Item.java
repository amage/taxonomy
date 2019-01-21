package ru.highcode.taxonomy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Item {
    private final Map<String, Object> attributes = new HashMap<>();
    private String id;

    private final List<Category> categories = new ArrayList<>();

    public List<Category> getCategories() {
        return categories;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void addCategory(Category category) {
        category.getAttributeDefaults().forEach((k, v) -> {
            if (!attributes.containsKey(k)) {
                attributes.put(k, v);
            }
        });
    }
}
