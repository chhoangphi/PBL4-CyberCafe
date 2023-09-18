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
public class HoaDonNhap {
    private String id;
    private NhaCungCap nhacungcap;
    private static String IdCyber = "CB01";
    private String date;
    private double totalCost;

    public HoaDonNhap() {
    }

    public HoaDonNhap(String id, NhaCungCap nhacungcap, String date, double totalCost) {
        this.id = id;
        this.nhacungcap = nhacungcap;
        this.date = date;
        this.totalCost = totalCost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NhaCungCap getNhacungcap() {
        return nhacungcap;
    }

    public void setNhacungcap(NhaCungCap nhacungcap) {
        this.nhacungcap = nhacungcap;
    }

    public static String getIdCyber() {
        return IdCyber;
    }

    public static void setIdCyber(String IdCyber) {
        HoaDonNhap.IdCyber = IdCyber;
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
    
    
}
