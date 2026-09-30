package Mini_project;
import java.util.Scanner;

public class StudentGradeAnalyzer {

    public static int calculateTotal(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    public static double calculatePercentage(int total, int maxMarks) {
        return ((double) total / maxMarks) * 100;
    }

    public static String calculateGrade(double percentage) {
        int band = (int) (percentage / 10);

        switch (band) {
            case 10:
            case 9:
                return "A+";
            case 8:
                return "A";
            case 7:
                return (percentage >= 75.0) ? "A" : "B";
            case 6:
                return "B";
            case 5:
                return "C";
            case 4:
                return (percentage >= 45.0) ? "C" : "D";
            case 3:
                return (percentage >= 35.0) ? "D" : "Fail";
            default:
                return "Fail";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Student Result & Grade Analyzer =====");
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        System.out.print("Enter number of subjects: ");
        int m = scanner.nextInt();

        int[][] marks = new int[n][m];

        for (int i = 0; i < n; i++) {
            System.out.print("Student " + (i + 1) + " marks: ");
            for (int j = 0; j < m; j++) {
                marks[i][j] = scanner.nextInt();
            }
        }

        System.out.println();

        int maxMarksPerStudent = m * 100;
        int topperIndex = 0;
        double maxPercentage = -1.0;

        for (int i = 0; i < n; i++) {
            int total = calculateTotal(marks[i]);
            double percentage = calculatePercentage(total, maxMarksPerStudent);
            String grade = calculateGrade(percentage);

            System.out.printf("Student %d  Total: %d  Percentage: %.2f%%  Grade: %s%n",
                    (i + 1), total, percentage, grade);

            if (percentage > maxPercentage) {
                maxPercentage = percentage;
                topperIndex = i;
            }
        }

        System.out.println();
        System.out.printf("Topper: Student %d with %.2f%%%n", (topperIndex + 1), maxPercentage);

        scanner.close();
    }
}
