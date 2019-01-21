package ru.highcode.taxonomy.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.highcode.taxonomy.Category;
import ru.highcode.taxonomy.Classification;
import ru.highcode.taxonomy.Item;
import ru.highcode.taxonomy.utils.ClassificationBuilder;

public class ItemConstructorTest {

    @Test
    public void testItemAttributesSimple() {
        Classification cl = new ClassificationBuilder().root("root")
                .withAttribute("a1", String.class, "hello, world")
                .build();
        Category root = new Category("root", cl);
        Item item = new Item();
        item.addCategory(root);

        Assert.assertEquals(1, item.getAttributes().size());
        Assert.assertEquals("a1", item.getAttributes().entrySet().iterator().next().getKey());
        Assert.assertEquals("hello, world", item.getAttributes().entrySet().iterator().next().getValue());
    }
}
