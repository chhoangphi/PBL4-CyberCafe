/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HoaDonBanHang;
import DTO.KhachHang;
import GiaoDien.QuanLyBan;
import Utilities.DBUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author boixi
 */
public class HoaDonBanHangDAO {
    private static HoaDonBanHangDAO instance;

    public HoaDonBanHangDAO() {
    }

    public static HoaDonBanHangDAO getInstance() {
        if (instance == null) {
            instance = new HoaDonBanHangDAO();
        }
        return instance;
    }
    public List<HoaDonBanHang> ListHoaDon(String id) {
        List<HoaDonBanHang> list = new ArrayList<HoaDonBanHang>();
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `hoa_don_ban_hang` WHERE `id_hoa_don_ban_hang` = ?");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                HoaDonBanHang hoadon = new HoaDonBanHang(rs.getString(1), KhachHangDAO.getInstance().getKhachHangByID("KH518"), rs.getString(3), rs.getDouble(4), rs.getInt(5));
                list.add(hoadon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonBanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public String getIdHoadon() {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT id_hoa_don_ban_hang FROM `hoa_don_ban_hang` order by id_hoa_don_ban_hang desc limit 1");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String idhoadon = rs.getString("id_hoa_don_ban_hang");
                idhoadon = "TT00" + String.valueOf(Integer.parseInt(idhoadon.substring(4)) + 1);
                System.out.println("ID hoa don moi: " + idhoadon);
                return idhoadon;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonBanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "-1";
    }
    
    public Boolean Insert(String idhoadon, String idkhachhang, String ngay, double tongtien, int trangthai) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO `hoa_don_ban_hang`(`id_hoa_don_ban_hang`, `id_khach_hang`, `ngay_ban`, `tong_tien`, `trang_thai`) VALUES (?,?,?,?,?)");
            pstmt.setString(1, idhoadon);
            pstmt.setString(2, idkhachhang);
            pstmt.setString(3, ngay);
            pstmt.setDouble(4, tongtien);
            pstmt.setInt(5, trangthai);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonBanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public String CheckHoaDonById(String id) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `hoa_don_ban_hang` WHERE `id_hoa_don_ban_hang` = ? and `trang_thai` = 0");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
//                Invoices invoices = new Invoices(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                return rs.getString("id_hoa_don_ban_hang");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonBanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "-1";
    }
    public void Update(String id, double totalPrice) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE `hoa_don_ban_hang` SET `trang_thai`= 1, `tong_tien` = ? WHERE `id_hoa_don_ban_hang` = ?");
            pstmt.setDouble(1, totalPrice);
            pstmt.setString(2, id);
            pstmt.executeUpdate();
//                int i = pstmt.executeUpdate();
//                if (i > 0) {
//                }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonBanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
