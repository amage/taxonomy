package ru.highcode.taxonomy.utils;

import ru.highcode.taxonomy.Classification;

public class ClassificationBuilder {
    private Classification currentClassification;

    public ClassificationBuilder() {
        // no op
    }

    public Classification build() {
        return currentClassification;
    }

    public ClassificationBuilder root(String id) {
        if (currentClassification != null) {
            throw new IllegalStateException("currentClassification != null");
        }
        currentClassification = new Classification(id);
        return this;
    }

    public ClassificationBuilder withAttribute(String name, Class<?> type, Object defaultValue) {
        if (currentClassification == null) {
            throw new IllegalStateException("currentClassification is null");
        }
        currentClassification.getAttributeDescriptions().put(name, type);
        currentClassification.getAttributeDefaults().put(name, defaultValue);
        return this;
    }
}
