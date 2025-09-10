package taikhoan;

import java.util.*;

class TaiKhoan {
    private String soTaiKhoan;
    private String tenChu;
    private double soDu;

    private static double laiSuatNam = 0.05; // 5% mặc định

    // Constructor
    public TaiKhoan(String soTaiKhoan, String tenChu, double soDu) {
        this.soTaiKhoan = soTaiKhoan;
        this.tenChu = tenChu;
        this.soDu = soDu;
    }

    // Nạp tiền
    public void napTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
            System.out.println("Đã nạp " + soTien + " vào tài khoản " + soTaiKhoan);
        }
    }

    // Rút tiền
    public void rutTien(double soTien) {
        if (soTien > 0 && soTien <= soDu) {
            soDu -= soTien;
            System.out.println("Đã rút " + soTien + " từ tài khoản " + soTaiKhoan);
        } else {
            System.out.println("Số dư không đủ hoặc số tiền không hợp lệ!");
        }
    }

    // Tính lãi 1 tháng
    public void tinhLaiMotThang() {
        double lai = soDu * (laiSuatNam / 12);
        soDu += lai;
    }

    // Hiển thị thông tin
    public void hienThi() {
        System.out.println("STK: " + soTaiKhoan + ", Chủ TK: " + tenChu + ", Số dư: " + soDu);
    }

    // Thay đổi lãi suất
    public static void thayDoiLaiSuat(double laiSuatMoi) {
        laiSuatNam = laiSuatMoi;
        System.out.println("Lãi suất mới: " + (laiSuatNam * 100) + "%/năm");
    }

    // Getter số dư (dùng để sắp xếp)
    public double getSoDu() {
        return soDu;
    }

    // Getter số tài khoản (dùng để tìm kiếm)
    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }
}

public class  taikhoan {
    public static void main(String[] args) {
        List<TaiKhoan> dsTK = new ArrayList<>();

        dsTK.add(new TaiKhoan("001", "Nguyen Van A", 5000));
        dsTK.add(new TaiKhoan("002", "Tran Thi B", 3000));
        dsTK.add(new TaiKhoan("003", "Le Van C", 7000));

        // Thực hiện giao dịch
        dsTK.get(0).napTien(2000);
        dsTK.get(1).rutTien(1000);
        dsTK.get(2).tinhLaiMotThang();

        // Hiển thị danh sách
        System.out.println("\nDanh sách tài khoản sau giao dịch:");
        for (TaiKhoan tk : dsTK) {
            tk.hienThi();
        }

        // Tìm kiếm theo số tài khoản
        String stkCanTim = "002";
        System.out.println("\nTìm kiếm tài khoản số " + stkCanTim + ":");
        for (TaiKhoan tk : dsTK) {
            if (tk.getSoTaiKhoan().equals(stkCanTim)) {
                tk.hienThi();
            }
        }

        // Sắp xếp theo số dư giảm dần
        dsTK.sort((a, b) -> Double.compare(b.getSoDu(), a.getSoDu()));

        System.out.println("\nDanh sách tài khoản sau khi sắp xếp theo số dư giảm dần:");
        for (TaiKhoan tk : dsTK) {
            tk.hienThi();
        }

        // Thay đổi lãi suất
        TaiKhoan.thayDoiLaiSuat(0.06);
    }
}

