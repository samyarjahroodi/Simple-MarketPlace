package service;

import model.Categories;
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

    public void rewrite() throws SQLException {
        System.out.println("Enter the id of the category that you want to edit");
        int id = scanner.nextInt();
        int result = categoriesRepository.edit(id);
        if (result != 0) {
            System.out.println("SUCCESSFULLY EDITED IN THE DATABASE");
        } else {
            System.out.println("THERE IS A PROBLEM!!");
        }
    }
}

