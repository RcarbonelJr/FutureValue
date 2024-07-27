/* Author: Randall Carbonel
 * Date: 7/27/24
 * Class: ASD216 - Java Programming
 * Assignment: Add a linked list to the Future Value application. This linked list will store the values for each
 *             calculation that is performed. When the application ends, it should print a summary of those calculations
 *             sorted by future value.
 * Specifications:
 *      - Declare a variable for a linked list that can store FutureValue objects
 *      - Add the calculation to the linked list
 *      - Add code that displays all future value calculations when the user indicates that the application should end
 *      - add code that sorts the calculations by the future value that’s stored in the FutureValue object
 */

import java.util.LinkedList;

public class FutureValueApp {

    public static void main(String[] args) {
        
        // display a welcome message
        System.out.println("Welcome to the Future Value Calculator");
        System.out.println();

        LinkedList<FutureValue> futureValuesList = new LinkedList<>();

        // perform 1 or more calculations
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {

            // get the input from the user
            System.out.println("DATA ENTRY");
            double monthlyInvestment = Console.getDouble(
                "Enter monthly investment: ", 0, 1000);
            double interestRate = Console.getDouble(
                "Enter yearly interest rate: ", 0, 30);
            int years = Console.getInt(
                "Enter number of years: ", 0, 100);
            System.out.println();

            // create FutureValue object
            FutureValue fv = new FutureValue(
                    monthlyInvestment, interestRate, years);

            // print the results
            System.out.println("FORMATTED RESULTS\n" 
              + "Monthly investment:   " + fv.getMonthlyInvestmentFormatted() + "\n"
              + "Yearly interest rate: " + fv.getInterestRateFormatted() + "\n"
              + "Number of years:      " + fv.getYears() + "\n"
              + "Future value:         " + fv.getFutureValueFormatted() + "\n");

            // Add the calculation to the linked list
            futureValuesList.add(fv);

            // see if the user wants to continue
            choice = Console.getString("Continue? (y/n): ");
            System.out.println();
        }

        // Display all future value calculations
        System.out.println("ALL CALCULATIONS");
        for (FutureValue fv : futureValuesList) {
            System.out.println(
                      "Monthly investment:   " + fv.getMonthlyInvestmentFormatted() + "\n"
                    + "Yearly interest rate: " + fv.getInterestRateFormatted() + "\n"
                    + "Number of years:      " + fv.getYears() + "\n"
                    + "Future value:         " + fv.getFutureValueFormatted() + "\n");
        }
    }
}