package model;

public class Product {
    private Integer id;
    private String nameOfProduct;
    private String createDate;
    private Categories categories;
    private Brand brand;

    public Product(Integer id, String nameOfProduct, String createDate,
                   Categories categories, Brand brand) {
        this.id = id;
        this.nameOfProduct = nameOfProduct;
        this.createDate = createDate;
        this.categories = categories;
        this.brand = brand;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
