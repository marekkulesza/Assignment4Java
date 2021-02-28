package Assignment4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        List<SlotMachine> slotMachineList = new ArrayList<>();

        SlotMachine Yeet1 = new SlotMachine(new String[]{"YEET", "DOG", "WOOF", "BORK", "BAH"},4);
        SlotMachine Yeet2 = new SlotMachine(new String[]{"7", "Cherries", "Bar", "King", "Bob"},4);

        slotMachineList.add(Yeet1);
        slotMachineList.add(Yeet2);

        System.out.println("Choose a SlotMachine, they have different names but are all the same inside :) ");
        System.out.println("1, 2, or 1");

        int choice = sc.nextInt();

        while (!(choice >= 1 && choice <= 2)) {
            System.err.println("Please enter a number between 1 to 2");
            int choiceAgain = sc.nextInt();
            if (choiceAgain >= 1 && choiceAgain <= 2) {
                choice = choiceAgain;
                break;
            }
        }

        // I didn't like this part but I wanted to copy your example output
        if (choice == 1) {
            Yeet1.rollers();
            System.out.println(Yeet1);
        }

        if (choice == 2) {
            Yeet2.rollers();
            System.out.println(Yeet2);
        }

        // Flag to break out of the loop
        int quit = 0;

        // Main Loop
        while (quit == 0) {
            System.out.println("1 = spin, 2 = lotta spins, 3 = no more spins");
            int decisionChoice = sc.nextInt();

            while (!(decisionChoice >= 1 && decisionChoice <= 3)) {
                System.err.println("Please enter a number between 1 to 3: 1 = spin, 2 = lotta spins, 3 = no more spins ");
                int decisionChoiceAgain = sc.nextInt();
                if (decisionChoiceAgain >= 1 && decisionChoiceAgain <= 3) {
                    decisionChoice = decisionChoiceAgain;
                    break;
                }
            }

            // Roll the wheels on the slot machine
            if (decisionChoice == 1) {
                slotMachineList.get(choice).rollers();
                System.out.println(slotMachineList.get(choice));
            }

            // Calculate the occurrences
            if (decisionChoice == 2) {
                System.out.println("Payout Occurrence");
                slotMachineList.get(choice).payouts();
            }

            // Quit the program
            if (decisionChoice == 3) {
                System.out.println("Bye now");
                quit = 1;
            }

        }






    }
}
