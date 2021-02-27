package Assignment4;

/*      A Wheel object has a set of faces (“7”, “Cherries”, “Bar”, etc.) in an array. It also has a color that it uses
        to display itself. The color, the number of faces, and the text of each face on the wheel is set when
        Wheel object is created and cannot be changed. A Wheel can spin itself (i.e. choose a new face). It can
        also report the number of faces it has, and the index (0 or more) of the current face that is showing. It
        has a toString() method that reports the text of the current face. It can also draw itself on a
        GraphicsContext when it is given an x and y location. That’s all it can do.  */

public class Wheel {

    private String[] x;

    public Wheel(String[] x) {
        this.x = new String[x.length];
        for (int i = 0; i < x.length; i++) {
            this.x[i] = x[i];
        }
    }

    public String[] getX() {
        return x;
    }

    public static void main(String[] args) {

        String[] wheelList = {"7", "Cherries", "Bar", "King", "Bobbert"};
        Wheel firstWheel = new Wheel(wheelList);

        for (String word : wheelList) {
            System.out.print(word + " ");
        }
        System.out.println();

    }
}
