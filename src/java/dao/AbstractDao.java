/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author anastasios
 */
public abstract class AbstractDao<T> implements Dao<T> {

    protected final DataSource ds = init();

    private DataSource init() {
        DataSource dataSource = null;
        try {
            Context initContext = new InitialContext();
            dataSource = (DataSource) initContext.lookup("java:/comp/env/jdbc/sales");
        } catch (NamingException ex) {
            System.out.println("#####DataSource exception#####");
            Logger.getLogger(AbstractDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataSource;
    }

    protected Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException ex) {
            System.out.println("#####Connection exception#####");
            Logger.getLogger(AbstractDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    protected void closeResources(Statement st, ResultSet rs) {
        try {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbstractDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected void closeConnection(Connection conn) {
        try {
            //Doesn't really close connection but returns it to the connection pool
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbstractDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
