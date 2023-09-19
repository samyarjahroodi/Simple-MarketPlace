package model;

public class Brand {
    private Integer id;
    private String nameOfShareHolder;
    private String phoneNumber;
    private String nationalCode;
    private String description;

    public Brand() {
    }

    public Brand(Integer id, String nameOfShareHolder,
                 String phoneNumber, String nationalCode, String description) {
        this.id = id;
        this.nameOfShareHolder = nameOfShareHolder;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfShareHolder() {
        return nameOfShareHolder;
    }

    public void setNameOfShareHolder(String nameOfShareHolder) {
        this.nameOfShareHolder = nameOfShareHolder;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
