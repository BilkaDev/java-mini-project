import students.AddStudents;
import students.CorrectionGrade;
import students.ReadArray;
import students.Students;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Students[] loadedArray = ReadArray.readTxt();
        Scanner scanner = new Scanner(System.in);
        Students[] arrayStudents = null;


        boolean end = true;
        while (end) {
            System.out.println("Wybierz działanie");
            System.out.println("N - Dodaj studenta/ów");
            System.out.println("W - Wyświetl liste studentów");
            System.out.println("D - Dodaj ocene");
            System.out.println("P - popraw lub usuń ocene studenta");
            System.out.println("X - Zakończ");


            try {
            String press = scanner.nextLine();
            switch (press.toUpperCase()) {
                case "N":
                    arrayStudents = AddStudents.addStudents(loadedArray, arrayStudents);
                    break;
                case "D":
                    System.out.println("Dodaj ocene studentowi o indexie:");
                    arrayStudents = CorrectionGrade.addGrade((arrayStudents != null) ? arrayStudents : loadedArray);
                    break;
                case "P":
                    System.out.println("Wyświetl oceny studenta o indexie:");
                    arrayStudents = CorrectionGrade.correction((arrayStudents != null) ? arrayStudents : loadedArray);
                    break;
                case "W":
                    System.out.println("List studentów");
                    CorrectionGrade.showStudents((arrayStudents != null) ? arrayStudents : loadedArray);
                    System.out.println("dowolny klawisz - Powrót");
                    scanner.nextLine();
                    break;
                case "X":
                    System.out.println("Exit");
                    end = false;
                    break;
                default: break;
            }

            }catch (NullPointerException e){
                System.out.println("--->Tablica z studentami jest pusta !<---");
                System.out.println("dowolny klawisz - Powrót");
                scanner.nextLine();
            }catch (InputMismatchException e){
                System.out.println("---> Podałeś błedny format <---");
            }
        }

    }
}



