package Assignment4;

import java.util.ArrayList;
import java.util.List;

public class SlotMachine {

    /**
     * a List of winning faces as Strings
     */
    private final String[] facesList;

    /**
     * A list of colours to be used in the future
     */
    private final String[] colours = {"BLUE", "RED", "GREEN", "ORANGE", "PINK", "GRAY", "MAGENTA"};

    /**
     *
     */
    private final List<Wheel> wheelList = new ArrayList<>();

    public SlotMachine(String[] x, int numWheels) {

        this.facesList = new String[x.length];

        for (int i = 0; i < x.length; i++) {
            facesList[i] = x[i];
        }

        for (int i = 0; i < numWheels; i++){
            wheelList.add(new Wheel(facesList));
        }
    }

    public String[] getFacesList() {
        return facesList;
    }

    public String[] getColours() {
        return colours;
    }

    public void rollers() {
        for (Wheel element: wheelList) {
            element.roll();
        }
    }

    public void payouts() {
        // Total number of occurrences
        int[] payout = new int[(wheelList.toArray().length)+1];
            for (int i = 0; i < 1_000_000; i++) {
                List<Integer> numList = new ArrayList<>();
                int counter = 0;
                for (int j = 0; j < wheelList.toArray().length; j++) {
                    int item = (int) (Math.random() * facesList.length + 1);
                    if (numList.contains(item)) {
                        counter++;
                    }
                    numList.add(item);
                }
                payout[counter]++;
            }
            for (int i = 0; i < wheelList.toArray().length; i++) {
                if (i<wheelList.toArray().length)
                    System.out.print(" ");
                System.out.println(i + ": " + payout[i]);
            }
        }

    public List<Wheel> getWheelList() {
        return wheelList;
    }

    @Override
    public String toString() {

        int innerCounter = 0;
        for (Wheel w : wheelList){
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

        return "SlotMachine " + wheelList + " You got " + (innerCounter) + " Point";
    }


}
