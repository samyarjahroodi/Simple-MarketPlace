package model;

public class ShareHolderBrand {
    private ShareHolder shareHolder;
    private Brand brand;

    public ShareHolderBrand() {
    }

    public ShareHolderBrand(ShareHolder shareHolder, Brand brand) {
        this.shareHolder = shareHolder;
        this.brand = brand;
    }

    public ShareHolder getShareHolder() {
        return shareHolder;
    }

    public void setShareHolder(ShareHolder shareHolder) {
        this.shareHolder = shareHolder;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
