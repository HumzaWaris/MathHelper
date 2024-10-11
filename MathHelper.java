import java.util.Scanner;

import static java.lang.Integer.parseInt;

/**
 * A program that prints either the GCD or PF
 * <p>
 * Purdue University -- CS18000 -- Fall 2024 -- Homework 05 -- Challenge
 *
 * @author Humza Waris
 * @version September 17,2024
 */


public class MyMathHelper {

    public static final String WELCOME_MESSAGE = "Welcome to My Math Helper!";
    public static final String MAIN_MENU_ONE = "Please Select an Operation";
    public static final String MAIN_MENU_TWO = "1 - Calculate Greatest Common Denominator";
    public static final String MAIN_MENU_THREE = "2 - Perform Prime Factorization";
    public static final String MAIN_MENU_FOUR = "3 - Exit";
    public static final String GCD_NOTIFICATION = "Ready to Calculate Greatest Common Denominator";
    public static final String PF_NOTIFICATION = "Ready to Perform Prime Factorization";
    public static final String INPUT_ONE = "Please Enter an Integer";
    public static final String INPUT_TWO = "Please Enter a Second Integer";
    public static final String GCD_OUTPUT = "The Greatest Common Denominator is ";
    public static final String PF_OUTPUT = "The Prime Factorization is ";
    public static final String EXIT_MESSAGE = "Thank you for using My Math Helper!";
    public static final String INVALID_MENU_SELECTION = "Invalid selection!";
    public static final String INVALID_INPUT = "Invalid Input - Returning to Main Menu";

    public static boolean check(int n1) {

        int check = 0;
        for (int i = 2; i < n1; i++) {
            if (n1 % i == 0) {
                check++;
            }
        }
        return check == 0;
    }

    public static int gcd(int a, int b) {

        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println(WELCOME_MESSAGE);
        boolean cont = true;
        int n1 = 0;
        int n2 = 0;
        String all = "";
        while (cont == true) {

            System.out.println(MAIN_MENU_ONE);
            System.out.println(MAIN_MENU_TWO);
            System.out.println(MAIN_MENU_THREE);
            System.out.println(MAIN_MENU_FOUR);

            if (s.hasNextInt()) {
                int input = s.nextInt();
                s.nextLine();
                if (input == 1) {
                    System.out.println(GCD_NOTIFICATION);
                    System.out.println(INPUT_ONE);
                    if (s.hasNextInt()) {
                        n1 = s.nextInt();
                        s.nextLine();
                        if (n1 <= 0) {
                            System.out.println(INVALID_INPUT);
                            continue;
                        }
                        System.out.println(INPUT_TWO);
                        if (s.hasNextInt()) {
                            n2 = s.nextInt();
                            s.nextLine();
                            if (n2 <= 0) {
                                System.out.println(INVALID_INPUT);
                                continue;
                            }


                            System.out.println(GCD_OUTPUT + gcd(n1, n2));

                        } else {
                            s.nextLine();
                            System.out.println(INVALID_INPUT);
                        }
                    } else {
                        s.nextLine();
                        System.out.println(INVALID_INPUT);
                    }
                } else if (input == 2) {
                    System.out.println(PF_NOTIFICATION);
                    System.out.println(INPUT_ONE);
                    if (s.hasNextInt()) {
                        n1 = s.nextInt();
                        s.nextLine();
                        if (n1 < 2) {
                            System.out.println(INVALID_INPUT);
                        } else {
                            if (check(n1)) {
                                System.out.println(PF_OUTPUT + n1);
                            } else {
                                String ans = "";
                                int n3 = n1;
                                String finalacc = "";
                                while (!check(n1)) {
                                    for (int i = 2; i < n1; i++) {
                                        if (check(i) && n1 % i == 0) {
                                            ans += i + " x ";
                                            n1 /= i;

                                            i = 1;


                                        }
                                    }
                                }
                                // ans=ans.substring(0,ans.lastIndexOf("x")-1);
                                boolean onlyonce = true;
                                while (!check(n3)) {
                                    for (int i = 2; i < n3; i++) {
                                        if (onlyonce == true && n1 <= i) {
                                            finalacc += n1 + " x ";
                                            onlyonce = false;
                                        }
                                        if (check(i) && n3 % i == 0) {

                                            finalacc += i + " x ";
                                            n3 /= i;

                                            i = 1;


                                        }
                                    }
                                }
                                if (onlyonce == true) {
                                    finalacc += n1;
                                } else {
                                    finalacc = finalacc.substring(0, finalacc.length() - 2);
                                }

                                System.out.println(PF_OUTPUT + finalacc);


                            }


                        }

                    } else {
                        s.nextLine();
                        System.out.println(INVALID_INPUT);
                    }

                } else if (input == 3) {
                    System.out.println(EXIT_MESSAGE);
                    cont = false;
                } else {
                    System.out.println(INVALID_MENU_SELECTION);
                }


            } else {
                s.nextLine();
                System.out.println(INVALID_MENU_SELECTION);
            }


        }
    } // End main
} // End class
