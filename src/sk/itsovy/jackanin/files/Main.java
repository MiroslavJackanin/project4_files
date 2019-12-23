package sk.itsovy.jackanin.files;

import java.io.IOException;

public class Main {
    private static String path = "src/sk/itsovy/jackanin/input/vstup.txt";

    public static void main(String[] args) throws IOException {
        ReadFile file1 = new ReadFile();
        file1.printJoke();
        System.out.println("-----------------------------");
        file1.printFileInfo();
        System.out.println("-----------------------------");
        //file1.copyFile("src/sk/itsovy/jackanin/input/vstup.txt");
        //System.out.println(file1.diktat("src/sk/itsovy/jackanin/input/vstup.txt", "src/sk/itsovy/jackanin/input/vstup_copy.txt"));
        //System.out.println(file1.numbers("src/sk/itsovy/jackanin/input/vstup.txt"));
        //System.out.println(file1.numbers1("src/sk/itsovy/jackanin/input/vstup.txt"));
        //System.out.println(file1.numbers2("src/sk/itsovy/jackanin/input/vstup.txt"));
        //file1.numbers3("src/sk/itsovy/jackanin/input/vstup.txt");
        //file1.analyzer("src/sk/itsovy/jackanin/input/vstup.txt");
        file1.cipher(path);
    }
}
