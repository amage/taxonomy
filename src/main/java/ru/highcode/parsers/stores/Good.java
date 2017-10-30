package ru.highcode.parsers.stores;

import java.util.ArrayList;
import java.util.List;

public class Good {
    private String article;
    private String url;
    private String title;
    private double price;
    private String description;
    private final List<String> imagesURLs = new ArrayList<>();
    private final List<Category> categories = new ArrayList<>();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getImagesURLs() {
        return imagesURLs;
    }

    @Override
    public String toString() {
        return "Good [article=" + article + "\n url=" + url + ",\n title=" + title + ",\n price=" + price
                + ",\n imagesURLs=" + imagesURLs
                + ",\n description=" + description + "]";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public List<Category> getCategories() {
        return categories;
    }

}
