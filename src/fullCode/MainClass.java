package fullCode;
import javax.swing.*;
import java.text.NumberFormat;

public class MainClass {


  //----------------------------------------------------------------------------------------------------------------//

    public static void main (String [] args) {

        welcomeMessage();
        getInput();
        calculations();
        printResults();
        thankYouMessage();

    }

  //----------------------------------------------------------------------------------------------------------------//


// Prints a hello message
    static void welcomeMessage(){

        JOptionPane.showMessageDialog(null, "Thank you for using my mortgage calculator :)");

    }



// Declaring the variables for the user input
static float loan;
static int years;
static float interestRate;


// Gets the input values and stores them in the variables
    static void getInput() {

        try{

            loan = Float.parseFloat(JOptionPane.showInputDialog("How much do you want to borrow ?"));
            years = Integer.parseInt(JOptionPane.showInputDialog("How many years do you want to spread the payments across ?"));
            interestRate = Float.parseFloat(JOptionPane.showInputDialog("what is your annual interest rate ?"));

        }
        catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Invalid input try again...");
            System.exit(0);
        }

    }


// Declaring the necessary variables for the calculations

    static double monthlyPayments;
    static double totalLoan;


// does the calculations for the mortgage payments
    public static void calculations(){

        float numOfPayments = years * 12;
        float decimalParentInterest = interestRate/100;
        float monthlyInterestRate = decimalParentInterest/12;
        float onePlussInterest = 1 + monthlyInterestRate;


        double numerator = (Math.pow(onePlussInterest, numOfPayments)) * monthlyInterestRate;
        double denomerator = (Math.pow(onePlussInterest, numOfPayments)) - 1;


        monthlyPayments = loan * (numerator/denomerator);
        totalLoan = monthlyPayments * numOfPayments ;
    }


// Prints and formats the values
    public static void printResults() {


        NumberFormat initLoan = NumberFormat.getCurrencyInstance();

        String loanFormat =  initLoan.format(loan);
        String monthlyPaymentsFormat = initLoan.format(monthlyPayments);
        String totalLoanFormat = initLoan.format(totalLoan);

        String paymentStats = "Initial loan amount : "+ loanFormat +"\n" + "Annual interest rate : " + interestRate +" %"+ "\n\n" + "Monthly payments : " + monthlyPaymentsFormat + "\n" + "Total loan cost : " + totalLoanFormat ;
        JOptionPane.showMessageDialog(null, "Borrowing " + loanFormat + " with an " + interestRate + " % interest rate over " + years + " years, will give you : \n\n" + paymentStats);


    }

    public static void thankYouMessage (){

        JOptionPane.showMessageDialog(null, "Have a good day !");

    }

}
