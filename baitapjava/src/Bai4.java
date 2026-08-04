import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- BÀI 4: KIỂM TRA VÀ PHÂN LOẠI TAM GIÁC ---");
        System.out.print("Nhập cạnh a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập cạnh b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhập cạnh c: ");
        double c = scanner.nextDouble();

        // Kiểm tra điều kiện tam giác
        if (a > 0 && b > 0 && c > 0 && (a + b > c) && (a + c > b) && (b + c > a)) {
            System.out.print("Ba số " + a + ", " + b + ", " + c + " TẠO THÀNH TAM GIÁC: ");

            boolean isEquilateral = (a == b && b == c);
            boolean isIsosceles = (a == b || b == c || a == c);

            // Kiểm tra Pythagore với sai số nhỏ eps để tránh sai số số thực
            double eps = 1e-6;
            boolean isRight = Math.abs(a * a + b * b - c * c) < eps ||
                              Math.abs(a * a + c * c - b * b) < eps ||
                              Math.abs(b * b + c * c - a * a) < eps;

            if (isEquilateral) {
                System.out.println("Tam giác đều.");
            } else if (isRight && isIsosceles) {
                System.out.println("Tam giác vuông cân.");
            } else if (isRight) {
                System.out.println("Tam giác vuông.");
            } else if (isIsosceles) {
                System.out.println("Tam giác cân.");
            } else {
                System.out.println("Tam giác thường.");
            }
        } else {
            System.out.println("Ba số " + a + ", " + b + ", " + c + " KHÔNG tạo thành 3 cạnh tam giác.");
        }
        scanner.close();
    }
}
