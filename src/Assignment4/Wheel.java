package Assignment4;

/**
 * This is our 4th assignment Wheel Object
 * This object has a 3 things
 * faces indicate what is on the wheel
 * colours indicates a list of colours you can use
 * Created Feb 28th, 2021
 *
 * * @author Marek Kulesza
 */


public class Wheel {

    /**
     * A list of faces passed from the SlotMachine
     */
    private final String[] faces;

    /**
     * The list of Colours
     */
    private final String[] colours = {"BLUE", "RED", "GREEN", "ORANGE", "PINK", "GRAY", "MAGENTA"};

    /**
     * The calculated face that won the roll method
     */
    private String winFace;


    /**
     * A Wheel constructor
     *
     * @param faces a list of Strings
     */
    public Wheel(String[] faces) {
        this.faces = faces;
    }

    /**
     * Randomly chooses a String from faces
     */
    public void roll() {
        this.winFace = faces[(int) (Math.random() * getFaces().length)];
    }

    /**
     * Gets a string list
     *
     * @return faces: a list of strings
     */
    private String[] getFaces() {
        return faces;
    }

    /**
     * Gets the winning face after a roll()
     *
     * @return winfaces: a winning String
     */
    public String getWinFace() {
        return winFace;
    }

    /**
     * Overides the String method to out
     * the winfaces
     *
     * @return winFace: the winning String from the list
     */
    @Override
    public String toString() {
        return "" + winFace;
    }


}
