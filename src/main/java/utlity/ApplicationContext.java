package utlity;

import connection.JdbcConnection;
import model.ShareHolderBrand;
import repository.*;
import service.*;
import validation.Validation;

import java.sql.Connection;
import java.sql.SQLException;

public class ApplicationContext {
    private static final Connection CONNECTION;
    private static final UsersRepository USERS_REPOSITORY;
    private static UsersService USERS_SERVICE = null;
    private static final BrandRepository BRAND_REPOSITORY;
    private static BrandService BRAND_SERVICE = null;
    private static final CategoriesRepository CATEGORIES_REPOSITORY;
    private static final CategoriesService CATEGORIES_SERVICE;
    private static final ProductRepository PRODUCT_REPOSITORY;
    private static final ProductService PRODUCT_SERVICE;
    private static final ShareHolderRepository SHARE_HOLDER_REPOSITORY;
    private static ShareHolderService SHARE_HOLDER_SERVICE = null;
    private static SharHolderBrandRepository SHAR_HOLDER_BRAND_REPOSITORY ;
    private static final SherHolderBrandService SHER_HOLDER_BRAND_SERVICE;


    static {
        CONNECTION = JdbcConnection.getConnection();
        USERS_REPOSITORY = new UsersRepository(CONNECTION);
        try {
            USERS_SERVICE = new UsersService(USERS_REPOSITORY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BRAND_REPOSITORY = new BrandRepository(CONNECTION);
        try {
            BRAND_SERVICE = new BrandService(BRAND_REPOSITORY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CATEGORIES_REPOSITORY = new CategoriesRepository(CONNECTION);
        CATEGORIES_SERVICE = new CategoriesService(CATEGORIES_REPOSITORY);
        PRODUCT_REPOSITORY = new ProductRepository(CONNECTION);
        PRODUCT_SERVICE = new ProductService(PRODUCT_REPOSITORY);
        SHARE_HOLDER_REPOSITORY = new ShareHolderRepository(CONNECTION);
        try {
            SHARE_HOLDER_SERVICE = new ShareHolderService(SHARE_HOLDER_REPOSITORY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SHAR_HOLDER_BRAND_REPOSITORY = new SharHolderBrandRepository(CONNECTION);
        SHER_HOLDER_BRAND_SERVICE = new SherHolderBrandService(SHAR_HOLDER_BRAND_REPOSITORY);

    }


    public static ShareHolderService getShareHolderService() {
        return SHARE_HOLDER_SERVICE;
    }

    public static SherHolderBrandService getSherHolderBrandService() {
        return SHER_HOLDER_BRAND_SERVICE;
    }

    public static ProductService getProductService() {
        return PRODUCT_SERVICE;
    }

    public static CategoriesService getCategoriesService() {
        return CATEGORIES_SERVICE;
    }

    public static UsersService getUserService() {
        return USERS_SERVICE;
    }

    public static BrandService getBrandService() {
        return BRAND_SERVICE;
    }

}
