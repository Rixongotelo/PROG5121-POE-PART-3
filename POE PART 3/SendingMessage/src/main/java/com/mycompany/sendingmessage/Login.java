/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sendingmessage;

/**
 *
 * @author nseke
 */
public class Login {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // DECLARATIONS
        String phoneNumber;

        // USERNAME
        System.out.print("Enter Your Username: "); // ✅ FIXED (added spacing/colon)
        String username = scanner.nextLine();

        if (checkUsername(username)) { // ✅ FIXED (method name lowercase)
            System.out.println("Username successfully captured"); // ✅ FIXED (println)
        } else {
            System.out.println("Username must contain '_' and be no more than 5 characters"); // ✅ FIXED (clean message)
        }

        // PASSWORD
        System.out.print("Enter Your Password: "); // ✅ FIXED
        String password = scanner.nextLine();

        if (checkPassword(password)) { // ✅ FIXED (correct method name)
            System.out.println("Password successfully captured"); // ✅ FIXED (correct message)
        } else {
            System.out.println("Password must be at least 8 characters, include a capital letter, number, and special character");
        }

        // PHONE NUMBER
        System.out.print("Enter Phone Number (+27...): "); // ✅ FIXED (added input)
        phoneNumber = scanner.nextLine(); // ✅ FIXED (was never assigned)

        if (checkPhoneNumber(phoneNumber)) { // ✅ FIXED (correct method name)
            System.out.println("Cell phone number successfully added");
        } else {
            System.out.println("Cell phone number incorrectly formatted");
        }

        // LOGIN LOOP
        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.print("Enter username: ");
            String inputUser = scanner.nextLine();

            System.out.print("Enter password: ");
            String inputPass = scanner.nextLine();

            if (inputUser.equals(username) && inputPass.equals(password)) { // ✅ FIXED (proper login check)
                System.out.println("Welcome " + username + " It's great to see you again"); // ✅ FIXED (username variable)
                loggedIn = true; // ✅ FIXED (break loop)
            } else {
                System.out.println("Username or password incorrect, please try again");
            }
        }

        scanner.close(); // ✅ FIXED (was input.close())
    }

    // USERNAME VALIDATION
    public static boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // PASSWORD VALIDATION
    public static boolean checkPassword(String password) { // ✅ FIXED (parameter name)
        if (password.length() < 8) { // ✅ FIXED
            return false;
        }

        boolean hasUpper = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i); // ✅ FIXED (charAt, not charAT)

            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(ch)) { // ✅ FIXED (correct special char check)
                hasSpecial = true;
            }
        }

        return hasUpper && hasNumber && hasSpecial;
    }

    // PHONE NUMBER VALIDATION
    public static boolean checkPhoneNumber(String phone) {
        if (phone.startsWith("+27") && phone.length() == 12) {

            for (int i = 3; i < phone.length(); i++) {
                if (!Character.isDigit(phone.charAt(i))) { // ✅ FIXED (added proper check)
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
}
