package Assignment4;

public class SlotMachine {

    private String[] x;

    public SlotMachine(String[] x) {
        this.x = new String[x.length];
        for (int i = 0; i < x.length; i++) {
            this.x[i] = x[i];
        }
    }
}
