package ru.highcode.taxonomy.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import ru.highcode.taxonomy.Category;
import ru.highcode.taxonomy.utils.CategoryPath;

public class CategoryPathTest {

    @Test
    public void testForCategory() {
        final Category root = new Category("root", "");
        final Category middle = new Category("middle", "");
        final Category leaf = new Category("leaf", "");
        root.addSubCategory(middle);
        middle.addSubCategory(leaf);

        Assert.assertEquals("root", CategoryPath.get(root).toString());
        assertEquals("root -> middle", CategoryPath.get(middle).toString());
        assertEquals("root -> middle -> leaf", CategoryPath.get(leaf).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyGet() {
        CategoryPath.get();
    }
}
