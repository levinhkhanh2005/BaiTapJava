import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- BÀI 1: TÍNH TỔNG SỐ CHẴN ---");
        System.out.print("Nhập n nguyên dương: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("n phải là số nguyên dương!");
            return;
        }

        long sum = 0;
        for (int i = 2; i <= n; i += 2) {
            sum += i;
        }

        int maxEven = (n % 2 == 0) ? n : n - 1;
        System.out.println("Tổng s = 2 + 4 + ... + " + maxEven + " là: " + sum);
        scanner.close();
    }
}
