package database;

import enums.Category;

public final class SantaGift {

    private String productName;
    private Double price;
    private Category category;

    public SantaGift() {
        this.productName = null;
        this.price = null;
        this.category = null;
    }

    public SantaGift(final String productName, final Double price, final Category category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public void setProductName(final String productName) {
        this.productName = productName;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "SantaGift{"
                + "productName='" + productName + '\''
                + ", price=" + price
                + ", category=" + category
                + '}';
    }
}
