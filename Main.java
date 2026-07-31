import java.util.List;
import java.util.Scanner;

public class Main {
    private static StudentService service = new StudentService();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("=== Student Management System ===");

        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewAllStudents(); break;
                case 3: updateStudent(); break;
                case 4: deleteStudent(); break;
                case 5: searchStudent(); break;
                case 6: showAverage(); break;
                case 7: running = false; System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }

    private static void printMenu() {
        System.out.println("\n1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Search Student by Name");
        System.out.println("6. Show Average Marks");
        System.out.println("7. Exit");
    }

    private static void addStudent() {
        int id = readInt("Enter ID: ");
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        int age = readInt("Enter Age: ");
        System.out.print("Enter Course: ");
        String course = sc.nextLine();
        double marks = readDouble("Enter Marks: ");

        service.addStudent(new Student(id, name, age, course, marks));
        System.out.println("Student added successfully.");
    }

    private static void viewAllStudents() {
        List<Student> students = service.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) System.out.println(s);
    }

    private static void updateStudent() {
        int id = readInt("Enter ID of student to update: ");
        try {
            System.out.print("Enter new Name: ");
            String name = sc.nextLine();
            int age = readInt("Enter new Age: ");
            System.out.print("Enter new Course: ");
            String course = sc.nextLine();
            double marks = readDouble("Enter new Marks: ");

            service.updateStudent(id, name, age, course, marks);
            System.out.println("Student updated successfully.");
        } catch (StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deleteStudent() {
        int id = readInt("Enter ID of student to delete: ");
        try {
            service.deleteStudent(id);
            System.out.println("Student deleted successfully.");
        } catch (StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void searchStudent() {
        System.out.print("Enter name keyword: ");
        String keyword = sc.nextLine();
        List<Student> results = service.searchByName(keyword);
        if (results.isEmpty()) {
            System.out.println("No matching students found.");
        } else {
            for (Student s : results) System.out.println(s);
        }
    }

    private static void showAverage() {
        System.out.printf("Average Marks: %.2f%n", service.calculateAverageMarks());
    }

    private static int readInt(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            System.out.print(prompt);
            sc.next();
        }
        int val = sc.nextInt();
        sc.nextLine();
        return val;
    }

    private static double readDouble(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextDouble()) {
            System.out.println("Please enter a valid number.");
            System.out.print(prompt);
            sc.next();
        }
        double val = sc.nextDouble();
        sc.nextLine();
        return val;
    }
}
