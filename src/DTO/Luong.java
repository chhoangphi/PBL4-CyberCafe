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
public class Luong {
    private NhanVien nhanvien;
    private int countDate;

    public Luong() {
    }

    public Luong(NhanVien nhanvien, int countDate) {
        this.nhanvien = nhanvien;
        this.countDate = countDate;
    }

    public NhanVien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(NhanVien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public int getCountDate() {
        return countDate;
    }

    public void setCountDate(int countDate) {
        this.countDate = countDate;
    }
    
    
}
