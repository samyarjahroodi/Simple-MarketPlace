package validation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("unused")
public class Validation {
    Scanner input = new Scanner(System.in);

    public String isValidEmail() {
        String email = input.next();
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            System.out.println("EMAIL IS VALID");
            return email;
        } else {
            System.out.println("EMAIL IS NOT VALID");
            System.exit(0);
        }
        return null;
    }


    public String isValidURL() {
        String urlString = input.next();
        try {
            URL url = new URL(urlString);

            if ("http".equals(url.getProtocol()) || "https".equals(url.getProtocol())) {
                System.out.println("URL SUCCESSFULLY ADDED TO THE DATABASE");
            }
        } catch (MalformedURLException e) {
            System.out.println("THERE IS A PROBLEM");
            System.exit(0);
        }
        return null;
    }

    public String isValidPassword() {
        String password;
        String confirmPassword;
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{7,20}$";

        do {
            password = input.next();

            if (!password.matches(regex)) {
                System.out.println("THE PASSWORD IS TOO WEAK!!");
                return null;
            }

            System.out.print("Confirm your password: ");
            confirmPassword = input.next();

            if (!password.equals(confirmPassword)) {
                System.out.println("Passwords do not match. Please try again.");
            }
        } while (!password.equals(confirmPassword));

        System.out.println("Registration successful!");

        return password;
    }

    public String telephoneNumberValidation() {
        String regex = "^(\\+98|0|98)?(9\\d{9}|[1-8]\\d{7})$";
        Pattern pattern = Pattern.compile(regex);
        String telephoneNumber = input.next();
        while (true) {
            System.out.println("Enter your telephone number");
            Matcher matcher = pattern.matcher(telephoneNumber);
            if (matcher.matches()) {
                System.out.println("VALID TELEPHONE NUMBER");
                break;
            } else {
                System.out.println("INVALID TELEPHONE NUMBER!!");
            }
        }
        return telephoneNumber;
    }

    public String nationalCodeValidation() {
        String regex = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regex);
        String nationalCode = input.next();
        Matcher matcher = pattern.matcher(nationalCode);
        while (true) {
            if (matcher.matches()) {
                System.out.println("VALID NATIONAL NUMBER");
                break;
            } else {
                System.out.println("THERE IS PROBLEM!!");
            }
        }
        return nationalCode;
    }


}