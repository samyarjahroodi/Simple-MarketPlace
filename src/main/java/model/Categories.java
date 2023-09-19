package model;

public class Categories {
    private Integer id;
    private String nameOfCategories;
    private String description;

    public Categories(Integer id,
                      String nameOfCategories, String description) {
        this.id = id;
        this.nameOfCategories = nameOfCategories;
        this.description = description;
    }

    public Categories() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfCategories() {
        return nameOfCategories;
    }

    public void setNameOfCategories(String nameOfCategories) {
        this.nameOfCategories = nameOfCategories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
