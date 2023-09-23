package service;

import model.ShareHolder;
import repository.ShareHolderRepository;
import validation.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class ShareHolderService {
    ShareHolderRepository shareHolderRepository = new ShareHolderRepository();
    Scanner scanner = new Scanner(System.in);
    Validation validation = new Validation();

    public ShareHolderService() throws SQLException {
    }

    public void register() throws SQLException {
        ShareHolder shareHolder = new ShareHolder();
        System.out.println("Enter the name of the share holder");
        shareHolder.setNameOfShareHolder(scanner.next());
        System.out.println("Enter the share holder's phone number");
        shareHolder.setNameOfShareHolder(validation.telephoneNumberValidation());
        System.out.println("Enter the share holder's national code");
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

    public void rewrite() throws SQLException {
        System.out.println("Enter the id of the brand that you want to edit");
        int id = scanner.nextInt();
        int result = shareHolderRepository.edit(id);
        if (result != 0) {
            System.out.println("SUCCESSFULLY EDITED IN THE DATABASE");
        } else {
            System.out.println("THERE IS A PROBLEM!!");
        }
    }
}
