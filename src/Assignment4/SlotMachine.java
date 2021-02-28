package Assignment4;

import java.util.ArrayList;
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



        for (Wheel wheel : wheelList){
            System.out.println(wheel.getWinFace());
            for (int i = 0; i < wheelList.size(); i++) {
                if (wheel.getWinFace() == (wheelList.get(i))){

                }
            }
        }

        return "SlotMachine " + wheelList;
    }

    public static void main(String[] args) {
        SlotMachine Yeet1 = new SlotMachine(new String[]{"7", "Cherries", "Bar", "King", "Bob"},4);
        Yeet1.rollers();
        System.out.println(Yeet1);
    }
}
