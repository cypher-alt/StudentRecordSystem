import java.util.*;

class Student {
    private int id;
    private String name;
    private double marks;

    
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
    }
}

public class StudentManagement {
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n Student Record System ");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(); break;
                case 4: deleteStudent(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    // Add student
    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // clear newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        Student s = new Student(id, name, marks);
        studentList.add(s);
        System.out.println("Student added!");
    }

    // View all students
    static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : studentList) {
                s.display();
            }
        }
    }

    // Update student
    static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Student s : studentList) {
            if (s.getId() == id) {
                sc.nextLine(); // clear newline
                System.out.print("Enter new name: ");
                String name = sc.nextLine();
                System.out.print("Enter new marks: ");
                double marks = sc.nextDouble();
                s.setName(name);
                s.setMarks(marks);
                System.out.println("Student updated!");
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Student not found!");
    }

    // Delete student
    static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        Iterator<Student> it = studentList.iterator();
        boolean found = false;

        while (it.hasNext()) {
            Student s = it.next();
            if (s.getId() == id) {
                it.remove();
                System.out.println("Student deleted!");
                found = true;
                break;
            }
        }

        if (!found) System.out.println("Student not found!");
    }
}

