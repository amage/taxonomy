package ru.highcode.parsers.stores.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.highcode.parsers.stores.Category;
import ru.highcode.parsers.stores.CategoryPath;

public class CategoryPathTest {

    @Test
    public void testForCategory() {
        final Category root = new Category("root", "");
        final Category middle = new Category("middle", "");
        final Category leaf = new Category("leaf", "");
        root.addSubCategory(middle);
        middle.addSubCategory(leaf);

        assertEquals("root", CategoryPath.get(root).toString());
        assertEquals("root -> middle", CategoryPath.get(middle).toString());
        assertEquals("root -> middle -> leaf", CategoryPath.get(leaf).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyGet() {
        CategoryPath.get();
    }
}
