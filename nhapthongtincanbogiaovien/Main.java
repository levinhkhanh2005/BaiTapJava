import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Nguoi {
        private String hoTen;
        private int tuoi;
        private String queQuan;
        private String maSo;

        public Nguoi(String hoTen, int tuoi, String queQuan, String maSo) {
            this.hoTen = hoTen;
            this.tuoi = tuoi;
            this.queQuan = queQuan;
            this.maSo = maSo;
        }

        public String getHoTen() {
            return hoTen;
        }

        public int getTuoi() {
            return tuoi;
        }

        public String getQueQuan() {
            return queQuan;
        }

        public String getMaSo() {
            return maSo;
        }

        @Override
        public String toString() {
            return String.format("Ma so: %s | Ho ten: %s | Tuoi: %d | Que quan: %s", maSo, hoTen, tuoi, queQuan);
        }
    }

    static class CBGV extends Nguoi {
        private double luongCung;
        private double luongThuong;
        private double tienPhat;

        public CBGV(String hoTen, int tuoi, String queQuan, String maSo,
                    double luongCung, double luongThuong, double tienPhat) {
            super(hoTen, tuoi, queQuan, maSo);
            this.luongCung = luongCung;
            this.luongThuong = luongThuong;
            this.tienPhat = tienPhat;
        }

        public double getLuongCung() {
            return luongCung;
        }

        public double getLuongThuong() {
            return luongThuong;
        }

        public double getTienPhat() {
            return tienPhat;
        }

        public double getThucLinh() {
            return luongCung + luongThuong - tienPhat;
        }

        @Override
        public String toString() {
            return String.format("%s | Luong cung: %.2f | Luong thuong: %.2f | Tien phat: %.2f | Thuc linh: %.2f",
                    super.toString(), luongCung, luongThuong, tienPhat, getThucLinh());
        }
    }

    private final List<CBGV> danhSach = new ArrayList<>();

    public void themCBGV(CBGV cbgv) {
        if (timCBGV(cbgv.getMaSo()) != null) {
            System.out.println("Ma so da ton tai. Khong the them.");
            return;
        }
        danhSach.add(cbgv);
        System.out.println("Da them giang vien thanh cong.");
    }

    public boolean xoaCBGV(String maSo) {
        CBGV found = timCBGV(maSo);
        if (found != null) {
            danhSach.remove(found);
            return true;
        }
        return false;
    }

    public CBGV timCBGV(String maSo) {
        for (CBGV cbgv : danhSach) {
            if (cbgv.getMaSo().equalsIgnoreCase(maSo.trim())) {
                return cbgv;
            }
        }
        return null;
    }

    public void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach giao vien rong.");
            return;
        }
        System.out.println("Danh sach can bo giao vien:");
        for (CBGV cbgv : danhSach) {
            System.out.println(cbgv);
        }
    }

    public void hienThiLuongThucLinh(String maSo) {
        CBGV cbgv = timCBGV(maSo);
        if (cbgv == null) {
            System.out.println("Khong tim thay can bo voi ma so: " + maSo);
            return;
        }
        System.out.println("Thong tin can bo:");
        System.out.println(cbgv);
        System.out.printf("Luong thuc linh cua giang vien %s la: %.2f\n", cbgv.getHoTen(), cbgv.getThucLinh());
    }

    private static void inMenu() {
        System.out.println("\n===== QUAN LY CAN BO GIANG VIEN =====");
        System.out.println("1. Them can bo giang vien");
        System.out.println("2. Xoa can bo giang vien theo ma so");
        System.out.println("3. Hien thi danh sach can bo");
        System.out.println("4. Hien thi luong thuc linh theo ma so");
        System.out.println("5. Thoat");
        System.out.print("Lua chon: ");
    }

    public static void main(String[] args) {
        Main manager = new Main();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            inMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Nhap ho ten: ");
                    String hoTen = scanner.nextLine().trim();
                    System.out.print("Nhap tuoi: ");
                    int tuoi = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Nhap que quan: ");
                    String queQuan = scanner.nextLine().trim();
                    System.out.print("Nhap ma so giao vien: ");
                    String maSo = scanner.nextLine().trim();
                    System.out.print("Nhap luong cung: ");
                    double luongCung = Double.parseDouble(scanner.nextLine().trim());
                    System.out.print("Nhap luong thuong: ");
                    double luongThuong = Double.parseDouble(scanner.nextLine().trim());
                    System.out.print("Nhap tien phat: ");
                    double tienPhat = Double.parseDouble(scanner.nextLine().trim());
                    manager.themCBGV(new CBGV(hoTen, tuoi, queQuan, maSo, luongCung, luongThuong, tienPhat));
                    break;
                case "2":
                    System.out.print("Nhap ma so de xoa: ");
                    String maSoXoa = scanner.nextLine().trim();
                    if (manager.xoaCBGV(maSoXoa)) {
                        System.out.println("Xoa thanh cong.");
                    } else {
                        System.out.println("Khong tim thay can bo co ma so nay.");
                    }
                    break;
                case "3":
                    manager.hienThiDanhSach();
                    break;
                case "4":
                    System.out.print("Nhap ma so de hien thi luong thuc linh: ");
                    String maSoLuong = scanner.nextLine().trim();
                    manager.hienThiLuongThucLinh(maSoLuong);
                    break;
                case "5":
                    running = false;
                    System.out.println("Ket thuc chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        }

        scanner.close();
    }
}
