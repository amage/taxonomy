package ru.highcode.taxonomy;

import java.util.*;

/**
 * This class represent a labeled set of items with same attributes.
 */
public class Category {
    private final Classification classification;
    private final String id;
    private final List<Category> children = new ArrayList<>();
    private final List<Category> parents = new ArrayList<>();
    private final Map<String, Object> attributeDefaults = new HashMap<>();

    public Category(String id) {
        this(id, null);
    }

    public Category(String id, Classification classification) {
        this.id = id;
        this.classification = classification;
        if (classification != null) {
            initAttributes();
        }
    }

    private void initAttributes() {
        if (!attributeDefaults.isEmpty()) {
            attributeDefaults.clear();
        }
        // TODO inhere parents attribute
        attributeDefaults.putAll(classification.getAttributeDefaults());
    }

    public boolean addChild(Category category) {
        category.getParents().add(this);
        return children.add(category);
    }

    public List<Category> getChildren() {
        return children;
    }

    public boolean addItem(Item item) {
        return item.getCategories().add(this);
    }

    public boolean isRoot() {
        return parents.isEmpty();
    }

    public void addParent(Category parent) {
        parents.add(parent);
    }

    public List<Category> getParents() {
        return parents;
    }

    public String getId() {
        return id;
    }

    public Map<String, Object> getAttributeDefaults() {
        return attributeDefaults;
    }
}
