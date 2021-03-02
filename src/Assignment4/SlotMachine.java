package Assignment4;

import java.util.ArrayList;
import java.util.List;


/**
 * This is our 4th assignment SlotMachine Object
 * get 2 of the same faces and get 1 point
 * 3 faces in a row for 2 points
 * 4 faces in a row for 3 points
 * Created Feb 28th, 2021
 *
 * @author Marek Kulesza
 */
public class SlotMachine {

    /**
     * a List of winning faces as Strings
     */
    private final String[] facesList;

    /**
     * A list of colours to be used in the future
     * {"BLUE", "RED", "GREEN", "ORANGE", "PINK", "GRAY", "MAGENTA"}
     */
    private final String[] colours;

    /**
     * the list of Wheel objects
     */
    private final List<Wheel> wheelList = new ArrayList<>();

    /**
     * A SlotMachine constructor, it has a payout system
     * and a lot of rolls method to show the payouts over 1million rolls
     *
     * @param x         A list of strings from the facesList
     * @param numWheels the number of wheels for your slotMachine
     * @param colours   A list of strings of colours
     */
    public SlotMachine(String[] x, int numWheels, String[] colours) {

        this.facesList = new String[x.length];
        this.colours = colours;

        for (int i = 0; i < x.length; i++) {
            facesList[i] = x[i];
        }

        for (int i = 0; i < numWheels; i++) {
            int randomColourIndex = (int) (Math.random() * colours.length);

            wheelList.add(new Wheel(facesList, colours[randomColourIndex], facesList.length));
        }
    }

    /**
     * gets a string list of colours to be used in the drawings
     *
     * @return a String list of colours
     */
    public String[] getColours() {
        return colours;
    }


    /**
     * rollers rolls all the wheels
     */
    public void rollers() {
        for (Wheel element : wheelList) {
            element.roll();
        }
    }

    /**
     * This is the real histogram method
     * it calculates the points and where they go
     * to anywhere in a list and prints them out
     */
    public void histogram() {
        int[] histogram = new int[(facesList.length * wheelList.toArray().length) + 1];
        for (int i = 0; i < 1000000; i++) {
            int sum = 0;
            for (int j = 0; j < wheelList.toArray().length; j++) {
                int item = (int) (Math.random() * facesList.length + 1);
                sum += item;
            }
            histogram[sum]++;
        }
        for (int a = wheelList.toArray().length; a < facesList.length * wheelList.toArray().length + 1; a++) {
            if (a < wheelList.toArray().length)
                System.out.print(" ");
            System.out.println(a + ": " + histogram[a]);
        }
    }

    /**
     * this payouts method is used to calculate the payouts
     * of a slotMachine over 1million rolls.
     *
     * @return  int a number that is calculated with matching faces
     */
    public int payouts() {
        int innerCounter = 0;
        for (Wheel w : wheelList) {
            int counter = -1;
            for (Wheel wheel : wheelList) {
                if (w.getWinFace().equals(wheel.getWinFace())) {
                    counter++;
                }
                if (counter > innerCounter) {
                    innerCounter = counter;
                    counter = 0;
                }
            }
        }
        return innerCounter;
    }

    /**
     * A list of Wheels
     *
     * @return a list of wheels
     */
    public List<Wheel> getWheelList() {
        return wheelList;
    }

    /**
     * Overrides the toString so that it
     * posts the payout of the the winning faces
     *
     * @return the Slot Machine the amount of faces and the winnings
     */
    @Override
    public String toString() {
        return "SlotMachine has " + wheelList.size() + " wheels: " + wheelList + " You got " + (payouts()) + " Point";
    }


}
