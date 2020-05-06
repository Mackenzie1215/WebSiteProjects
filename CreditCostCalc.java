import java.util.Scanner;

public class CreditCostCalc {

    public static void main(String args[]) {


//calc method to take user chosen college and credit ammounts and calculate a total price
    public static void calc(int choice, double x, double y) { 


//Initialize variable c to collect cost amount
        double c;


//Using a Switch and Case Statments too program different colleges credit costs
        switch (choice) {





//Pennsylvannia college of technology
            case 1:
                c = x*558 + y*45;
                System.out.print("\nPenn College will cost about " + c);
    System.out.print(" For " + x);
    System.out.print(" Class Credits and " +y);
    System.out.print(" Lab Credits\n");
                break;

//Lincoln Tech
            case 2:
                c = x*310 + y*50;
                System.out.print("\nLincoln Tech will cost about " + c);
    System.out.print(" For " + x);
    System.out.print(" Class Credits and " +y);
    System.out.print(" Lab Credits\n");
                break;

//Lycoming College
            case 3:
                c = x*1230 + y*200;
                System.out.print("\nLycoming College Will cost about " + c);
    System.out.print(" For " + x);
    System.out.print(" Class Credits and " +y);
    System.out.print(" Lab Credits\n");
                break;

//Bloomsburg College
            case 4:
                c = x*322 + y*50;
                System.out.print("\nBloomsburg College Will Cost about " + c  );
    System.out.print(" For " + x);
    System.out.print(" Class Credits and " +y);
    System.out.print(" Lab Credits\n");
                break;

//Penn State University
            case 5:
                c = x*555 + y*4;
                System.out.print("\nPenn State Will Cost about " + c  );
    System.out.print(" For " + x);
    System.out.print(" Class Credits and " +y);
    System.out.print(" Lab Credits\n");
                break;

//Lockhaven University
            case 6:
                c = x*322 + y*3;
                System.out.print("\nLock Haven University Will Cost about " + c  );
    System.out.print(" For " + x);
    System.out.print(" Class Credits and " +y);
    System.out.print(" Lab Credits\n");
                break;

//Bucknell University
            case 7:
                c = x*1859 + y*304;
                System.out.print("\nBucknell University Will Cost about " + c  );
    System.out.print(" For " + x);
    System.out.print(" Class Credits and " +y);
    System.out.print(" Lab Credits\n");
                break;

//East Stroudsburg University
            case 9:
                c = x*516 + y*35;
                System.out.print("\n East Stroudsburg University Will Cost about " + c  );
    System.out.print(" For " + x);
    System.out.print(" Class Credits and " +y);
    System.out.print(" Lab Credits\n");
                break;

//Harvard College
            case 8:
                c = x*2126 + y*500;
                System.out.print("\nHarvard Law School Will Cost about " + c  );
    System.out.print(" For " + x);
    System.out.print(" Class Credits and " +y);
    System.out.print(" Lab Credits\n");
                break;

//Northampton Community college
            case 0:
                c = x*300 + y*50;
                System.out.print("\nNorthhampton Community college Will Cost about " + c  );
    System.out.print(" For " + x);
    System.out.print(" Class Credits and " +y);
    System.out.print(" Lab Credits\n");
                break;
        }

//Initialize Variables
        double firstnumber, secondnumber;
        int choice;

//Print Statements to show options to user
        System.out.println(" ---------------------------------------------------- \n Credit Calculator : Mackenzie Hagerty \n----------------------------------------------------\nTHIS CALCULATOR ONLY CALCULATES COST OF CREDITS");
        System.out.println("\n1- Penn College   2- Lincoln Tech      3- Lycoming");
        System.out.println("4- Bloomsburg     5- Penn State        6- Lock Haven ");
        System.out.println("7- Bucknell       8- Harvard Law       9- East Stroudsburg");
        System.out.println("                  0- Northhampton");
        System.out.print(" \nChoose a College you would like to estimate ");

//Initialize Scanner to catch system input
        Scanner var = new Scanner(System.in);

//Grab our first number from user choosing which college to calculate
        choice = var.nextInt();

//Grab our second number for the amount of class credits being calculated
        System.out.print(" Enter Class Credit Amount ");
        firstnumber = var.nextDouble();

//Grab our third number for the amount of lab credits being calculated
        System.out.print(" Enter Lab Credit Amount ");
        secondnumber = var.nextDouble();

//Run The Calc Algorithm
        calc(choice, firstnumber, secondnumber); 
    }

    }

}