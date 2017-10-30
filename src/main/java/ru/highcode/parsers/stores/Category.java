package ru.highcode.parsers.stores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Category {
    private final String name;
    private final String url;
    private final String imgURL;
    private final List<Category> subCategories = new ArrayList<>();
    private final List<Good> goods = new ArrayList<>();
    private Category parent;

    public Category(String name, String url) {
        this(name, url, "");
    }

    public Category(String name, String url, String imgURL) {
        this.name = name;
        this.url = url;
        this.imgURL = imgURL;
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

    public boolean addGood(Good good) {
        good.getCategories().add(this);
        return goods.add(good);
    }

    public List<Good> getGoods() {
        return Collections.unmodifiableList(goods);
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
