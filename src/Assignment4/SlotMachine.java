package Assignment4;

import java.util.ArrayList;
import java.util.List;

public class SlotMachine {

    private final String[] facesList;
    private final String[] colours = {"BLUE", "RED", "GREEN", "ORANGE", "PINK", "GRAY", "MAGENTA"};
    private List<Wheel> wheelList = new ArrayList<>();
    private int numWheels;

    public SlotMachine(String[] x, int numWheels) {

        this.facesList = new String[x.length];

        for (int i = 0; i < x.length; i++) {
            facesList[i] = x[i];
        }

        for (int i = 0; i < numWheels; i++){
            wheelList.add(new Wheel(facesList));
        }
    }

    public void rollers() {
        for (Wheel element: wheelList) {
            element.roll();
        }
    }

    public void occurrences() {
        int ans = 1;
        int math = 1;
        // Total number of occurrences
        int totalOcc = (int) Math.pow(facesList.length, wheelList.toArray().length);
        System.out.println("Total number \t " + totalOcc);

        int[] histogram = new int[(facesList.length*wheelList.toArray().length)+1];

            for (int i = 0; i < 1000000; i++) {

                int sum = 0;
                for (int j = 0; j < wheelList.toArray().length; j++) {
                    int item = (int) (Math.random() * facesList.length + 1);
                    sum += item;
                }
                histogram[sum]++;
            }

            for (int i = wheelList.toArray().length; i < facesList.length*wheelList.toArray().length+1; i++) {
                if (i<wheelList.toArray().length)
                    System.out.print(" ");
                System.out.println(i + ": " + histogram[i]);
            }
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
