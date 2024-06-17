package doanjava;

public class TaiKhoanGame {
    private String tenTaiKhoan;
    private String matKhau;
    private String email;
    private double giaTien;

    public TaiKhoanGame(String tenTaiKhoan, String matKhau, String email, double giaTien) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
        this.email = email;
        this.giaTien = giaTien;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    @Override
    public String toString() {
        return "TaiKhoanGame{" +
                "tenTaiKhoan='" + tenTaiKhoan + '\'' +
                ", matKhau='" + matKhau + '\'' +
                ", email='" + email + '\'' +
                ", giaTien=" + giaTien +
                '}';
    }
}
