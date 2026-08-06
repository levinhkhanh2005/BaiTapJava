import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap diem chuyen can: ");
        double chuyenCan = scanner.nextDouble();

        System.out.print("Nhap diem giua ky: ");
        double giuaKy = scanner.nextDouble();

        System.out.print("Nhap diem cuoi ky: ");
        double cuoiKy = scanner.nextDouble();

        double diemTongKet = chuyenCan * 0.1 + giuaKy * 0.3 + cuoiKy * 0.6;

        System.out.printf("Diem tong ket: %.2f%n", diemTongKet);

        scanner.close();
    }
}
