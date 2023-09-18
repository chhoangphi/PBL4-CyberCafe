/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DonDat;
import DTO.ThucDon;
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
public class ThucDonDAO {
    private static ThucDonDAO instance;
    
    public ThucDonDAO() {
    }
    
    public static ThucDonDAO getInstance() {
        if (instance == null) {
            instance = new ThucDonDAO();
        }
        return instance;
    }
    
    public List<ThucDon> GetListThucDon() {
        List<ThucDon> list = new ArrayList<ThucDon>();
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `menu`");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ThucDon thucdon = new ThucDon(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
                list.add(thucdon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThucDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public List<DonDat> GetListThucDonByTableId(String id) {
        List<DonDat> list = new ArrayList<DonDat>();
        Connection con = DBUtility.openConnection();
        try {
            String sql = "SELECT `menu`.`ten_mon`, `menu`.`gia`,`phuc_vu`.`so_luong`,`thiet_bi_cc_internet`.`ten_thiet_bi`,"
                    + "`phuc_vu`.`thoi_gian` ,`menu`.`gia` * `phuc_vu`.`so_luong` + "
                    + "`phuc_vu`.`thoi_gian` * `thiet_bi_cc_internet`.`gia` AS totalPrice "
                    + "FROM `hoa_don_ban_hang`, `menu`, `phuc_vu`, `thiet_bi_cc_internet` "
                    + "WHERE phuc_vu.id_mon = menu.id_mon and phuc_vu.id_thiet_bi = thiet_bi_cc_internet.id_thiet_bi "
                    + "and phuc_vu.id_hoa_don_ban_hang = hoa_don_ban_hang.id_hoa_don_ban_hang and phuc_vu.id_ban = ? "
                    + "and phuc_vu.trang_thai = 0";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                DonDat dondat = new DonDat(rs.getString(1), rs.getDouble(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getDouble(6));
                list.add(dondat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThucDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public int Insert(String idMon, String tenMon, String giaTien, String loai) {
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO `menu`(`id_mon`,`ten_mon`, `gia`, `phan_loai`) VALUES (?, ?, ?, ?)");
            pstmt.setString(1, idMon);
            pstmt.setString(2, tenMon);
            pstmt.setString(3, giaTien);
            pstmt.setString(4, loai);
            return pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(PhucVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
