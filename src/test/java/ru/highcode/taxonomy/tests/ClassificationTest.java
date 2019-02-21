package ru.highcode.taxonomy.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.highcode.taxonomy.Classification;

public class ClassificationTest {

    @Test
    public void testHierarchy() {
        Classification root = new Classification("root");
        root.getAttributeDescriptions().put("id", Long.class);
        root.getAttributeDefaults().put("id", 100L);
        Classification leaf = new Classification("leaf", root);
        leaf.getAttributeDefaults().put("id", 0L);
        Assert.assertTrue(leaf.getAttributeDescriptions().containsKey("id"));
        Assert.assertEquals(0L, leaf.getAttributeDefaults().get("id"));
    }
}
