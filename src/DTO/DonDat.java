/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author boixi
 */
public class DonDat {
    private String tenmon;
    private double gia;
    private int soluong;
    private String tenthietbi;
    private int thoigian;
    private double tongtien;

    public DonDat() {
    }

    public DonDat(String tenmon, double gia, int soluong, String tenthietbi, int thoigian, double tongtien) {
        this.tenmon = tenmon;
        this.gia = gia;
        this.soluong = soluong;
        this.tenthietbi = tenthietbi;
        this.thoigian = thoigian;
        this.tongtien = tongtien;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getTenthietbi() {
        return tenthietbi;
    }

    public void setTenthietbi(String tenthietbi) {
        this.tenthietbi = tenthietbi;
    }

    public int getThoigian() {
        return thoigian;
    }

    public void setThoigian(int thoigian) {
        this.thoigian = thoigian;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    
}
