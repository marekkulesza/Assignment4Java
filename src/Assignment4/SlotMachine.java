package Assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SlotMachine {


    private final String[] colours = {"BLUE", "RED", "GREEN", "ORANGE", "PINK", "GRAY", "MAGENTA"};
    private List<Wheel> wheelList = new ArrayList<>();

    public SlotMachine(String[] x, int numWheels) {

        String[] facesList = new String[x.length];

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

    public static void main(String[] args) {
        SlotMachine Yeet1 = new SlotMachine(new String[]{"7", "Cherries", "Bar", "King", "Bob"},4);
        Yeet1.rollers();
        System.out.println(Yeet1);
        Yeet1.rollers();
        System.out.println(Yeet1);
        Yeet1.rollers();
        System.out.println(Yeet1);
        Yeet1.rollers();
        System.out.println(Yeet1);
        Yeet1.rollers();
        System.out.println(Yeet1);
    }
}
