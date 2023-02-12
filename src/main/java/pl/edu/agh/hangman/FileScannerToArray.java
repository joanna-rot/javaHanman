package pl.edu.agh.hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileScannerToArray {


    public static void scanFile(String filename) {
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
    }
}
