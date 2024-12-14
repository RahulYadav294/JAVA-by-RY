package Code_Alpha_Tasks;

import java.util.Scanner;

public class Code_Alpha_Task_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of students:");
        int numberOfStudent = sc.nextInt();
        sc.nextLine();

        int[] grade = new int[numberOfStudent];
        String[] nameOfStudent = new String[numberOfStudent];


        getNameOfStudent(nameOfStudent, sc);
        getNumberOfStudent(grade, sc);


        String[] marksAndNames = highestLowestAverage(grade, nameOfStudent);


        display(marksAndNames);
    }


    public static void getNameOfStudent(String[] nameOfStudent, Scanner sc) {
        for (int i = 0; i < nameOfStudent.length; i++) {
            System.out.println("Enter the name of student " + (i + 1) + ":");
            nameOfStudent[i] = sc.nextLine();
        }
    }


    public static void getNumberOfStudent(int[] grade, Scanner sc) {
        for (int i = 0; i < grade.length; i++) {
            System.out.println("Enter the grade of student " + (i + 1) + ":");
            grade[i] = sc.nextInt();
            sc.nextLine();
        }
    }


    public static String[] highestLowestAverage(int[] grade, String[] nameOfStudent) {
        String highestScorer = nameOfStudent[0];
        String lowestScorer = nameOfStudent[0];
        double highest = grade[0];
        double lowest = grade[0];
        double total = 0.0;

        for (int i = 0; i < grade.length; i++) {
            total += grade[i];
            if (highest < grade[i]) {
                highest = grade[i];
                highestScorer = nameOfStudent[i];
            }
            if (lowest > grade[i]) {
                lowest = grade[i];
                lowestScorer = nameOfStudent[i];
            }
        }

        double average = total / grade.length;

        return new String[]{
                "Highest marks is: " + highest + " (Student: " + highestScorer + ")",
                "Lowest marks is: " + lowest + " (Student: " + lowestScorer + ")",
                "Average marks is: " + average
        };
    }


    public static void display(String[] marksAndNames) {
            System.out.println(marksAndNames[0]);
            System.out.println(marksAndNames[1]);
            System.out.println(marksAndNames[2]);
    }
}
