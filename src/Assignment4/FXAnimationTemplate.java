package Assignment4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Use this template to create simple animations in FX. Change the name of the
 * class and put your own name as author below. Change the size of the canvas
 * and the window title where marked and add your drawing code in the animation
 * method where shown.
 *
 * @author Marek Kulesza
 */
public class FXAnimationTemplate extends Application {

    /**
     * Sets up the stage and starts the main thread. Your drawing code should
     * NOT go here.
     *
     * @param stage The first stage
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("Section 1.4 Animated!"); // window title here
        Canvas canvas = new Canvas(400, 300); // canvas size here
        Group root = new Group();
        Scene scene = new Scene(root);
        root.getChildren().add(canvas);
        stage.setScene(scene);
        stage.show();
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // This code starts a "thread" which will run your animation
        Thread t = new Thread(() -> animate(gc));
        t.start();
    }

    /**
     * Animation thread. This is where you put your animation code.
     *
     * Note: Although most of what you will do will probably work, there is a
     * possibility of the application appearing to freeze after a while because
     * the drawing is not happening in a thread safe way. If this is happening,
     * create a private draw() method with parameters for x, y, etc. to do the
     * actual drawing work, then call it like this...
     *
     * Platform.runLater(() -> {
     *      draw(x,y...);
     * });
     *
     * @param gc The drawing surface
     */
    public void animate(GraphicsContext gc) {
        Scanner sc = new Scanner(System.in);


        List<SlotMachine> slotMachineList = new ArrayList<>();

        SlotMachine Yeet1 = new SlotMachine(new String[]{"YEET", "DOG", "WOOF", "BORK", "BAH"},4);
        SlotMachine Yeet2 = new SlotMachine(new String[]{"7", "Cherries", "Bar", "King", "Bob"},4);

        slotMachineList.add(Yeet1);
        slotMachineList.add(Yeet2);

        System.out.println("Choose a SlotMachine, they have different names but are all the same inside :) ");
        System.out.println("1, 2, or 1");

        int choice = sc.nextInt();

        while (!(choice >= 1 && choice <= 2)) {
            System.err.println("Please enter a number between 1 to 2");
            int choiceAgain = sc.nextInt();
            if (choiceAgain >= 1 && choiceAgain <= 2) {
                choice = choiceAgain;
                break;
            }
        }

        if (choice == 1) {
            Yeet1.rollers();
        }

        if (choice == 2) {
            Yeet2.rollers();
        }

        // Flag to break out of the loop
        int quit = 0;

        // Main Loop
        while (quit == 0) {
            System.out.println("1 = spin, 2 = lotta spins, 3 = no more spins");
            int decisionChoice = sc.nextInt();

            while (!(decisionChoice >= 1 && decisionChoice <= 3)) {
                System.err.println("Please enter a number between 1 to 3: 1 = spin, 2 = lotta spins, 3 = no more spins ");
                int decisionChoiceAgain = sc.nextInt();
                if (decisionChoiceAgain >= 1 && decisionChoiceAgain <= 3) {
                    decisionChoice = decisionChoiceAgain;
                    break;
                }
            }

            // Roll the wheels on the slot machine
            if (decisionChoice == 1) {
                slotMachineList.get(choice).rollers();
                System.out.println(slotMachineList.get(choice));

                int x = 50;
                int y = 50;

                String[] colorElemento = slotMachineList.get(choice).getColours();
                List<Wheel> wheelios = slotMachineList.get(choice).getWheelList();
                gc.clearRect(0, 0, 400, 300);
                for (int i = 0; i < wheelios.size(); i++) {

                    gc.setStroke(Color.web(colorElemento[i]));
                    gc.strokeText(String.valueOf(wheelios.get(i)), x,y);
                    y += 50;
                }
            }

            // Calculate the occurrences
            else if (decisionChoice == 2) {
                System.out.println("Payout Occurrence");
                slotMachineList.get(choice).payouts();
            }

            // Quit the program
            else {
                System.out.println("Bye now");
                quit = 1;
            }
        }
    }

    /**
     * Use this method instead of Thread.sleep(). It handles the possible
     * exception by catching it, because re-throwing it is not an option in this
     * case.
     *
     * @param duration Pause time in milliseconds.
     */
    public static void pause(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ex) {
        }
    }

    /**
     * Exits the app completely when the window is closed. This is necessary to
     * kill the animation thread.
     */
    @Override
    public void stop() {
        System.exit(0);
    }

    /**
     * Launches the app
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
