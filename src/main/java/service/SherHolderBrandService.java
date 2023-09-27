package service;

import model.ShareHolder;
import model.ShareHolderBrand;
import repository.SharHolderBrandRepository;
import validation.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class SherHolderBrandService {
    private SharHolderBrandRepository sharHolderBrandRepository;
    Scanner scanner = new Scanner(System.in);

    public SherHolderBrandService(SharHolderBrandRepository sharHolderBrandRepository) {
        this.sharHolderBrandRepository = sharHolderBrandRepository;
    }


    public void registerShareHolderBrand() throws SQLException {
        ShareHolderBrand shareHolderBrand = new ShareHolderBrand();
        System.out.println("Enter the ID of the share holder:");
        shareHolderBrand.setShareHolderId(scanner.nextInt());

        System.out.println("Enter the ID of the brand:");
        shareHolderBrand.setBrandId(scanner.nextInt());

        int result = sharHolderBrandRepository.save(shareHolderBrand);

        if (result != 0) {
            System.out.println("ShareHolderBrand added successfully!!");
        } else {
            System.out.println("There is a problem!!");
        }
    }

    public void removeShareHolder() throws SQLException {
        System.out.println("Enter the ID of the share holder that you want to remove");
        sharHolderBrandRepository.show();
        int id = scanner.nextInt();
        int result = sharHolderBrandRepository.delete(id);

        if (result != 0) {
            System.out.println("Share holder with ID " + id + " has been successfully removed from the database");
        } else {
            System.out.println("Share holder with ID " + id + " was not found or there was a problem!!");
        }
    }

    public void editShareHolderBrand() throws SQLException {
        System.out.println("Enter the ID of the shareholder-brand association you want to edit:");
        int shareHolderBrandId = scanner.nextInt();
        scanner.nextLine();

        ShareHolderBrand updatedShareHolderBrand = new ShareHolderBrand();
        updatedShareHolderBrand.setId(shareHolderBrandId);

        System.out.println("Enter the updated share holder ID:");
        updatedShareHolderBrand.setShareHolderId(scanner.nextInt());

        System.out.println("Enter the updated brand ID:");
        updatedShareHolderBrand.setBrandId(scanner.nextInt());

        try {
            boolean shareHolderBrandExists = sharHolderBrandRepository.exist(shareHolderBrandId);

            if (!shareHolderBrandExists) {
                System.out.println("Shareholder-brand association with ID " + shareHolderBrandId + " not found.");
                return;
            }

            int result = sharHolderBrandRepository.edit(updatedShareHolderBrand);

            if (result != 0) {
                System.out.println("Shareholder-brand association with ID " + shareHolderBrandId + " has been successfully updated.");
            } else {
                System.out.println("There was a problem updating the shareholder-brand association.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}