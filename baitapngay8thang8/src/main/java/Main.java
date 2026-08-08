import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Quản lý thông tin sinh viên ===");
        
        System.out.print("Nhập mã sinh viên: ");
        String studentId = scanner.nextLine();
        
        System.out.print("Nhập họ tên: ");
        String name = scanner.nextLine();
        
        System.out.print("Nhập chuyên ngành: ");
        String major = scanner.nextLine();
        
        double startGpa = inputGrade(scanner, "Nhập điểm chuyên cần (0-10): ");
        double midtermGpa = inputGrade(scanner, "Nhập điểm giữa kỳ (0-10): ");
        double finalGpa = inputGrade(scanner, "Nhập điểm cuối kỳ (0-10): ");
        
        Student student = new Student(studentId, name, major, startGpa, midtermGpa, finalGpa);
        
        displayResults(student);
        
        scanner.close();
    }
    

    private static double inputGrade(Scanner scanner, String prompt) {
        double grade;
        while (true) {
            System.out.print(prompt);
            try {
                grade = Double.parseDouble(scanner.nextLine());
                if (grade < 0 || grade > 10) {
                    System.out.println("Lỗi: Điểm phải từ 0 đến 10. Vui lòng nhập lại.");
                    continue;
                }
                return grade;
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số hợp lệ.");
            }
        }
    }
    

    private static void displayResults(Student student) {
        System.out.println("\n=== Kết quả ===");
        System.out.println("Mã sinh viên: " + student.getStudentId());
        System.out.println("Họ tên: " + student.getName());
        System.out.println("Chuyên ngành: " + student.getMajor());
        System.out.println("Điểm chuyên cần: " + student.getStartGpa());
        System.out.println("Điểm giữa kỳ: " + student.getMidtermGpa());
        System.out.println("Điểm cuối kỳ: " + student.getFinalGpa());
        System.out.println("Điểm tổng kết: " + String.format("%.1f", student.calculateFinalScore()));
        System.out.println("Xếp loại: " + student.getGrade());
    }
}

class Student {
    private String studentId;
    private String name;
    private String major;
    private double startGpa;
    private double midtermGpa;
    private double finalGpa;
    
    /**
     * Constructor
     */
    public Student(String studentId, String name, String major, 
                   double startGpa, double midtermGpa, double finalGpa) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        this.startGpa = startGpa;
        this.midtermGpa = midtermGpa;
        this.finalGpa = finalGpa;
    }
    

    public double calculateFinalScore() {
        return startGpa * 0.1 + midtermGpa * 0.3 + finalGpa * 0.6;
    }
    

    public String getGrade() {
        double score = calculateFinalScore();
        if (score >= 8.5) {
            return "A";
        } else if (score >= 7.0) {
            return "B";
        } else if (score >= 5.5) {
            return "C";
        } else if (score >= 4.0) {
            return "D";
        } else {
            return "F";
        }
    }
    
    // Getters
    public String getStudentId() {
        return studentId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getMajor() {
        return major;
    }
    
    public double getStartGpa() {
        return startGpa;
    }
    
    public double getMidtermGpa() {
        return midtermGpa;
    }
    
    public double getFinalGpa() {
        return finalGpa;
    }
}
