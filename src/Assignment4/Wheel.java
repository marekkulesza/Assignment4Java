package Assignment4;

/**
 * This is our 4th assignment Wheel Object
 * This object has a 3 things
 * faces indicate what is on the wheel
 * colours indicates a list of colours you can use
 * Created Feb 28th, 2021
 * <p>
 * * @author Marek Kulesza
 */


public class Wheel {

    /**
     * A list of faces passed from the SlotMachine
     */
    private final String[] faces;

    /**
     * the number of faces on the wheel
     */
    private final int numFaces;

    /**
     * the x position for the FXAnimation
     */
    private int xPosition = 0;

    /**
     * the y position for the FXAnimation
     */
    private int yPosition = 0;

    /**
     * The calculated face that won the roll method
     */
    private String winFace;

    /**
     * Choice of colour, Default is BLACK
     */
    private String colour = "BLACK";

    /**
     * A basic Wheel constructor with no x or y coordinator
     *
     * @param faces A String list of faces for the Wheel
     * @param colour A String for the colour use CAPS
     * @param numFaces the number of faces on the wheel
     */
    public Wheel(String[] faces, String colour, int numFaces) {
        this.faces = faces;
        this.colour = colour;
        this.numFaces = numFaces;
    }

    /**
     * A basic Wheel constructor with x or y coordinator
     * for the FX Animation
     *
     * @param faces A String list of faces for the Wheel
     * @param colour A String for the colour use CAPS
     * @param numFaces the number of faces on the wheel
     * @param xPosition the x position for the FXAnimation
     * @param yPosition the y position for the FXAnimation
     */
    public Wheel(String[] faces, String colour, int numFaces, int xPosition, int yPosition) {
        this.faces = faces;
        this.colour = colour;
        this.numFaces = numFaces;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        // Honestly I never used this because I was tired, but if I did I would have
        // used this xPos and yPos in the animation instead setting it in the FXAnimation
    }

    /**
     * gets the colour of the wheel default is black
     *
     * @return String colour
     */
    public String getColour() {
        return colour;
    }


    /**
     * Gets the number of faces on the wheel
     *
     * @return the int of number of faces
     */
    public int getNumFaces() {
        return numFaces;
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
     * Overrides the String method to out
     * the winfaces
     *
     * @return winFace: the winning String from the list
     */
    @Override
    public String toString() {
        return "" + winFace;
    }


}
