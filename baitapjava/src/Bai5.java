import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- BÀI 5: HIỂN THỊ DÃY FIBONACCI ---");
        System.out.print("Nhập n nguyên dương: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("n phải là số nguyên dương!");
            return;
        }

        System.out.print(n + " số Fibonacci đầu tiên: ");
        long first = 0, second = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                System.out.print(first);
            } else if (i == 2) {
                System.out.print(" " + second);
            } else {
                long next = first + second;
                System.out.print(" " + next);
                first = second;
                second = next;
            }
        }
        System.out.println();
        scanner.close();
    }
}
