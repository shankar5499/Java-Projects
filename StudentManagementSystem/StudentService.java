import java.io.*;
import java.util.*;

public class StudentService {
    private static final String DATA_FILE = "students.dat";
    private List<Student> students;

    public StudentService() {
        students = loadFromFile();
    }

    public void addStudent(Student s) {
        students.add(s);
        saveToFile();
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(int id) throws StudentNotFoundException {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        throw new StudentNotFoundException("No student found with ID: " + id);
    }

    public void updateStudent(int id, String name, int age, String course, double marks)
            throws StudentNotFoundException {
        Student s = getStudentById(id);
        s.setName(name);
        s.setAge(age);
        s.setCourse(course);
        s.setMarks(marks);
        saveToFile();
    }

    public void deleteStudent(int id) throws StudentNotFoundException {
        Student s = getStudentById(id);
        students.remove(s);
        saveToFile();
    }

    public List<Student> searchByName(String keyword) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(s);
            }
        }
        return result;
    }

    public double calculateAverageMarks() {
        if (students.isEmpty()) return 0.0;
        double total = 0;
        for (Student s : students) total += s.getMarks();
        return total / students.size();
    }

    @SuppressWarnings("unchecked")
    private List<Student> loadFromFile() {
        File file = new File(DATA_FILE);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Could not load existing data. Starting fresh.");
            return new ArrayList<>();
        }
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}
