package model;

public class ShareHolderBrand {
    private int shareHolderId;
    private int brandId;

    public ShareHolderBrand(int shareHolderId, int brandId) {
        this.shareHolderId = shareHolderId;
        this.brandId = brandId;
    }

    public ShareHolderBrand() {
    }

    public int getShareHolderId() {
        return shareHolderId;
    }

    public void setShareHolderId(int shareHolderId) {
        this.shareHolderId = shareHolderId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }
}