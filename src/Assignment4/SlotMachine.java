package Assignment4;

import java.util.Arrays;

public class SlotMachine {


    private final String[] facesList;
    private final int numWheels;
    private final String[] colours = {"BLUE", "RED", "GREEN", "ORANGE", "PINK", "GRAY", "MAGENTA"};
    private Wheel[] wheelList;

    @Override
    public String toString() {
        return "SlotMachine{" +
                "facesList=" + Arrays.toString(facesList) +
                ", numWheels=" + numWheels +
                ", wheelList=" + Arrays.toString(wheelList) +
                '}';
    }

    public SlotMachine(String[] x, int numWheels) {

        this.facesList = new String[x.length];
        this.numWheels = numWheels;
        
        for (int i = 0; i < x.length; i++) {
            this.facesList[i] = x[i];
        }

        for (int i = 0; i < numWheels; i++){
            wheelList[i] = new Wheel(facesList);
        }
    }

    public static void main(String[] args) {
        SlotMachine Yeet1 = new SlotMachine(new String[]{"7", "Cherries", "Bar", "King", "Bob"},4);

        System.out.println(Yeet1);

    }

}
