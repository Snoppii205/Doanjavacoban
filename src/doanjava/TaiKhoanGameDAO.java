package doanjava;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TaiKhoanGameDAO {
    private List<TaiKhoanGame> danhSachTaiKhoan;

    public TaiKhoanGameDAO() {
        danhSachTaiKhoan = new ArrayList<>();
    }

    public void themTaiKhoan(TaiKhoanGame taiKhoanGame) {
        danhSachTaiKhoan.add(taiKhoanGame);
    }

    public List<TaiKhoanGame> getDanhSachTaiKhoan() {
        return danhSachTaiKhoan;
    }

    public void suaTaiKhoan(int index, TaiKhoanGame taiKhoanGame) {
        if (index >= 0 && index < danhSachTaiKhoan.size()) {
            danhSachTaiKhoan.set
