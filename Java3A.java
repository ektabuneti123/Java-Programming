package Java3A;

// Custom exception for invalid marks
class InvalidMarksException extends Exception {

    public InvalidMarksException(String message) {
        super(message);
    }
}

// Custom exception for low attendance
class LowAttendanceException extends Exception {

    public LowAttendanceException(String message) {
        super(message);
    }
}

// Student class
class Student {

    // Method to enter marks
    public void enterMarks(int marks) throws InvalidMarksException {

        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Marks should be between 0 and 100.");
        }

        System.out.println("Marks entered successfully: " + marks);
    }

    // Method to check attendance
    public void checkAttendance(int attendance) throws LowAttendanceException {

        if (attendance < 75) {
            throw new LowAttendanceException("Attendance is below 75%. Exam not allowed.");
        }

        System.out.println("Attendance is sufficient: " + attendance + "%");
    }
}

// Main class
public class Java3A {

    public static void main(String[] args) {

        Student student = new Student();

        try {
            student.enterMarks(85);
            student.enterMarks(120);
        } catch (InvalidMarksException e) {
            System.out.println("Marks Error: " + e.getMessage());
        }

        try {
            student.checkAttendance(60);
        } catch (LowAttendanceException e) {
            System.out.println("Attendance Error: " + e.getMessage());
        }
    }
}