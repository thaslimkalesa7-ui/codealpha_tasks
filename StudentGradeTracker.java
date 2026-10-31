import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> marks = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.next();

            int mark;
            do {
                System.out.print("Enter marks (0-100): ");
                mark = sc.nextInt();

                if (mark < 0 || mark > 100) {
                    System.out.println("Enter marks between 0 and 100.");
                }
            } while (mark < 0 || mark > 100);

            names.add(name);
            marks.add(mark);
        }

        int total = 0;
        int highest = marks.get(0);
        int lowest = marks.get(0);

        System.out.println("\n--- Student Summary Report ---");

        for (int i = 0; i < n; i++) {
            int mark = marks.get(i);

            System.out.println(names.get(i) + " : " + mark);

            total += mark;

            if (mark > highest) {
                highest = mark;
            }

            if (mark < lowest) {
                lowest = mark;
            }
        }

        double average = (double) total / n;

        System.out.println("\nAverage marks: " + average);
        System.out.println("Highest marks: " + highest);
        System.out.println("Lowest marks: " + lowest);

        sc.close();
    }
}