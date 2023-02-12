package pl.edu.agh.hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Hangman {

    //lista slow
    private static List<String> slowa = scanFile("target/classes/slowa.txt");

    private static String losoweSlowo = slowa.get(new Random().nextInt(slowa.size()));

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

    //przekopiowane z klasy FileScannerToArray
    public static ArrayList<String> scanFile(String filename) {
        ArrayList<String> words = new ArrayList<>();
        File wordlist = new File(filename);
        try {
            BufferedReader br = new BufferedReader(new FileReader(wordlist));
            String st;
            while ((st = br.readLine()) != null) {
                words.add(st);
            }
        } catch (IOException x) {
            System.err.format("IOException; %s", x);
        }
        return words;
    }


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














