package pl.edu.agh.hangman;
import java.util.Scanner;

public class userInput {

    public static void scanLetterFromUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Zgadnij czy litera jest w slowie?");
        String letter = scan.nextLine();
    }
}
