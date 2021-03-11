package seedu.duke;
import java.util.Scanner;
public class UI {
    public static Scanner in = new Scanner(System.in);

    public UI() {
    }

    protected static String getString(Scanner in) {
        String userInput;
        userInput = in.nextLine();
        return userInput;
    }


}
