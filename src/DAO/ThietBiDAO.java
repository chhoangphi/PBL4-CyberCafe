/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NCCInternet;
import DTO.ThietBi;
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
public class ThietBiDAO {
    private static ThietBiDAO instance;
    ThietBi thietbi = new ThietBi();

    public ThietBiDAO() {
    }
    
    public static ThietBiDAO getInstance() {
        if (instance == null) {
            instance = new ThietBiDAO();
        }
        return instance;
    }
    
    public static void setInstance(ThietBiDAO instance) {
        ThietBiDAO.instance = instance;
    }

    public ThietBi getThietbi() {
        return thietbi;
    }

    public void setThietbi(ThietBi thietbi) {
        this.thietbi = thietbi;
    }
    
    public NCCInternet getNCCInternetByID(String id) {
        Connection con = DBUtility.openConnection();
        NCCInternet nccinternet = new NCCInternet();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * from `nha_cc_tb` WHERE `id_ncc_tb`=?");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();           
            while (rs.next()) {
                nccinternet.setId(id);
                nccinternet.setName(rs.getNString("ten_ncc"));
                nccinternet.setAddress(rs.getNString("dia_chi"));
                nccinternet.setPhoneNumber(rs.getNString("so_dien_thoai"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThietBiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nccinternet;
    }
    
    public List<ThietBi> getListThietBi() {
        List<ThietBi> list = new ArrayList<ThietBi>();
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * from `thiet_bi_cc_internet`");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                ThietBi thietbi = new ThietBi();
                thietbi.setId(rs.getString("id_thiet_bi"));
                thietbi.setName(rs.getNString("ten_thiet_bi"));
                thietbi.setPrice(rs.getDouble("gia"));
                thietbi.setNccinternet(getNCCInternetByID(rs.getString("id_ncc_tb")));
                list.add(thietbi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThietBiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ThietBi getThietbiByID(String id) {
        Connection con = DBUtility.openConnection();
        ThietBi thietbi = new ThietBi();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * from `thiet_bi_cc_internet` WHERE `id_thiet_bi`=?");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                thietbi.setId(rs.getString("id_thiet_bi"));
                thietbi.setName(rs.getNString("ten_thiet_bi"));
                thietbi.setPrice(rs.getDouble("gia"));
                thietbi.setNccinternet(getNCCInternetByID(rs.getString("id_ncc_tb")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThietBiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return thietbi;
    }
}
