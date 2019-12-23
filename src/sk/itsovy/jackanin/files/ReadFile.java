package sk.itsovy.jackanin.files;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Scanner;

public class ReadFile {
    public void printJoke(){
        try{
            File myFile = new File("C:\\Users\\MIRO\\Desktop\\joke.txt");
            Scanner myReader = new Scanner(myFile);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printFileInfo(){
        File myFile = new File("C:\\Users\\MIRO\\Desktop\\joke.txt");
        if (!myFile.exists()){
            System.out.println("File not found 404");
        }
        System.out.println("File name: "+myFile.getName()+"\nAbsolute path: "+myFile.getAbsolutePath()+"\nSize: "+myFile.length()+"\nReadable: "+myFile.canRead());
    }

    public void copyFile(String sourceFile) {
        try {
            File myFile = new File(sourceFile);
            File otherFile = new File("src/sk/itsovy/jackanin/input/vstup_copy.txt");
            FileWriter write = new FileWriter(otherFile);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                data = data.toUpperCase();
                write.write(data + "\n");
            }
            myReader.close();
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int diktat(String sourceFile, String target){
        int count = 0;
        try {
            File myFile = new File(sourceFile);
            File otherFile = new File("src/sk/itsovy/jackanin/input/vstup_copy.txt");
            FileWriter write = new FileWriter(otherFile);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                char[] chData = data.toCharArray();
                for (int i=0; i<data.length(); i++){
                    if (chData[i] == 'i' || chData[i] =='y' || chData[i] =='I' || chData[i] =='Y'){
                        chData[i] = '_';
                        count++;
                    }
                }
                write.write(chData);
            }
            myReader.close();
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public double numbers(String sourceFile){
        int sum = 0;
        int count = 0;
        try {
            File myFile = new File(sourceFile);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                int num = myReader.nextInt();
                sum += num;
                count ++;
            }
            myReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (double)sum/count;
    }

    public double numbers1(String sourceFile){
        int sum = 0;
        int count = 0;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile), Charset.defaultCharset()));
            int temp = 0;
            while ((temp = reader.read()) != -1){
                char c = (char)temp;
                sum += Character.getNumericValue(c);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (double)sum/count;
    }

    public double numbers2(String sourceFile){
        int sum = 0;
        int count = 0;
        try {
            FileReader fr = new FileReader(sourceFile);
            BufferedReader br = new BufferedReader(fr);
            int temp;
            while ((temp = br.read()) != -1){
                char c = (char)temp;
                if (c == ' ' || c == ','){
                    continue;
                }
                sum += Character.getNumericValue(c);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (double)sum/count;
    }

    public void numbers3(String sourceFile){
        int count = 0;
        try {
            FileReader fr = new FileReader(sourceFile);
            BufferedReader br = new BufferedReader(fr);
            int temp;
            while ((temp = br.read()) != -1){
                char c = (char)temp;
                if (c == ' ' || c == ','){
                    continue;
                }
                count++;
            }
            fr.close();
            br.close();

            fr = new FileReader(sourceFile);
            br = new BufferedReader(fr);
            int[] arr = new int[count];
            count = 0;
            while ((temp = br.read()) != -1){
                char c = (char)temp;
                if (c == ' ' || c == ','){
                    continue;
                }
                arr[count] = Character.getNumericValue(c);
                count++;
            }
            fr.close();
            br.close();

            /*
            for (int i=0; i<arr.length; i++){
                for (int j=0; j<arr.length-1; j++){
                    if (arr[j]>arr[j+1]){
                        temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1]=temp;
                    }
                }
            }
             */
            Arrays.sort(arr);
            String str = Arrays.toString(arr);
            System.out.println(str);
            FileWriter fw = new FileWriter("src/sk/itsovy/jackanin/input/vstup_copy.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(str);
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void analyzer(String sourceFile){
        try {
            FileReader fr = new FileReader(sourceFile);
            BufferedReader br = new BufferedReader(fr);
            int[] arr = new int[95];
            int temp;
            while ((temp = br.read()) != -1){
                arr[temp-32]++;
                System.out.println(temp);
            }
            for (int i=0; i<arr.length; i++){
                char c = (char)(i+32);
                System.out.println(c + " : " + arr[i]+" ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cipher(String sourceFile){
        String path = "src/sk/itsovy/jackanin/input/vstup_copy.txt";
        try {
            FileReader fr = new FileReader(sourceFile);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            int temp;
            while ((temp = br.read()) != -1) {
                char ch = (char) temp;
                if (ch+3 > 127){
                    ch = (char)((ch + 3) - 127);
                }else{
                    ch+=3;
                }
                bw.write(Character.toString(ch));
            }
            br.close();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
