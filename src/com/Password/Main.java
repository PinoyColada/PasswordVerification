package com.Password;

	/*
Author:Ryan Hatamosa
This program is a mock-up log in for Amazon.com and validates the password on certain criterias based on what the user inputs.
The code starts off by asking the user to enter a *username, and once they do that comes the part where they have to confirm their identity by inputting a *password.
Now this *password needs to follow the 4 criterias in order for it to be valid, 1. at least six characters long 2. at least one uppercase letter 3. at least one lowercase letter and 4. should have at least one digit.
To verify if what the user has inputted is valid or not, the *password will go through nested while-loops and will search if it doesn't contain the criterias.
Booleans ***validOne & ***validTwo are started off to equal false and through-out the while loops if the password does contain a criteria such as at least 6 characters ***(password.length()), ***validOne will
turn true and continue to the next while loop. If the **conditions are false, the user will be told to re-enter the password and start the while loop all over again. So if the user bypasses the first while loop,
(enters 6 or more strings) and fails to enter at least a lower case letter **(toLowerCase) or upper case letter **(toUpperCase) , the user will be asked to re-enter a password again and that will trihger the **validOne to turn false returning to the
first while loop. **If all conditions are true and met, the user will be told that his/her password is valid and the program ends.

*Inputs- username,password
**Outputs- if conditions are true, if conditions are false
***Processing- password.length,passwordmatches(".*\\d.*"),password.matches("[0-9]+"),password.toLowerCase,password.toUpperCase,validOne,validTwo



*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("AMAZON LOG IN");
        System.out.println("----------------");
        System.out.println("Please enter your username!");
        String username = input.nextLine(); // prompts user to enter username
        System.out.println("Hello " + username + "!, please confirm your identity by putting in your password!");
        System.out.println("A reminder: Your password should be at least six characters long, containing at least one uppercase & at least one lowercase letter and should have at least one digit.");
        String password = input.nextLine(); // prompts user to enter password
        // password.trim();


        boolean validOne = false; // will turn true if password passes 1st criteria
        boolean validTwo = false; // will turn true if password passes 2nd criteria
        boolean valid = false; // will turn true if user wants to enter another password


        //nested while loops

        while (validOne == false) //first while loop verifies if password has 6 characters or more
        {
            if (password.length() < 6) {
                System.out.println("Error! Your password does not meet the criteria(s)! You must have at least six characters! Please re-enter a valid password.");
                password = input.nextLine();
            } else {
                System.out.println("Your password meets the number of characters needed.");
                validOne = !validOne; // turns boolean validOne True
            }
            while (validOne == true)  //second while loop verifies if the password contains
            {
                if (password.matches("[0-9]+")) { // just in case the user enters 6 or more digits
                    System.out.println("Error! Your password is all digits! You must have at least an upper case letter and lowercase letter.");
                    password = input.nextLine();
                    validOne = false; // resets to first while loop if there's no letters
                } else if (password.equals(password.toLowerCase())) {
                    System.out.println("Error! Your password does not meet the criteria(s)! You must have at least an upper case letter! Please re-enter a valid password");
                    password = input.nextLine();
                    validOne = false; // resets to first while loop if there's no Uppercase
                } else if (password.equals(password.toUpperCase())) {
                    System.out.println("Error! Your password does not meet the criteria(s)! You must have at least a lower case letter! Please re-enter a valid password");
                    password = input.nextLine();
                    validOne = false; // resets to first while loop if there's no Lowercase
                } else {
                    System.out.println("Your password meets the number of Upper case and lower case letters needed");
                    validTwo = !validTwo;
                }
                while (validOne == true && validTwo == true) //third while loop verifies if the password contains a digit.
                {
                    if (password.matches(".*\\d.*")) // formula to detect digits in string
                    {
                        System.out.println("Your password meets the number of digits needed");
                        System.out.println("-----------------");
                        System.out.println(username + ", your password is valid and has met all criterias"); // All criterias for the password has been met.

                        System.out.println("Would you like to change your password? (Y or N) Note: You will need to re-enter a username if you would like to change it.");
                        // prompts user to type in Y or N if he/she wants to change password
                        // char ans = input.next().charAt(0);

                        // while loop process based on users input to rerun the code or not

                        while (!valid) {
                            char ans = input.next().charAt(0);

                            if (ans == 'y' || ans == 'Y') {
                                Main.main(args);
                            } else if (ans == 'n' || ans == 'N') {
                                System.out.println("Program is now terminating...");
                                input.close(); // Closes scanner
                                System.exit(0); // Exits the nested while loops & closes out the program.
                            } else if ((ans != 'y' || ans != 'Y') && (ans != 'n' || ans != 'N')) {
                                System.out.println("Invalid input, please type in 'Y' for Yes or 'N' for No");
                            }
                        }

                    } else {
                        System.out.println("Error! Your password does not meet the criteria(s)! You must have at one digit! Please re-enter a valid password");
                        password = input.nextLine();
                        validOne = false;
                        validTwo = false; // both booleans turns into false and resets to first while loop
                    }
                }
            }
        }
    }
}

