package Assignment4;

/*      A Wheel object has a set of faces (“7”, “Cherries”, “Bar”, etc.) in an array.
        It also has a color that it uses to display itself.
        The color, the number of faces, and the text of each face on the wheel is set when
        Wheel object is created and cannot be changed.
        A Wheel can spin itself (i.e. choose a new face). It can
        also report the number of faces it has, and the index (0 or more) of the current face that is showing. It
        has a toString() method that reports the text of the current face. It can also draw itself on a
        GraphicsContext when it is given an x and y location. That’s all it can do.  */


public class Wheel {

    private String[] faces = {"7", "Cherries", "Bar", "King", "Bob","ACES", "YEET"};
    private final String[] colours = {"BLUE", "RED", "GREEN", "ORANGE", "PINK","GRAY", "MAGENTA"};
    private String winFace;

    public Wheel() {
    }

    public Wheel(String[] faces) {
        this.faces = faces;
    }

    public void roll() {
        this.winFace = faces[(int) (Math.random() * getFaces().length)];
    }

    private String[] getFaces() {
        return faces;
    }

    public String getWinner(){
        return "the showing face is: " + winFace;
    }

    public String getLength(){
        return "the length of the list is: " + faces.length;
    }

    @Override
    public String toString() {
        return winFace;
    }

    public static void main(String[] args) {



        Wheel newWheel = new Wheel();
        System.out.println();
        newWheel.roll();
        System.out.println(newWheel.getWinner());
        System.out.println(newWheel.getLength());


        Wheel newWheel2 = new Wheel(new String[]{"1", "2", "3", "4", "5", "6", "WINNER"});
        System.out.println();
        newWheel2.roll();
        System.out.println(newWheel2.getWinner());
        System.out.println(newWheel2.getLength());

        System.out.println();

        System.out.println(newWheel);
        System.out.println(newWheel2);


    }
}
