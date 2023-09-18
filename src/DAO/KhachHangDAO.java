/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhachHang;
import Utilities.DBUtility;
import com.akhil.chatapp.utils.Encription;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author boixi
 */
public class KhachHangDAO {

    private static KhachHangDAO instance;
    KhachHang khachhang = new KhachHang();

    public KhachHangDAO() {
    }

    public static KhachHangDAO getInstance() {
        if (instance == null) {
            instance = new KhachHangDAO();
        }
        return instance;
    }

    public static void setInstance(KhachHangDAO instance) {
        KhachHangDAO.instance = instance;
    }

    public KhachHang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(KhachHang khachhang) {
        this.khachhang = khachhang;
    }

    public List<KhachHang> listKhachHang() {
        List<KhachHang> list = new ArrayList<KhachHang>();
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * from `khach_hang`");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                KhachHang khachhang = new KhachHang();
                khachhang.setId(rs.getString("id_khach_hang"));
                khachhang.setName(rs.getNString("ten_khach_hang"));
                khachhang.setAddress(rs.getNString("dia_chi"));
                khachhang.setPhoneNumber(rs.getString("so_dien_thoai"));
                list.add(khachhang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public KhachHang getKhachHangByID(String id) {
        Connection con = DBUtility.openConnection();
        KhachHang khachhang = new KhachHang();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `khach_hang` WHERE `id_khach_hang` = ?");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                khachhang.setId(rs.getString("id_khach_hang"));
                khachhang.setName(rs.getNString("ten_khach_hang"));
                khachhang.setAddress(rs.getNString("dia_chi"));
                khachhang.setPhoneNumber(rs.getString("so_dien_thoai"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return khachhang;
    }

    public Boolean Add(String id, String name, String address, String phoneNumber) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO `khach_hang`(`id_khach_hang`, `ten_khach_hang`, `dia_chi`, `so_dien_thoai`) VALUES (?,?,?,?)");
            pstmt.setString(1, id);
            pstmt.setNString(2, name);
            pstmt.setNString(3, address);
            pstmt.setNString(4, phoneNumber);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Boolean Update(String id, String name, String address, String phoneNumber) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE `khach_hang` SET `ten_khach_hang`=?,`dia_chi`=?, `so_dien_thoai` = ? WHERE `id_khach_hang`=?");
            pstmt.setNString(1, name);
            pstmt.setNString(2, address);
            pstmt.setString(3, phoneNumber);
            pstmt.setString(4, id);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Boolean Delete(String id) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("Delete from `khach_hang` where `id_khach_hang`=?");
            pstmt.setString(1, id);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<KhachHang> findKhachHang(String key) {
        List<KhachHang> list = new ArrayList<KhachHang>();
        Connection con = DBUtility.openConnection();
        try {
            String apkey = "%" + key + "%";
            PreparedStatement pstmt = con.prepareStatement("SELECT * from `khach_hang` WHERE `so_dien_thoai` like ? OR `id_khach_hang` like ?");
            pstmt.setString(1, apkey);
            pstmt.setString(2, apkey);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                KhachHang khachhang = new KhachHang();
                khachhang.setId(rs.getString("id_khach_hang"));
                khachhang.setName(rs.getNString("ten_khach_hang"));
                khachhang.setAddress(rs.getNString("dia_chi"));
                khachhang.setPhoneNumber(rs.getString("so_dien_thoai"));
                list.add(khachhang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean isLogin(KhachHang khachHang) throws SQLException, NoSuchAlgorithmException, ClassNotFoundException, Exception {
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rset = null;
        final String SQL = "select ten_khach_hang from khach_hang where id_khach_hang=? and so_dien_thoai=?";
        try {
            con = DBUtility.openConnection();
            psmt = con.prepareStatement(SQL);
            psmt.setString(1, khachHang.getId());
//            String encryptedpwd = Encription.passswordEncrypt(khachHang.getPhoneNumber());
//            System.out.println("encryptedpw = " + encryptedpwd);
////            String encryptedpwd = Encription.passswordEncrypt(new String(khachHang.getPhoneNumber()));
            psmt.setString(2, khachHang.getPhoneNumber());
            rset = psmt.executeQuery();
//            return rset.next();
            return true;
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

    public int add(KhachHang khachHang) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, Exception {
        System.out.println("Rec" + " " + khachHang.getId() + " " + " \nPassword " + " " + khachHang.getPhoneNumber());
        Connection connection = null;

        Statement stmt = null;
        try {
            connection = DBUtility.openConnection();
            stmt = connection.createStatement();
            int record = stmt.executeUpdate("insert into khach_hang(id_khach_hang,so_dien_thoai) values('" + khachHang.getId() + "','" + khachHang.getPhoneNumber() + "')");

//            int record = stmt.executeUpdate("insert into khach_hang(id_khach_hang,so_dien_thoai) values('" + khachHang.getId() + "','" + Encription.passswordEncrypt(khachHang.getPhoneNumber()) + "')");
            return record;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
