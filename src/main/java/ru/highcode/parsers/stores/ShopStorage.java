package ru.highcode.parsers.stores;

import java.util.ArrayList;
import java.util.List;

public class ShopStorage {
    private final String name;
    private final List<Category> categoriesRoots = new ArrayList<>();

    public ShopStorage(String name) {
        this.name = name;
    }

    public void save() {

    }

    public void addCategory(Category category) {
        categoriesRoots.add(category);
    }

    public List<Category> getCategoriesRoots() {
        return categoriesRoots;
    }

}
