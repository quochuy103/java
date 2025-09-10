package sinhvien;


class sinhvien {
    private String maSV;
    private String hoTen;
    private int tuoi;

    private static int tongSoSV = 0; // biến tĩnh đếm tổng số SV

    // Constructor
    public sinhvien(String maSV, String hoTen, int tuoi) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        tongSoSV++;
    }

    // Phương thức gán thông tin
    public void setThongTin(String maSV, String hoTen, int tuoi) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
    }

    // Hiển thị thông tin
    public void hienThi() {
        System.out.println("Mã SV: " + maSV + ", Họ tên: " + hoTen + ", Tuổi: " + tuoi);
    }

    // Phương thức tĩnh hiển thị tổng số SV
    public static void hienThiTongSV() {
        System.out.println("Tổng số sinh viên: " + tongSoSV);
    }
}

public class testsinhvien {
    public static void main(String[] args) {
        sinhvien sv1 = new sinhvien("SV001", "Nguyen Van A", 20);
        sinhvien sv2 = new sinhvien("SV002", "Tran Thi B", 21);
        sinhvien sv3 = new sinhvien("SV003", "Le Van C", 19);

        sv1.hienThi();
        sv2.hienThi();
        sv3.hienThi();

        sinhvien.hienThiTongSV();
    }
}

