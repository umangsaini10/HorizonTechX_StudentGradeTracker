package studentgradetracker;


import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    String getGrade() {
        if (marks >= 90) return "A+";
        if (marks >= 80) return "A";
        if (marks >= 70) return "B";
        if (marks >= 60) return "C";
        if (marks >= 50) return "D";
        return "F";
    }
}

public class StudentGradeTracker {
    static ArrayList<Student> students = new ArrayList<>();

    static void addStudent(Scanner sc) {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter marks (0-100): ");
        double marks = Double.parseDouble(sc.nextLine());

        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks!");
            return;
        }

        students.add(new Student(name, marks));
        System.out.println("Student added successfully!");
    }

    static void displayReport() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        double total = 0;
        double highest = -1;
        double lowest = 101;
        Student topStudent = null;
        Student lowStudent = null;

        System.out.println("\n========== STUDENT REPORT ==========");

        for (Student s : students) {
            System.out.println("Name: " + s.name
                    + " | Marks: " + s.marks
                    + " | Grade: " + s.getGrade());

            total += s.marks;

            if (s.marks > highest) {
                highest = s.marks;
                topStudent = s;
            }

            if (s.marks < lowest) {
                lowest = s.marks;
                lowStudent = s;
            }
        }

        System.out.println("------------------------------------");
        System.out.printf("Total Students: %d%n", students.size());
        System.out.printf("Average Marks: %.2f%n",
                total / students.size());
        System.out.println("Highest Scorer: " + topStudent.name
                + " (" + highest + ")");
        System.out.println("Lowest Scorer: " + lowStudent.name
                + " (" + lowest + ")");
        System.out.println("====================================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Student Report");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    addStudent(sc);
                    break;

                case "2":
                    displayReport();
                    break;

                case "3":
                    System.out.println("Thank you for using Student Grade Tracker!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
