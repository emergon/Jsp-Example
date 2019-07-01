/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Salesman;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anastasios
 */
public class SalesmanDao extends AbstractDao<Salesman>{

    //private final String URL = "jdbc:mysql://localhost:3306/sales?serverTimezone=UTC";
    //private final String USER = "root";
    //private final String PASS = "1234";
    private final String getAllSalesmen = "SELECT * FROM salesmen";
    //private Connection conn;

//    private Connection getConnection() {
//        conn = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(URL, USER, PASS);
//        } catch (SQLException e) {
//            System.out.println("######Connection exception######");
//            e.printStackTrace();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(SalesmanDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return conn;
//    }

//    private void closeConnection() {
//        try {
//            conn.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(SalesmanDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

//    private void closeResources(Statement st, ResultSet rs) {
//        try {
//            st.close();
//            rs.close();
//            closeConnection();
//        } catch (SQLException e) {
//            System.out.println("#####Close Resources exception#####");
//        }
//    }

    public List<Salesman> getAllSalesmen() {
        List<Salesman> list = new ArrayList();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = getConnection().prepareStatement(getAllSalesmen);
            rs = pst.executeQuery();
            while (rs.next()) {
                Salesman s = new Salesman();
                s.setScode(rs.getInt(1));
                s.setSname(rs.getString(2));
                s.setScity(rs.getString(3));
                s.setScomm(rs.getDouble(4));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalesmanDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(pst, rs);
        }
        return list;
    }

    @Override
    public boolean create(Salesman t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Salesman t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Salesman t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Salesman find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Salesman> findAll() {
        List<Salesman> list = new ArrayList();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pst = conn.prepareStatement(getAllSalesmen);
            rs = pst.executeQuery();
            while (rs.next()) {
                Salesman s = new Salesman();
                s.setScode(rs.getInt(1));
                s.setSname(rs.getString(2));
                s.setScity(rs.getString(3));
                s.setScomm(rs.getDouble(4));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalesmanDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(pst, rs);
            closeConnection(conn);
        }
        return list;
    }
}
