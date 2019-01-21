package ru.highcode.taxonomy.utils;

import ru.highcode.taxonomy.Category;

import java.util.ArrayList;
import java.util.Arrays;
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
        result.pathSegments.addAll(Arrays.asList(segments));
        return result;
    }

    public static CategoryPath get(Category category) {
        // TODO: rewrite
        if (category.isRoot()) {
            return get(category.getId());
        }

        final ArrayList<String> segments = new ArrayList<>(CategoryPath.get(category.getParents().get(0)).getPathSegments());
        segments.add(category.getId());
        return get(segments.toArray(new String[0]));
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
