package userauthprogpoe;

import java.util.Scanner;

public class UserAuthProgPoe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = input.nextLine().trim();

        System.out.print("Enter your last name: ");
        String lastName = input.nextLine().trim();

        System.out.print("Create a username: ");
        String username = input.nextLine().trim();

        System.out.print("Create a password: ");
        String password = input.nextLine().trim();

        System.out.print("Enter your cell phone number : ");
        String cellPhone = input.nextLine().trim();

        Login login = new Login(username, password, cellPhone, firstName, lastName);

        System.out.println(login.registerUser());

        System.out.println("\nPlease log in:");
        System.out.print("Enter username: ");
        String loginUsername = input.nextLine().trim();

        System.out.print("Enter password: ");
        String loginPassword = input.nextLine().trim();

        System.out.println(login.returnLoginStatus(loginUsername, loginPassword));
    }
}
