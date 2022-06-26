package students;

import java.io.*;
import java.util.Scanner;

public class ReadArray {
    private static Students[] loaded;

    public static Students[] readTxt(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("zapis.txt"));

            int arrayLength = Integer.parseInt(br.readLine());
            ReadArray.loaded = new Students[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                String name = br.readLine();
                String surname = br.readLine();
                byte age = Byte.parseByte(br.readLine());
                ReadArray.loaded[i] = new Students(name,surname,age);
                int gradesLength = Integer.parseInt(br.readLine());
                for (int j = 0; j < gradesLength; j++) {
                    double grade = Double.parseDouble(br.readLine());
                    ReadArray.loaded[i].addGrade(grade);

                }

            }


        } catch (IOException | NumberFormatException e) {
            System.out.println("brak pliku do wczytania");
            System.out.println("dowolny klawisz - Powrót");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }

        return ReadArray.loaded;
    }



}

