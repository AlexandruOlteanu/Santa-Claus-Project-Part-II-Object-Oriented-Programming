package database;

import enums.Category;

public final class SantaGift {

    private String productName;
    private Double price;
    private Category category;
    private Integer quantity;

    public SantaGift() {
        this.productName = null;
        this.price = null;
        this.category = null;
        this.quantity = null;
    }

    public SantaGift(final String productName, final Double price, final Category category,
                     final Integer quantity) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
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

    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return Returneaza cantitatea valabila din tipul de cadou curent
     */
    public Integer quantity() {
        return quantity;
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
