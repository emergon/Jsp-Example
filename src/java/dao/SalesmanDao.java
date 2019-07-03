/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Salesman;
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
 * @author anastasios
 */
public class SalesmanDao extends AbstractDao<Salesman>{

    //private final String URL = "jdbc:mysql://localhost:3306/sales?serverTimezone=UTC";
    //private final String USER = "root";
    //private final String PASS = "1234";
    private final String getAllSalesmen = "SELECT * FROM salesmen";
    private final String insertSalesman = "INSERT INTO salesmen (sname, scity, scomm) VALUES (?,?,?)";
    private final String getSalesmanById = "SELECT * FROM salesmen WHERE scode = ?";
    private final String updateSalesman = "UPDATE salesmen SET sname = ?, scity = ?, scomm = ? WHERE scode = ?";
    private final String deleteSalesman = "DELETE FROM salesmen WHERE scode = ?";
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
        Connection conn = getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
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
            closeResources(pst, rs, conn);
        }
        return list;
    }

    @Override
    public boolean create(Salesman s) {
        boolean created = false;
        Connection conn = getConnection();
        PreparedStatement pst= null;
        try {
            pst = conn.prepareStatement(insertSalesman);
            pst.setString(1, s.getSname());
            pst.setString(2, s.getScity());
            pst.setDouble(3, s.getScomm());
            int result = pst.executeUpdate();
            if(result>0){
                created = true;
            }
        } catch (SQLException ex) {
            System.out.println("#####{SalesmanDao: create} exception#####");
            Logger.getLogger(SalesmanDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeResources(pst, null, conn);
        }
        return created;
    }

    @Override
    public boolean update(Salesman s) {
        boolean updated = false;
        Connection conn = null;
        PreparedStatement pst = null;
        conn = getConnection();
        try {
            pst = conn.prepareStatement(updateSalesman);
            pst.setString(1, s.getSname());
            pst.setString(2, s.getScity());
            pst.setDouble(3, s.getScomm());
            pst.setDouble(4, s.getScode());
            int result = pst.executeUpdate();
            if(result>0){
                updated = true;
            }
        } catch (SQLException ex) {
            System.out.println("#####{SalesmanDao: update} exception#####");
            Logger.getLogger(SalesmanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return updated;
    }

    

    @Override
    public Salesman find(int id) {
        Connection conn = getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Salesman s = null;
        try {
            pst = conn.prepareStatement(getSalesmanById);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            s = new Salesman(rs.getInt(1),
                    rs.getString(2), 
                    rs.getString(3),
                    rs.getDouble(4));
        } catch (SQLException ex) {
            System.out.println("#####{SalesmanDao: find} exception#####");
            Logger.getLogger(SalesmanDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeResources(pst, rs, conn);
        }
        return s;
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
            System.out.println("#####{SalesmanDao: findAll} exception#####");
            Logger.getLogger(SalesmanDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(pst, rs, conn);
        }
        return list;
    }

    @Override
    public boolean delete(int id) {
        boolean deleted = false;
        Connection conn = getConnection();
        PreparedStatement pst = null;
        try{
            pst = conn.prepareStatement(deleteSalesman);
            pst.setInt(1, id);
            int result = pst.executeUpdate();
            if(result>0){
                deleted = true;
            }
        }catch(SQLException ex){
            System.out.println("#####{SalesmanDao: delete} exception#####");
            Logger.getLogger(SalesmanDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeResources(pst, null, conn);
        }
        return deleted;
    }
}
