/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhanVien;
import Utilities.DBUtility;
import com.akhil.chatapp.utils.Encription;
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
 * @author TRI
 */
public class NhanVienDAO1 {

    private static NhanVienDAO1 instance;
    NhanVien account = new NhanVien();

    public NhanVienDAO1() {
    }

    public static NhanVienDAO1 getInstance() {
        if (instance == null) {
            instance = new NhanVienDAO1();
        }
        return instance;
    }

    public static void setInstance(NhanVienDAO1 instance) {
        NhanVienDAO1.instance = instance;
    }

    public Boolean Login(String username, String password) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `nhan_vien` WHERE username = ? AND password = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                account.setId(rs.getString("id_nhan_vien"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setName(rs.getNString("ten_nhan_vien"));
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public NhanVien GetAccount() {
        return account;
    }

    public List<NhanVien> listAccount() {
        List<NhanVien> list = new ArrayList<NhanVien>();
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * from `nhan_vien`");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                NhanVien account = new NhanVien();
                account.setId(rs.getString("id_nhan_vien"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setName(rs.getNString("ten_nhan_vien"));
                account.setDate(rs.getString("ngay_sinh"));
                account.setAddress(rs.getNString("dia_chi"));
                account.setPhoneNumber(rs.getString("so_dien_thoai"));
                account.setPosition(rs.getNString("chuc_vu"));
                account.setEmail(rs.getString("email"));

                list.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Boolean Add(String name, String username, String pass, String date, String address, String phoneNumber, String position, String id) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO `nhan_vien`(`username`, `password`, `ten_nhan_vien`, `ngay_sinh`, `so_dien_thoai`, `dia_chi`, `chuc_vu`, `email`, `id_nhan_vien`) VALUES (?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, username);
            pstmt.setString(2, pass);
            pstmt.setNString(3, name);
            pstmt.setString(4, date);
            pstmt.setNString(5, phoneNumber);
            pstmt.setString(6, address);
            pstmt.setNString(7, position);
            pstmt.setString(8, id);

            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Boolean Update(String pass, String name, String date, String address, String phoneNumber, String position, String id) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE `nhan_vien` SET `password`=?,`ten_nhan_vien`=?, `ngay_sinh`=?, `so_dien_thoai`=?,`dia_chi`=?, `chuc_vu`=? WHERE `id_nhan_vien`=?");
            pstmt.setString(1, pass);
            pstmt.setString(2, name);
            pstmt.setString(3, date);
            pstmt.setString(4, phoneNumber);
            pstmt.setString(5, address);
            pstmt.setString(6, position);
            pstmt.setString(7, id);

            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Boolean Delete(String id) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("Delete from `nhan_vien` where `id_nhan_vien`=?");
            pstmt.setString(1, id);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Boolean DoiMatKhau(String id, String pass) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE `nhan_vien` SET `password`=? WHERE `id_nhan_vien`=?");
            pstmt.setString(1, pass);
            pstmt.setString(2, id);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public String getTenNVById(String id) throws SQLException {
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rset = null;
        final String SQL = "select * from nhan_vien where id_nhan_vien =?";
        try {
            con = DBUtility.openConnection();
            psmt = con.prepareStatement(SQL);
            psmt.setString(1, id);
            rset = psmt.executeQuery();
            List<NhanVien> list = new ArrayList<NhanVien>();

            while (rset.next()) {
                NhanVien account = new NhanVien();
                account.setId(rset.getString("id_nhan_vien"));
                account.setUsername(rset.getString("username"));
                account.setPassword(rset.getString("password"));
                account.setName(rset.getNString("ten_nhan_vien"));
                account.setDate(rset.getString("ngay_sinh"));
                account.setAddress(rset.getNString("dia_chi"));
                account.setPhoneNumber(rset.getString("so_dien_thoai"));
                account.setPosition(rset.getNString("chuc_vu"));
                account.setEmail(rset.getString("email"));

                list.add(account);
            }
            return list.get(0).getId();

        } finally {
            if (rset != null) {
                rset.close();
            }
            if (psmt != null) {
                psmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
