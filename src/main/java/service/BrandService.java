package service;

import model.Brand;
import repository.BrandRepository;
import validation.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class BrandService {
    BrandRepository brandRepository = new BrandRepository();
    Validation validation = new Validation();
    Scanner scanner = new Scanner(System.in);

    public BrandService() throws SQLException {
    }

    public void register() throws SQLException {
        Brand brand = new Brand();
        System.out.println("Enter the name of the brand");
        brand.setNameOfBrand(scanner.next());
        scanner.nextLine();
        System.out.println("Enter the url of your website");
        brand.setWebsite(validation.isValidURL());
        System.out.println("Enter an description for the brand");
        brand.setDescription(scanner.nextLine());
        int result = brandRepository.save(brand);
        if (result != 0) {
            System.out.println("Brand successfully added!!");
        } else {
            System.out.println("There is a problem!!");
        }
    }

    public void remove() throws SQLException {
        System.out.println("Enter the id of the brand that you want to remove");
        int id = scanner.nextInt();
        int result = brandRepository.delete(id);
        if (result != 0) {
            System.out.println("SUCCESSFULLY REMOVED FROM THE DATABASE");
        } else {
            System.out.println("THERE IS A PROBLEM!!");
        }
    }

    public void rewrite() throws SQLException {
        System.out.println("Enter the id of the brand that you want to edit");
        Brand updatedBrand = new Brand();

        int id = scanner.nextInt();
        updatedBrand.setId(id);

        scanner.nextLine();

        System.out.println("Enter the name of the brand");
        updatedBrand.setNameOfBrand(scanner.nextLine());

        System.out.println("Enter URL of the brand");
        updatedBrand.setWebsite(validation.isValidURL());

        System.out.println("Enter description of the website");
        updatedBrand.setDescription(scanner.nextLine());

        try {
            boolean updatedBrandExist = brandRepository.exist(id);
            if (!updatedBrandExist) {
                System.out.println("Brand with ID " + id + " not found.");
                return;
            }
            int result = brandRepository.edit(updatedBrand);
            if (result != 0) {
                System.out.println("Brand with ID " + id + " has been successfully updated.");
            } else {
                System.out.println("There is a problem with updating the brand.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void show() throws SQLException {
        System.out.println("NAME OF BRANDS:");
        brandRepository.showBrands();
    }
}
