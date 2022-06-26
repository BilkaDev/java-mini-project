package students;
import java.util.Scanner;

public class AddStudentsCopia {

    public static Students[] addStudents(Students[] loadedArray){
        Students[] arrayStudents;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj liczbe studentów");


        if (!scanner.hasNextInt()){
            System.out.println("Proszę podać poprawne dane");
            return null;
        }
        int numbersOfStudent = scanner.nextInt();
        boolean key = false;

        if (loadedArray != null ) {
            System.out.println("Czy do starej tablicy dodać nowych studentów?");
            System.out.println("Y - tak");
            System.out.println("N - Nie");
            if (scanner.next().toUpperCase().equals("Y")) {
                key = true;
            }}


        if (key) {
                arrayStudents = new Students[numbersOfStudent + loadedArray.length];
                for (int i = 0; i < loadedArray.length; i++) {
                    arrayStudents[i] = loadedArray[0];
                }
            } else {
                arrayStudents = new Students[numbersOfStudent];
            }




        for ( int i = key ? loadedArray.length:0; i < arrayStudents.length; i++) {
            System.out.println("Podaj imię studenta " + (i + 1));
            String name = scanner.next();
            System.out.println("Podaj nazwisko studenta " + (i + 1));
            String surname = scanner.next();
            System.out.println("Podaj wiek studenta " + (i + 1));

            if (scanner.hasNextByte()) {
                byte age = scanner.nextByte();
                arrayStudents[i] = new Students(name, surname, age);
            }else {
                System.out.println("Proszę podać poprawne dane");
                return null;
            }
            boolean flag = true;

            while (flag){
                System.out.println("Czy chcesz dodać ocene studentowi ?");
                System.out.println("Y - tak");
                System.out.println("N - Nie");

                if (scanner.next().toUpperCase().equals("Y") ){
                    System.out.println("Prosze wpisać ocene");
                    double grade = scanner.nextDouble();
                    arrayStudents[i].addGrade(grade);
                } else {flag = false;}
            }

        }
        SaveArray.saveToTxt(arrayStudents);
        return arrayStudents;
    }
}
