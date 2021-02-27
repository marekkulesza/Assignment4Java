package Assignment4;

/*      A Wheel object has a set of faces (“7”, “Cherries”, “Bar”, etc.) in an array.
        It also has a color that it uses to display itself.
        The color, the number of faces, and the text of each face on the wheel is set when
        Wheel object is created and cannot be changed.

        A Wheel can spin itself (i.e. choose a new face). It can
        also report the number of faces it has, and the index (0 or more) of the current face that is showing. It
        has a toString() method that reports the text of the current face. It can also draw itself on a
        GraphicsContext when it is given an x and y location. That’s all it can do.  */

import java.util.Arrays;

public class Wheel {

    private final String[] faces = {"7", "Cherries", "Bar", "King", "Bob","ACES", "YEET"};
    private final String[] colours = {"BLUE", "RED", "GREEN", "ORANGE", "PINK","GRAY", "MAGENTA"};

    public void roll() {

        for (String e : faces) {
            System.out.print(e + " ");
        }

        System.out.println();
    }

    public String[] getFaces() {
        return faces;
    }

    public String[] getColours() {
        return colours;
    }

    public static void main(String[] args) {
        Wheel newWheel = new Wheel();
        System.out.println(Arrays.toString(newWheel.getFaces()));
        System.out.println(Arrays.toString(newWheel.getColours()));
        System.out.println();
        newWheel.roll();
    }
}
