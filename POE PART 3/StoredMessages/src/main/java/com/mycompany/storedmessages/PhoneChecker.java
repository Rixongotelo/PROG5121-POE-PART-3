/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storedmessages;

/**
 *
 * @author nseke
 */
import java.util.Scanner;

public class PhoneChecker {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      
      
      //DECLARATIONS
      String UserName;
      String Password;
      String isValidUsername;
      
    //Prompt User To Enter UserName
    System.out.print("Enter Your Username");
    String username = scanner.nextLine();
    
    //Prompt User To Enter Password
    System.out.print("Enter Your Password");
    String password = scanner.nextLine();
    
    if 
    (isValidUsername(username)) {
      System.out.print("Username successfully captured");
  } else  {
      System.out.println("Username is not correctly formatted; please emsure that your username contains an underscore and is no more than five characters in length");
  }
    }
}

public class PhoneChecker {
    public static void main(String[] args) {
        // Test cases
        checkPhoneNumber("+123456789");  // Valid: 9 digits + prefix
        checkPhoneNumber("4412345");     // Valid: 7 digits
        checkPhoneNumber("12345678901"); // Invalid: 11 digits (too long)
        checkPhoneNumber("0123456");     // Invalid: starts with 0
    }

    public static void checkPhoneNumber(String phoneNumber) {
        // Regex Breakdown:
        // ^      : Start of string
        // \\+?   : Optional '+' sign (double backslash is required in Java)
        // [1-9]  : First digit of country code (cannot be 0)
        // \\d{1,9} : Followed by 1 to 9 digits (Total digits: 2 to 10)
        // $      : End of string
        String regex = "^\\+?[1-9]\\d{1,9}$";

        if (phoneNumber.matches(regex)) {
            System.out.println("Input: " + phoneNumber + " -> \"Cell phone number successfully added.\"");
        } else {
            System.out.println("Input: " + phoneNumber + " -> \"Cell phone number incorrectly formatted or does not contain international code.\"");
        }
    }
}

  