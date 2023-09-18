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
public class PhucVu {
    private KhachHang khachhang;
    private NhanVien nhanvien;
    private ThietBi thietbi;
    private Ban ban;
    private ThucDon thucdon;
    private HoaDonBanHang hoadonbanhang;

    public PhucVu() {
    }

    public PhucVu(KhachHang khachhang, NhanVien nhanvien, ThietBi thietbi, Ban ban, ThucDon thucdon, HoaDonBanHang hoadonbanhang) {
        this.khachhang = khachhang;
        this.nhanvien = nhanvien;
        this.thietbi = thietbi;
        this.ban = ban;
        this.thucdon = thucdon;
        this.hoadonbanhang = hoadonbanhang;
    }

    public KhachHang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(KhachHang khachhang) {
        this.khachhang = khachhang;
    }

    public NhanVien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(NhanVien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public ThietBi getThietbi() {
        return thietbi;
    }

    public void setThietbi(ThietBi thietbi) {
        this.thietbi = thietbi;
    }

    public Ban getBan() {
        return ban;
    }

    public void setBan(Ban ban) {
        this.ban = ban;
    }

    public ThucDon getThucdon() {
        return thucdon;
    }

    public void setThucdon(ThucDon thucdon) {
        this.thucdon = thucdon;
    }

    public HoaDonBanHang getHoadonbanhang() {
        return hoadonbanhang;
    }

    public void setHoadonbanhang(HoaDonBanHang hoadonbanhang) {
        this.hoadonbanhang = hoadonbanhang;
    }
    
    
}
