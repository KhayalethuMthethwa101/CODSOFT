import java.util.ArrayList;
import java.util.Scanner;

public class GradeCalaulator{
    public ArrayList<Integer> gradeBook = new ArrayList<>();
    private int sum;

    public GradeCalaulator(){}

    public void addMark(int value){
        this.gradeBook.add(value);
    }

    public void removeMark(int value){
        int i = 0;
        while(value!=this.gradeBook.get(i)){
            i+=1;
        }
        gradeBook.remove(i+1);
    }

    public int sumOfGrades(){
        for(int i = 0; i < gradeBook.size(); i++){
            sum+=gradeBook.get(i);
        }
        return sum;
    }
    public int averageGrade(){
        return sum/gradeBook.size();
    }
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            GradeCalaulator grades = new GradeCalaulator();
            System.out.println("How many subject are there");
            int noOfSubjects = scan.nextInt();
            for(int i = 0; i < noOfSubjects; i++){
                System.out.print("Enter grade: ");
                grades.addMark(scan.nextInt());
            }
            int sumOfGrades = grades.sumOfGrades();
            int average = grades.averageGrade();
            System.out.println("===========================");
            System.out.println("Total Marks: " + sumOfGrades);
            System.out.println("Average Percentage: "+ average);
            System.out.println("Final Grade: " + average);
            System.out.println("===========================");
        } catch(Exception e){
            System.out.println("An error occured");
        }
    }
}