package menu;

//import applcationContext.ApplocationContext;

import model.Categories;
import model.ShareHolder;
import repository.CategoriesRepository;
import repository.ProductRepository;
import repository.ShareHolderRepository;
import repository.UsersRepository;
import service.*;
import validation.Validation;

import java.sql.SQLException;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Menu {

    Scanner scanner = new Scanner(System.in);
    UsersService usersService = new UsersService();
    BrandService brandService = new BrandService();
    CategoriesService categoriesService = new CategoriesService();
    ProductService productService = new ProductService();
    Validation validation = new Validation();
    ShareHolderService shareHolderService = new ShareHolderService();

    public Menu() throws SQLException {
    }


    public void menu() throws SQLException {
        System.out.println("First you need to login or register");
        while (true) {
            System.out.println("1- Login");
            System.out.println("2- Register");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    usersService.login();
                    break;
                case 2:
                    usersService.register();
                    break;
                default: {
                    System.out.println("Invalid choice. Please either 1 (Login) or 2 (Register).");
                    continue;
                }
            }
            break;

        }
        while (true) {
            System.out.println();
            System.out.println("MANAGEMENT DASHBOARD SYSTEM");
            System.out.println("1- Brands");
            System.out.println("2- Share holders");
            System.out.println("3- Categories");
            System.out.println("4- Product");
            System.out.println("5- If you want to quite press 5");
            System.out.println();
            System.out.println("********************************************************************************************************");
            System.out.println("************************************ Developed by Samyar Jahroodi **************************************");
            System.out.println("********************************************************************************************************");
            int choices = scanner.nextInt();
            switch (choices) {
                case 1:
                    System.out.println("1- Add a new brand");
                    System.out.println("2- Delete a brand base on id");
                    System.out.println("3- Edit a brand base on id");
                    int choice1 = scanner.nextInt();
                    if (choice1 == 1) {
                        brandService.register();
                        break;
                    } else if (choice1 == 2) {
                        brandService.remove();
                        break;
                    } else if (choice1 == 3) {
                        brandService.rewrite();
                        break;
                    }
                case 2:
                    System.out.println("1- Add a new share holder");
                    System.out.println("2- Delete a share holder base on id");
                    System.out.println("3- Edit a share holder base on id");
                    int choice4 = scanner.nextInt();
                    if (choice4 == 1) {
                        shareHolderService.register();
                        break;
                    } else if (choice4 == 2) {
                        shareHolderService.remove();
                        break;
                    } else if (choice4 == 3) {
                        shareHolderService.editShareHolder();
                        break;
                    }
                case 3:
                    System.out.println("1- Add a new category");
                    System.out.println("2- Delete a category base on id");
                    System.out.println("3- Edit a category base on id");
                    int choice2 = scanner.nextInt();
                    if (choice2 == 1) {
                        categoriesService.register();
                        break;
                    } else if (choice2 == 2) {
                        categoriesService.remove();
                        break;
                    } else if (choice2 == 3) {
                        categoriesService.editCategories();
                        break;
                    }
                case 4:
                    System.out.println("1- Add a new product");
                    System.out.println("2- Delete a product base on id");
                    System.out.println("3- Edit a product base on id");
                    int choice3 = scanner.nextInt();
                    if (choice3 == 1) {
                        brandService.show();
                        categoriesService.show();
                        productService.register();
                        break;
                    } else if (choice3 == 2) {
                        productService.remove();
                        break;
                    } else if (choice3 == 3) {
                        productService.rewrite();
                        break;
                    }
                case 5:
                    if (choices == 5) {
                        System.out.println("Getting out of management system");
                        System.exit(0);
                    }
            }
        }
    }
}

