package students;

import java.util.ArrayList;
import java.util.List;

public class Students {
   protected String name;
   protected String surname;
   protected byte age;
   protected List<Double> grades = new ArrayList<Double>();

    public Students(String name, String surname, byte age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public double addGrade(double grade){
       this.grades.add(grade);
       return grade;
    }
    public double correctionGrade(double grade, short index){
       this.grades.set(index, grade);
    return grade;
    }

    public double removeGrade(short index){
        Double rating = this.grades.get(index);
        this.grades.remove(index);
        return rating;
    }
    public void showGrades(){
        for (int i = 0; i < this.grades.size(); i++) {
            System.out.println("id: " + i + " ocena: "+this.grades.get(i));
        }

    }
    public String showName(){
        String fullName = this.name + " " +this.surname;
        return fullName;
    }



}
