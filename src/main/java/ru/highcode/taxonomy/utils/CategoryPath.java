package ru.highcode.taxonomy.utils;

import ru.highcode.taxonomy.Category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryPath {
    private final List<String> pathSegments = new ArrayList<>();

    private CategoryPath() {
    }

    public List<String> getPathSegments() {
        return Collections.unmodifiableList(pathSegments);
    }

    public static CategoryPath get(String... segments) {
        if (segments.length == 0) {
            throw new IllegalArgumentException();
        }
        final CategoryPath result = new CategoryPath();
        for (final String segment : segments) {
            result.pathSegments.add(segment);
        }
        return result;
    }

    public static CategoryPath get(Category category) {
        // TODO: rewrite
        final Category parent = category.getParent();
        if (parent == null) {
            return get(category.getName());
        }

        final ArrayList<String> segments = new ArrayList<>(CategoryPath.get(parent).getPathSegments());
        segments.add(category.getName());
        return get(segments.toArray(new String[segments.size()]));
    }

    public boolean isSame(CategoryPath path) {
        if (path.getPathSegments().size() != this.getPathSegments().size()) {
            return false;
        }
        for (int i = 0; i < getPathSegments().size(); i++) {
            if (!getPathSegments().get(i).equals(path.getPathSegments().get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return String.join(" -> ", pathSegments);
    }
}
