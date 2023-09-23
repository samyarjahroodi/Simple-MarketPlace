package model;

public class Product {
    private Integer id;
    private String nameOfProduct;
    private String createDate;
    private int categoriesId;
    private int brandId;

    public Product() {
    }

    public Product(Integer id,
                   String nameOfProduct, String createDate, int categoriesId, int brandId) {
        this.id = id;
        this.nameOfProduct = nameOfProduct;
        this.createDate = createDate;
        this.categoriesId = categoriesId;
        this.brandId = brandId;
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

    public int getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(int categoriesId) {
        this.categoriesId = categoriesId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }
}