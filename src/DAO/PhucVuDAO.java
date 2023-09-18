/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import GiaoDien.QuanLyBan;
import Utilities.DBUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author boixi
 */
public class PhucVuDAO {
    private static PhucVuDAO instance;

    public PhucVuDAO() {
    }

    public static PhucVuDAO getInstance() {
        if (instance == null) {
            instance = new PhucVuDAO();
        }
        return instance;
    }

    public String GetUncheckPhucVuByTableId(String id) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `phuc_vu` WHERE `id_ban` = ? AND `trang_thai` = 0");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("id_hoa_don_ban_hang");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhucVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "-1";
    }
    
    
    public Boolean Insert(String idKhachhang, String idNhanvien, String idThietbi, String idMon, String idBan, 
            String idHoadonbanhang, int trangthai, int soluong, int thoigian) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO `phuc_vu`(`id_khach_hang`,`id_nhan_vien`, `id_thiet_bi`, `id_mon`, "
                    + "`id_ban`, `id_hoa_don_ban_hang`,`trang_thai`, `so_luong`, `thoi_gian`) VALUES (?, ?, ?, ?, ?, ?, ?,?,?)");
            pstmt.setString(1, idKhachhang);
            pstmt.setString(2, idNhanvien);
            pstmt.setString(3, idThietbi);
            pstmt.setString(4, idMon);
            pstmt.setString(5, idBan);
            pstmt.setString(6, idHoadonbanhang);
            pstmt.setInt(7, trangthai);
            pstmt.setInt(8, soluong);
            pstmt.setInt(9, thoigian);
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(PhucVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


    public void Update(String id) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE `phuc_vu` SET `trang_thai`= 1 WHERE `id_hoa_don_ban_hang` = ?");
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhucVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
