package model;

public class ShareHolderBrand {
    private int shareHolderId;
    private int brandId;
    private int id;

    public ShareHolderBrand(int shareHolderId, int brandId, int id) {
        this.shareHolderId = shareHolderId;
        this.brandId = brandId;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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