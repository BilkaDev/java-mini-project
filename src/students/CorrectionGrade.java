package students;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CorrectionGrade {
    public static Students[] correction(Students[] array){

    try {
        CorrectionGrade.showStudents(array);
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println("Podaj index oceny którą chcesz poprawić lub usunąć");
        array[id].showGrades();

        short gradeId = scanner.nextShort();
        System.out.println("P - Jeśli chcesz poprawić ocene");
        System.out.println("U - Jeśli chcesz usunąć ocene");
        System.out.println("X - Wróć do strony głównej");

        String choose = scanner.next();
        switch (choose.toUpperCase()) {
            case "P":
                System.out.println("Na jaką ocene poprawić");
                double newGrade = scanner.nextDouble();
                array[id].correctionGrade(newGrade,gradeId);
                System.out.println("Ocena została poprawiona");
                break;
            case "U":
                array[id].removeGrade(gradeId);
                System.out.println("Ocena została usunięta");
                break;
            case "X":
                break;
            default:
                System.out.println("zły wybór");
                break;
        }
    }catch (IndexOutOfBoundsException e){
        System.out.println("---> Podałeś błedny index <---");
    }catch (InputMismatchException e){
        System.out.println("---> Podałeś błedny format <---");
    }

        SaveArray.saveToTxt(array);
        return array;

    }


    public static Students[] addGrade(Students[] array){

        try {
            CorrectionGrade.showStudents(array);
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            System.out.println("Podaj ocene do dodania");
            double addGrade = scanner.nextDouble();
            array[id].addGrade(addGrade);

        }catch (IndexOutOfBoundsException e){
            System.out.println("---> Podałeś błedny index <---");
        }catch (InputMismatchException e){
            System.out.println("---> Podałeś błedny format <---");
        }

        SaveArray.saveToTxt(array);
        return array;

    }

    public static void showStudents(Students[] array){
        for (int i = 0; i < array.length; i++){
            System.out.println("index: " + i+ " Imie i nazwisko:"+array[i].showName());
        }


    }
}
