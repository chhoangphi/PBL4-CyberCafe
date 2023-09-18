/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HoaDonNhap;
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
public class HoaDonNhapDAO {
    private static HoaDonNhapDAO instance;
    HoaDonNhap hoadonnhap = new HoaDonNhap();
    
    public HoaDonNhapDAO() {
    }
    
    public static HoaDonNhapDAO getInstance() {
        if (instance == null) {
            instance = new HoaDonNhapDAO();
        }
        return instance;
    }
    
    public static void setInstance(HoaDonNhapDAO instance) {
        HoaDonNhapDAO.instance = instance;
    }

    public HoaDonNhap getHoadonnhap() {
        return hoadonnhap;
    }

    public void setHoadonnhap(HoaDonNhap hoadonnhap) {
        this.hoadonnhap = hoadonnhap;
    }
    
    public List<HoaDonNhap> listHoaDonNhap() {
        List<HoaDonNhap> list = new ArrayList<HoaDonNhap>();
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * from `hoa_don_nhap`");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                HoaDonNhap hoadonnhap = new HoaDonNhap();
                hoadonnhap.setId(rs.getString("id_hoa_don_nhap"));
                hoadonnhap.setDate(rs.getString("ngay_nhap"));
                hoadonnhap.setTotalCost(rs.getDouble("tong_tien"));
                hoadonnhap.setNhacungcap(NhaCungCapDAO.getInstance().getNhacungcapByID(rs.getString("id_ncc")));
                list.add(hoadonnhap);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public HoaDonNhap getHoadonnhapByID(String id) {
        Connection con = DBUtility.openConnection();
        HoaDonNhap hoadonnhap = new HoaDonNhap();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * from `ncc_nguyen_lieu` WHERE `id_ncc_nl`=?");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                hoadonnhap.setId(rs.getString("id_hoa_don_nhap"));
                hoadonnhap.setDate(rs.getString("ngay_nhap"));
                hoadonnhap.setTotalCost(rs.getDouble("tong_tien"));
                hoadonnhap.setNhacungcap(NhaCungCapDAO.getInstance().getNhacungcapByID(rs.getString("id_ncc")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hoadonnhap;
    }
}
