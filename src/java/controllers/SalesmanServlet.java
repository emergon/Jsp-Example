/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import services.SalesmanService;

/**
 *
 * @author anastasios
 */
public class SalesmanServlet extends HttpServlet {
    
    private SalesmanService service;
    
    /*Different way of Implementing Datasource
    @Resource(name="jdbc/sales")
    private DataSource dataSource;
    @Override
    public void init() throws ServletException {
        super.init(); 
        try{
            service = new SalesmanService(dataSource);
        }catch(Exception e){
    
        }
    }
    */
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("salesman/Salesmen.jsp");
        request.setAttribute("salesmen", getService().getAllSalesmen());
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private SalesmanService getService(){
        if(service == null){
            service = new SalesmanService();
        }
        return service;
    }
}
