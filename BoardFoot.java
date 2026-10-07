import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Calculates board feet from the width and height of a piece of wood.
 */
public final class BoardFoot {

    /**
     * Cubic inches in one board foot.
     */
    private static final float TOTAL_VOLUME = 144.0f;

    /**
     * Prevents this program class from being instantiated.
     */
    private BoardFoot() {
    }

    /**
     * Prompts for the wood's width and height and displays the board feet.
     *
     * @param args Command line arguments
     */
    public static void main(final String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the width in inches: ");
            float width = scanner.nextFloat();
            System.out.print("Enter the height in inches: ");
            float height = scanner.nextFloat();

            if (width <= 0 || height <= 0) {
                System.out.println(
                        "Error: Dimensions must be greater than zero.");
            } else {
                float boardFeet = calculateBoardFoot(width, height);
                // One board foot is 144 cubic inches.
                float length = TOTAL_VOLUME / (width * height);
                System.out.println("Length: " + length + " inches");
                System.out.println("Board feet: " + boardFeet);
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter numerical dimensions.");
        }
    }

    /**
     * Calculates board feet using the supplied width and height.
     *
     * @param width The wood's width in inches
     * @param height The wood's height in inches
     * @return The number of board feet, or zero if a dimension is not positive
     */
    public static float calculateBoardFoot(
            final float width, final float height) {
        try {
            if (width <= 0 || height <= 0) {
                throw new IllegalArgumentException(
                        "Dimensions must be greater than zero.");
            }

            // Calculate the length that makes the volume one board foot.
            float length = TOTAL_VOLUME / (width * height);

            // Divide the wood's volume by the volume of one board foot.
            float boardFeet = (width * height * length) / TOTAL_VOLUME;
            return boardFeet;
        } catch (IllegalArgumentException e) {
            return 0;
        }
    }
}
