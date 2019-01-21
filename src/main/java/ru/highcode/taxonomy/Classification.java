package ru.highcode.taxonomy;

import java.util.*;

/**
 * This class cary attributes description of Item. Attributes can be organized in hierarchy. Child Classification nodes
 * will inhere all attribute descriptions from parents.
 */
public class Classification {
    private final String id;
    private final Classification parent;
    private final List<Classification> children = new ArrayList<>();
    private final Map<String, Class> attributeDescriptions = new HashMap<>();
    private final Map<String, Object> attributeDefaults = new HashMap<>();

    public Classification(String id) {
        this.id = id;
        this.parent = null;
    }

    public Classification(String id, Classification parent) {
        this.id = id;
        this.parent = parent;
        parent.children.add(this);
    }

    public String getId() {
        return id;
    }

    public List<Classification> getChildren() {
        return children;
    }

    public Classification getParent() {
        return parent;
    }

    public Map<String, Class> getAttributeDescriptions() {
        return attributeDescriptions;
    }

    public Map<String, Object> getAttributeDefaults() {
        return attributeDefaults;
    }
}
