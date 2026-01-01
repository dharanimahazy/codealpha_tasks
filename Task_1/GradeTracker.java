import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter mark: ");
            int mark = sc.nextInt();
            sc.nextLine();

            students.add(new Student(name, mark));
        }

        int total = 0;
        int highest = students.get(0).getMark();
        int lowest = students.get(0).getMark();

        for (Student s : students) {
            int m = s.getMark();
            total += m;

            if (m > highest) {
                highest = m;
            }

            if (m < lowest) {
                lowest = m;
            }
        }

        double average = (double) total / students.size();

        System.out.println("\n----- Student Summary Report -----");
        for (Student s : students) {
            System.out.println("Name: " + s.getName() + " | Mark: " + s.getMark());
        }

        System.out.println("---------------------------------");
        System.out.println("Average Mark : " + average);
        System.out.println("Highest Mark : " + highest);
        System.out.println("Lowest Mark  : " + lowest);

        sc.close();
    }
}
