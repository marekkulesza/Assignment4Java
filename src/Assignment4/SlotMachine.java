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

        // X number of occurrences
        for (int ii = 0; ii < wheelList.toArray().length+1; ii++) {
            System.out.print(ii + "\t Matches\t ");
            for (int i = 1; i < wheelList.toArray().length+1; i++) {
                math = (facesList.length - i);
                ans += ans * math;
            }
            System.out.println(ans);
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
