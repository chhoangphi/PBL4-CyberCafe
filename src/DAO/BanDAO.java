/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Ban;
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
public class BanDAO {
    private static BanDAO instance;

    public BanDAO() {
    }

    public static BanDAO getInstance() {
        if (instance == null) {
            instance = new BanDAO();
        }
        return instance;
    }

    public Ban getBanByID(String id) {
        Connection con = DBUtility.openConnection();
        Ban ban = new Ban();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `ban` WHERE `id_ban` = ?");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ban.setId(rs.getString("id_ban"));
                ban.setSlot(rs.getInt("so_cho"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ban;
    }
    
    public List<Ban> LoadListBan() {
        List<Ban> listTable = new ArrayList<Ban>();
        
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `ban`");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Ban ban = new Ban();
                ban.setId(rs.getString("id_ban"));
                ban.setSlot(rs.getInt("so_cho"));
                ban.setStatus(Integer.parseInt(rs.getString("trang_thai")) == 0 ? "Còn trống" : "Đã đặt");
                listTable.add(ban);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTable;
    }
}
