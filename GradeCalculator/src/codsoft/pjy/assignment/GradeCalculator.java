package codsoft.pjy.assignment;

import java.util.Scanner;

/*
*Take marks obtained (out of 100) in each subject.
*Calculate Total Marks.
*Calculate Average Percentage.
* Calculate grade.
* Display result.
 */

public class GradeCalculator
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // Input: Take marks obtained in each subject
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }

        // Calculate Total Marks
        System.out.println("Total Marks: " + totalMarks);

        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / numSubjects;
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);

        // Grade Calculation
        char grade;
        if (averagePercentage >= 80) {
            grade = 'A';
        } else if (averagePercentage >= 65) {
            grade = 'B';
        } else if (averagePercentage >= 50) {
            grade = 'C';
        } else if (averagePercentage >= 30) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display Results
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}