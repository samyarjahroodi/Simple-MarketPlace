package service;

import model.ShareHolder;
import repository.ShareHolderRepository;
import validation.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class ShareHolderService {
    private ShareHolderRepository shareHolderRepository;
    Validation validation = new Validation();

    Scanner scanner = new Scanner(System.in);

    public ShareHolderService(ShareHolderRepository shareHolderRepository) throws SQLException {
        this.shareHolderRepository = shareHolderRepository;
    }

    public void register() throws SQLException {
        ShareHolder shareHolder = new ShareHolder();
        System.out.println("Enter the name of the share holder");
        shareHolder.setNameOfShareHolder(scanner.next());
        scanner.nextLine();
        System.out.println("Enter your telephone number");
        shareHolder.setPhoneNumber(validation.telephoneNumberValidation());
        System.out.println("Enter the share holder's national code");
        scanner.nextLine();
        shareHolder.setNationalCode(validation.nationalCodeValidation());
        int result = shareHolderRepository.save(shareHolder);
        if (result != 0) {
            System.out.println("Share holder added successfully!!");
        } else {
            System.out.println("There is a problem!!");
        }
    }

    public void remove() throws SQLException {
        System.out.println("Enter the id of the share holder that you want to remove");
        int id = scanner.nextInt();
        int result = shareHolderRepository.delete(id);
        if (result != 0) {
            System.out.println("SUCCESSFULLY REMOVED FROM THE DATABASE");
        } else {
            System.out.println("THERE IS A PROBLEM!!");
        }
    }


    public void editShareHolder() throws SQLException {

        System.out.println("Enter the ID of the shareholder you want to edit:");
        int shareHolderId = scanner.nextInt();

        ShareHolder updatedShareHolder = new ShareHolder();
        updatedShareHolder.setId(shareHolderId);


        System.out.println("Enter the updated name of the shareholder:");
        updatedShareHolder.setNameOfShareHolder(scanner.next());

        System.out.println("Enter the updated phone number of the shareholder:");
        updatedShareHolder.setPhoneNumber(validation.telephoneNumberValidation());

        System.out.println("Enter the updated national code of the shareholder:");
        updatedShareHolder.setNationalCode(validation.nationalCodeValidation());

        try {

            boolean shareHolderExists = shareHolderRepository.exist(shareHolderId);

            if (!shareHolderExists) {
                System.out.println("Shareholder with ID " + shareHolderId + " not found.");
                return;
            }

            int result = shareHolderRepository.edit(updatedShareHolder);

            if (result != 0) {
                System.out.println("Shareholder with ID " + shareHolderId + " has been successfully updated.");
            } else {
                System.out.println("There was a problem updating the shareholder.");
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

}

