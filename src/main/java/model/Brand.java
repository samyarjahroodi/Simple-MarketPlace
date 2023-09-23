package model;

@SuppressWarnings("unused")
public class Brand {
    private Integer id;
    private String nameOfBrand;
    private String website;
    private String description;
    private ShareHolder[] shareHolders;

    public Brand(Integer id, String nameOfBrand
            , String website, String description, ShareHolder[] shareHolders) {
        this.id = id;
        this.nameOfBrand = nameOfBrand;
        this.website = website;
        this.description = description;
        this.shareHolders = shareHolders;
    }

    public Brand() {
    }

    public ShareHolder[] getShareHolders() {
        return shareHolders;
    }

    public void setShareHolders(ShareHolder[] shareHolders) {
        this.shareHolders = shareHolders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfBrand() {
        return nameOfBrand;
    }

    public void setNameOfBrand(String nameOfBrand) {
        this.nameOfBrand = nameOfBrand;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}