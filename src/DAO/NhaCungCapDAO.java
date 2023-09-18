/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhaCungCap;
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
public class NhaCungCapDAO {
    private static NhaCungCapDAO instance;
    NhaCungCap nhacungcap = new NhaCungCap();

    public NhaCungCapDAO() {
    }
    
    public static NhaCungCapDAO getInstance() {
        if (instance == null) {
            instance = new NhaCungCapDAO();
        }
        return instance;
    }
    
    public static void setInstance(NhaCungCapDAO instance) {
        NhaCungCapDAO.instance = instance;
    }

    public NhaCungCap getNhacungcap() {
        return nhacungcap;
    }

    public void setNhacungcap(NhaCungCap nhacungcap) {
        this.nhacungcap = nhacungcap;
    }
    
    public List<NhaCungCap> listNhaCungCap() {
        List<NhaCungCap> list = new ArrayList<NhaCungCap>();
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * from `ncc_nguyen_lieu`");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                NhaCungCap nhacungcap = new NhaCungCap();
                nhacungcap.setId(rs.getString("id_ncc_nl"));
                nhacungcap.setName(rs.getNString("ten_ncc"));
                nhacungcap.setAddress(rs.getNString("dia_chi"));
                nhacungcap.setPhoneNumber(rs.getString("so_dien_thoai"));
                list.add(nhacungcap);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public NhaCungCap getNhacungcapByID(String id) {
        Connection con = DBUtility.openConnection();
        NhaCungCap nhacungcap = new NhaCungCap();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * from `ncc_nguyen_lieu` WHERE `id_ncc_nl`=?");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                nhacungcap.setId(id);
                nhacungcap.setName(rs.getNString("ten_ncc"));
                nhacungcap.setAddress(rs.getNString("dia_chi"));
                nhacungcap.setPhoneNumber(rs.getNString("so_dien_thoai"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nhacungcap;
    }
}
