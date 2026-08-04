import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- BÀI 3: KIỂM TRA SỐ NGUYÊN TỐ ---");
        System.out.print("Nhập số nguyên n: ");
        int n = scanner.nextInt();

        if (isPrime(n)) {
            System.out.println(n + " LÀ số nguyên tố.");
        } else {
            System.out.println(n + " KHÔNG PHẢI là số nguyên tố.");
        }
        scanner.close();
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
