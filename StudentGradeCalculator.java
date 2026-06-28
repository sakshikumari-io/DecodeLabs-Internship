import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int totalMarks = 0;
        int numSubjects = 0;

        System.out.println("Student Grade Calculator");

        while (true) {
            System.out.print("Enter number of subjects: ");
            try {
                numSubjects = Integer.parseInt(sc.nextLine());

                if (numSubjects > 0) {
                    break;
                } else {
                    System.out.println("Number of subjects must be greater than 0.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a whole number.");
            }
        }

        for (int i = 1; i <= numSubjects; i++) {
            int currentMark = 0;

            while (true) {
                System.out.print("Enter marks for Subject " + i + ": ");

                try {
                    currentMark = Integer.parseInt(sc.nextLine());

                    if (currentMark >= 0 && currentMark <= 100) {
                        break;
                    } else {
                        System.out.println("Marks must be between 0 and 100.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Enter an integer.");
                }
            }

            totalMarks += currentMark;
        }

        double average = (double) totalMarks / numSubjects;

        char grade;

        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("\n----- Result -----");
        System.out.println("Subjects : " + numSubjects);
        System.out.println("Total : " + totalMarks);
        System.out.printf("Average : %.2f%%\n", average);
        System.out.println("Grade : " + grade);

        sc.close();
    }
}