import java.util.Scanner;
import java.util.Random;

public class ColorGuesser {
    public static void main(String[] args) {
        String[] colors = {"red", "blue", "green", "yellow", "purple", "orange", "pink", "black", "white", "brown"};
        Random rand = new Random();
        String selectedColor = colors[rand.nextInt(colors.length)];

        Scanner scanner = new Scanner(System.in);
        String guess = "";
        int attempts = 0;

        System.out.println("Welcome to the Color Guesser Game!");
        System.out.println("Try to guess the color I'm thinking of.");
        System.out.println("Available colors: ");
        for (String color : colors) {
            System.out.print(color + " ");
        }
        System.out.println("\n");

        while (!guess.equalsIgnoreCase(selectedColor)) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextLine().trim().toLowerCase();
            attempts++;

            if (!isInList(guess, colors)) {
                System.out.println("That's not a valid color from the list. Try again.");
            } else if (!guess.equals(selectedColor)) {
                System.out.println("Nope! That's not it. Try again.");
            }
        }

        System.out.println("Correct! The color was \"" + selectedColor + "\".");
        System.out.println("You guessed it in " + attempts + " attempts.");

        scanner.close();
    }
    public static boolean isInList(String input, String[] list) {
        for (String item : list) {
            if (item.equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }
}
