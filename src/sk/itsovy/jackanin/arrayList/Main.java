package sk.itsovy.jackanin.arrayList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> strArr = new ArrayList<>();

        strArr.add("Miro");
        strArr.add("Jozef");

        for (int i = 0; i < 10; i++) {
            strArr.add("Name"+i);
        }

        for(String temp:strArr){
            System.out.println(temp);
        }

        System.out.println("-----------");

        strArr.add(5,"Hello");

        for(String temp:strArr){
            System.out.println(temp);
        }
    }
}
