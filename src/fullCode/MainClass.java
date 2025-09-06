package fullCode;
import javax.swing.*;

public class MainClass {


// Declaring the variables for the user input
static float loanTotal;
static int years;
static float interestRate;



    public static void main (String [] args) {

        JOptionPane.showMessageDialog(null, "Thank you for using my mortgage calculator :)");
        getInput();


    }


  //----------------------------------------------------------------------------------------------------------------//


    static void getInput() {

        try{

            loanTotal = Float.parseFloat(JOptionPane.showInputDialog("How much do you want to borrow ?"));
            years = Integer.parseInt(JOptionPane.showInputDialog("How many years do you want to spread the payments across ?"));
            interestRate = Float.parseFloat(JOptionPane.showInputDialog("what is your annual interest rate ?"));

        }
        catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Invalid input try again...");

        }

    }


// Declaring the necessary variables for the calculations
static int numOfPayments = years * 12;
static float decimalParentInterest = interestRate/100;
static float monthlyInterestRate = decimalParentInterest/12;



    public static void calculations(){




    }


}
