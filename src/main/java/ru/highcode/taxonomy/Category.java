package ru.highcode.taxonomy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class represent a labeled set of items with same attributes.
 */
public class Category {
    private final Classification classification;
    private final String name;
    private final String url;
    private final String imgURL;
    private final List<Category> subCategories = new ArrayList<>();
    private final List<Item> items = new ArrayList<>();
    private Category parent;

    public Category(String name, String url) {
        this(name, url, "", null);
    }

    public Category(String name, String url, String imgURL, Classification classification) {
        this.name = name;
        this.url = url;
        this.imgURL = imgURL;
        this.classification = classification;
        validate();
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public boolean addSubCategory(Category category) {
        category.setParent(this);
        return subCategories.add(category);
    }

    public List<Category> getSubCategories() {
        return Collections.unmodifiableList(subCategories);
    }

    public void validate() throws IllegalStateException {
        if (name.isEmpty()) {
            throw new IllegalStateException();
        }
    }

    @Override
    public String toString() {
        return "Category [name=" + name + "]";
    }

    public boolean addGood(Item item) {
        item.getCategories().add(this);
        return items.add(item);
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public String getImgURL() {
        return imgURL;
    }

    public boolean isRoot() {
        return parent == null;
    }

    public void setParent(Category parent) {
        if (this.parent != null) {
            throw new IllegalStateException();
        }
        this.parent = parent;
    }

    public Category getParent() {
        return parent;
    }

}
