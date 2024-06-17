package doanjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class QuanLiShopGame {
    private ArrayList<TaiKhoanGame> danhSachTaiKhoan;
    private Scanner scanner;

    public QuanLiShopGame() {
        danhSachTaiKhoan = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void menu() {
        int luaChon;
        do {
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║          🎮 QUẢN LÝ SHOP GAME 🎮       ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║  1. 📥 Nhập thông tin tài khoản        ║");
            System.out.println("║  2. 📋 Xem danh sách tài khoản         ║");
            System.out.println("║  3. ➕ Thêm một tài khoản mới          ║");
            System.out.println("║  4. ✏️ Sửa thông tin tài khoản         ║");
            System.out.println("║  5. ❌ Xóa một tài khoản               ║");
            System.out.println("║  6. 🔄 Sắp xếp tài khoản               ║");
            System.out.println("║  0. 🚪 Thoát chương trình              ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.print("=> Hãy chọn chức năng: ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (luaChon) {
                case 1:
                    nhapThongTinTaiKhoan();
                    break;
                case 2:
                    xemDanhSachTaiKhoan();
                    break;
                case 3:
                    themTaiKhoan();
                    break;
                case 4:
                    suaThongTinTaiKhoan();
                    break;
                case 5:
                    xoaTaiKhoan();
                    break;
                case 6:
                    sapXepTaiKhoan();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (luaChon != 0);
    }

    private void nhapThongTinTaiKhoan() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║      📥 NHẬP THÔNG TIN TÀI KHOẢN 📥    ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.print("Nhập tên tài khoản: ");
        String tenTaiKhoan = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String matKhau = scanner.nextLine();
        System.out.print("Nhập email: ");
        String email = scanner.nextLine();
        System.out.print("Nhập giá tiền (vnđ): ");
        double giaTien = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        TaiKhoanGame taiKhoanGame = new TaiKhoanGame(tenTaiKhoan, matKhau, email, giaTien);
        danhSachTaiKhoan.add(taiKhoanGame);
        System.out.println("✔️ Thêm tài khoản thành công!");
    }

    private void xemDanhSachTaiKhoan() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║        📋 DANH SÁCH TÀI KHOẢN 📋       ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.printf("%-20s %-15s %-30s %-20s\n", "Tên tài khoản", "Mật khẩu", "Email", "Giá tiền (vnđ)");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        for (TaiKhoanGame taiKhoanGame : danhSachTaiKhoan) {
            System.out.printf("%-20s %-15s %-30s %-20s\n", 
                taiKhoanGame.getTenTaiKhoan(), 
                taiKhoanGame.getMatKhau(), 
                taiKhoanGame.getEmail(), 
                currencyFormatter.format(taiKhoanGame.getGiaTien()));
        }
    }

    private void themTaiKhoan() {
        nhapThongTinTaiKhoan();
    }

    private void suaThongTinTaiKhoan() {
        System.out.print("Nhập vị trí của tài khoản cần sửa: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║     ✏️  SỬA THÔNG TIN TÀI KHOẢN ✏️     ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.print("Nhập tên tài khoản mới: ");
        String tenTaiKhoan = scanner.nextLine();
        System.out.print("Nhập mật khẩu mới: ");
        String matKhau = scanner.nextLine();
        System.out.print("Nhập email mới: ");
        String email = scanner.nextLine();
        System.out.print("Nhập giá tiền mới (vnđ): ");
        double giaTien = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        TaiKhoanGame taiKhoanGame = new TaiKhoanGame(tenTaiKhoan, matKhau, email, giaTien);
        danhSachTaiKhoan.set(index, taiKhoanGame);
        System.out.println("✔️ Sửa thông tin tài khoản thành công!");
    }

    private void xoaTaiKhoan() {
        System.out.print("Nhập vị trí của tài khoản cần xóa: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        danhSachTaiKhoan.remove(index);
        System.out.println("✔️ Xóa tài khoản thành công!");
    }

    private void sapXepTaiKhoan() {
        danhSachTaiKhoan.sort((tk1, tk2) -> tk1.getTenTaiKhoan().compareTo(tk2.getTenTaiKhoan()));
        System.out.println("✔️ Sắp xếp tài khoản thành công!");
    }

    public static void main(String[] args) {
        QuanLiShopGame quanLiShopGame = new QuanLiShopGame();
        quanLiShopGame.menu();
    }
}
