package fullCode;
import javax.swing.*;
import java.text.NumberFormat;

public class MainClass {


// Declaring the variables for the user input
static float loan;
static int years;
static float interestRate;


  //----------------------------------------------------------------------------------------------------------------//


    public static void main (String [] args) {

        JOptionPane.showMessageDialog(null, "Thank you for using my mortgage calculator :)");
        getInput();
        calculations();
        printResults();

    }


  //----------------------------------------------------------------------------------------------------------------//


    static void getInput() {

        try{

            loan = Float.parseFloat(JOptionPane.showInputDialog("How much do you want to borrow ?"));
            years = Integer.parseInt(JOptionPane.showInputDialog("How many years do you want to spread the payments across ?"));
            interestRate = Float.parseFloat(JOptionPane.showInputDialog("what is your annual interest rate ?"));

        }
        catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Invalid input try again...");

        }

    }


// Declaring the necessary variables for the calculations

    static double monthlyPayments;
    static double totalLoan;


    public static void calculations(){

        float numOfPayments = years * 12;
        float decimalParentInterest = interestRate/100;
        float monthlyInterestRate = decimalParentInterest/12;
        float onePlussInterest = 1 + monthlyInterestRate;


        double numerator = (Math.pow(onePlussInterest, numOfPayments)) * monthlyInterestRate;
        double denomerator = (numerator - 1);


        monthlyPayments = loan * (numerator/denomerator);
        totalLoan = monthlyPayments * 12 ;
    }


    public static void printResults() {


        NumberFormat initLoan = NumberFormat.getCurrencyInstance();

        String loanFormat =  initLoan.format(loan);
        String monthlyPaymentsFormat = initLoan.format(monthlyPayments);
        String totalLoanFormat = initLoan.format(totalLoan);

        String paymentStats = "Loan amount : "+ loanFormat +"\n" + "Interest rate : " + interestRate + "\n\n" + "Monthly payments : " + monthlyPaymentsFormat + "\n" + "Total loan payment : " + totalLoanFormat ;
        JOptionPane.showMessageDialog(null, "Borrowing " + loanFormat + " With an " + interestRate + " % interest rate wil give you : \n\n" + paymentStats);


    }


}
