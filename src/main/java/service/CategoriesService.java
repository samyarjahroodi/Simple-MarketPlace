package service;

import model.Categories;
import model.ShareHolder;
import repository.CategoriesRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class CategoriesService {
    CategoriesRepository categoriesRepository = new CategoriesRepository();
    Scanner scanner = new Scanner(System.in);

    public CategoriesService() throws SQLException {
    }

    public void register() throws SQLException {
        Categories categories = new Categories();
        System.out.println("Enter the name of the category");
        categories.setNameOfCategories(scanner.next());
        System.out.println("Enter a description for the category");
        categories.setDescription(scanner.next());
        int result = categoriesRepository.add();
        if (result != 0) {
            System.out.println("Categories successfully added");
        } else {
            System.out.println("There is a problem!!");
        }
    }

    public void remove() throws SQLException {
        System.out.println("Enter the id you want to remove");
        int id = scanner.nextInt();
        int result = categoriesRepository.delete(id);
        if (result != 0) {
            System.out.println("SUCCESSFULLY REMOVED FROM THE DATABASE");
        } else {
            System.out.println("THERE IS A PROBLEM!!");
        }
    }

    public void editCategories() throws SQLException {

        System.out.println("Enter the ID of the shareholder you want to edit:");
        int categoriesId = scanner.nextInt();

        Categories updatedCategories = new Categories();
        updatedCategories.setId(categoriesId);

        scanner.nextLine();

        System.out.println("Enter the updated name of the category:");
        updatedCategories.setNameOfCategories(scanner.nextLine());

        System.out.println("Enter the updated description of the categories:");
        updatedCategories.setDescription(scanner.nextLine());


        try {

            boolean categoryExists = categoriesRepository.exist(categoriesId);

            if (!categoryExists) {
                System.out.println("category with ID " + categoriesId + " not found.");
                return;
            }

            int result = categoriesRepository.edit(updatedCategories);

            if (result != 0) {
                System.out.println("Category with ID " + categoriesId + " has been successfully updated.");
            } else {
                System.out.println("There was a problem updating the category.");
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    public void show() throws SQLException {
        categoriesRepository.show();
    }
}

