package pl.edu.agh.hangman;

import java.util.Scanner;

public class Hangman {

    //lista slow
    private static String[] slowa = {"komputer", "pies", "kot", "samochod"};
    // losowanie slowa
    private static String losoweSlowo = slowa[(int) (Math.random() * slowa.length)];
    //ukrycie losowego slowa
    private static String ukryteSlowo = new String(new char[losoweSlowo.length()]).replace("\0", "_");

    private static int count = 0;

    //metoda uzupelniajaca slowo
    public static void sprawdzSlowo(String slowo) {
        String slowoPoSprawdzeniu = "";
        for (int i = 0; i < losoweSlowo.length(); i++) {
            if (losoweSlowo.charAt(i) == slowo.charAt(0)) {
                slowoPoSprawdzeniu += slowo.charAt(0);
            } else if (ukryteSlowo.charAt(i) != '_') {
                slowoPoSprawdzeniu += losoweSlowo.charAt(i);
            } else {
                slowoPoSprawdzeniu += "_";
            }
        }

        if (ukryteSlowo.equals(slowoPoSprawdzeniu)) {
            count++;
            System.out.println(HANGMANPICS[count]);
        } else {
            ukryteSlowo = slowoPoSprawdzeniu;
        }

        if (ukryteSlowo.equals(losoweSlowo)) {
            System.out.println("Wygrales");
        }
    }

    public static final String[] HANGMANPICS = new String[]{
            "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "========"
    };

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (count < HANGMANPICS.length && ukryteSlowo.contains("_")) {
        System.out.println("Podaj litere");
        System.out.println(ukryteSlowo);
        String slowo = scanner.next();
        sprawdzSlowo(slowo);
        }
        scanner.close();
    }
}














