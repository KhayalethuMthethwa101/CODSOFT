import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class GradeCalaulator{
    public HashMap<String, Integer> gradeBook;
    private int sum;

    public GradeCalaulator(){
        HashMap <String, Integer> newGradeBook = new HashMap<>();
        this.gradeBook = newGradeBook;
    }

    public void addMark(String key, int grade){
        this.gradeBook.put(key, grade);
    }

    public int sumOfGrades(){
        sum=0;
        if (gradeBook!=null) {
            Set<String> e = gradeBook.keySet();
            for (String string : e) {
                sum+=gradeBook.get(string);
            }
        }
        return sum;
    }
    public void printGrades(){
        if (gradeBook!=null) {
            Set<String> e = gradeBook.keySet();
            for (String string : e) {
                System.out.printf("%-20s %s%n",string, gradeBook.get(string));
            }
        }
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
                System.out.println("Enter subject name (if there are any spaces replace with a dash): ");
                String keyInput = scan.next();
                scan.nextLine();
                System.out.println("Enter grade: ");
                int gradeInput = scan.nextInt();
                grades.addMark(keyInput, gradeInput);
            }
            int sumOfGrades = grades.sumOfGrades();
            int average = grades.averageGrade();
            System.out.println("===========================");
            grades.printGrades();
            System.out.println("===========================");
            System.out.printf("%-20s %s%n","Total Marks: ", sumOfGrades);
            //System.out.println("Average Percentage: "+ average);
            System.out.printf("%-20s %s%n","Final Grade: ", average);
            System.out.println("===========================");
        } catch(Exception e){
            System.out.println("An error occured");
        }
    }
}