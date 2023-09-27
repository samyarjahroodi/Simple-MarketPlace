package service;

import model.Product;
import repository.ProductRepository;

import java.sql.SQLException;
import java.util.Scanner;

@SuppressWarnings("unused")
public class ProductService {
    Scanner scanner = new Scanner(System.in);

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductService() throws SQLException {
    }

    public void register() throws SQLException {
        Product product = new Product();
        System.out.println("Enter the name of the product");
        product.setNameOfProduct(scanner.next());
        System.out.println("Enter the created date");
        product.setCreateDate(scanner.next());
        System.out.println("Enter the categories id");
        product.setCategoriesId(scanner.nextInt());
        System.out.println("Enter the brand id");
        product.setBrandId(scanner.nextInt());
        int result = productRepository.save(product);
        if (result != 0) {
            System.out.println(" successfully added!!");
        } else {
            System.out.println("There is a problem!!");
        }
    }

    public void remove() throws SQLException {
        System.out.println("Enter the id of the product that you want to remove");
        int id = scanner.nextInt();
        int result = productRepository.delete(id);
        if (result != 0) {
            System.out.println("SUCCESSFULLY REMOVED FROM THE DATABASE");
        } else {
            System.out.println("THERE IS A PROBLEM!!");
        }
    }

    public void rewrite() throws SQLException {
        System.out.println("Enter the id of the product that you want to edit");
        int id = scanner.nextInt();
        Product updatedProduct = new Product();
        updatedProduct.setId(id);
        System.out.println("Enter the name of the product!!");
        updatedProduct.setNameOfProduct(scanner.next());
        System.out.println("Enter created date!!");
        updatedProduct.setCreateDate(scanner.next());
        System.out.println("Enter category id");
        updatedProduct.setCategoriesId(scanner.nextInt());
        System.out.println("Enter brand id");
        updatedProduct.setBrandId(scanner.nextInt());
        try {
            boolean productExists = productRepository.exist(id);
            if (!productExists) {
                System.out.println("Product with id " + updatedProduct.getId() + " not found");
                return;
            }
            int result = productRepository.edit(updatedProduct);
            if (result != 0) {
                System.out.println("Product with ID " + id + " has been successfully updated.");
            } else {
                System.out.println("There was a problem with updating the shareholder");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
