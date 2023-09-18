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
public class HoaDonBanHang {
    private String id;
    private KhachHang khachhang;
    private static String IDCyber = "CB01";
    private String date;
    private double totalCost;
    private int time;

    public HoaDonBanHang() {
    }

    public HoaDonBanHang(String id, KhachHang khachhang, String date, double totalCost, int time) {
        this.id = id;
        this.khachhang = khachhang;
        this.date = date;
        this.totalCost = totalCost;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public KhachHang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(KhachHang khachhang) {
        this.khachhang = khachhang;
    }

    public static String getIDCyber() {
        return IDCyber;
    }

    public static void setIDCyber(String IDCyber) {
        HoaDonBanHang.IDCyber = IDCyber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    
}
