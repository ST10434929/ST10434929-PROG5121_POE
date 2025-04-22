package userauthprogpoe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
    private String username;
    private String password;
    private String cellPhone;
    private String firstName;
    private String lastName;

    public Login(String username, String password, String cellPhone, String firstName, String lastName) {
        this.username = username.trim();
        this.password = password.trim();
        this.cellPhone = cellPhone.trim();
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
    }

    // To see if username is valid
    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    // To see if password is valid
    public boolean checkPasswordComplexity() {
        String pattern = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!£*()_])[A-Za-z0-9@#$%^&+=!£*()_]{8,}$";
        return password.matches(pattern);
    }

    // To see if phone number is valid
    public boolean checkCellPhoneNumber() {
        String pattern = "^\\+27\\d{9}$"; // +27 and 9 digits
        return cellPhone.matches(pattern);
    }

    // Registration messages
    public String registerUser() {
        StringBuilder result = new StringBuilder();

        if (checkUserName()) {
            result.append("Username successfully captured.\n");
        } else {
            result.append("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.\n");
        }

        if (checkPasswordComplexity()) {
            result.append("Password successfully captured.\n");
        } else {
            result.append("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.\n");
        }

        if (checkCellPhoneNumber()) {
            result.append("Cell phone number successfully added.");
        } else {
            result.append("Cell phone number incorrectly formatted or does not contain international code.");
        }

        return result.toString();
    }

    // Login credentials
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername.trim()) && this.password.equals(enteredPassword.trim());
    }

    // Return login message
    public String returnLoginStatus(String enteredUsername, String enteredPassword) {
        if (loginUser(enteredUsername, enteredPassword)) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
