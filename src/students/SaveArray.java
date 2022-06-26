package students;

import java.io.*;

public class SaveArray {



    public static void saveToTxt (Students[] array){
        try {
            PrintWriter pw = new PrintWriter("zapis.txt");
                pw.println(array.length);
            for (int i = 0; i < array.length; i++) {
                pw.println(array[i].name);
                pw.println(array[i].surname);
                pw.println(array[i].age);
                pw.println(array[i].grades.size());

                for (int j = 0; j < array[i].grades.size(); j++) {
                    pw.println(array[i].grades.get(j));
                }
            }
            pw.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
