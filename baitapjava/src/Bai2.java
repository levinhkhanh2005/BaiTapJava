import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- BÀI 2: TÍNH TỔNG NGHỊCH ĐẢO ---");
        System.out.print("Nhập n nguyên dương: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("n phải là số nguyên dương!");
            return;
        }

        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }

        System.out.printf("Tổng s = 1 + 1/2 + ... + 1/%d là: %.6f\n", n, sum);
        scanner.close();
    }
}
