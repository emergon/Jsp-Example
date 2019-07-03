/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Salesman;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        String command = request.getParameter("command");
        if (command == null) {
            command = "LIST";
        }
        switch (command) {
            case "LIST":
                listSalesmen(request, response);
                break;
            //if we keep ADD in here then in every reload, the app will insert the same entity.
            //So move ADD to the POST method
//            case "ADD":
//                doInsert(request, response);
//                break;
            case "LOAD":
                doLoad(request, response);
                break;
            case "UPDATE":
                doUpdate(request, response);
                break;
            case "REMOVE":
                doRemove(request, response);
                break;
            default:
                break;
        }

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
        String command = request.getParameter("command");
        switch (command) {
            case "ADD":
                doInsert(request, response);
                break;
            default:
                listSalesmen(request, response);

        }
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

    private void listSalesmen(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("salesman/Salesmen.jsp");
        request.setAttribute("salesmen", getService().getAllSalesmen());
        dispatcher.forward(request, response);
    }

    private void doInsert(HttpServletRequest request, HttpServletResponse response) {

        try {
            Salesman s = new Salesman(
                    request.getParameter("sname"),
                    request.getParameter("scity"),
                    Double.parseDouble(request.getParameter("scomm")));
            boolean created = getService().create(s);
            if (created) {
                //listSalesmen(request, response);
                response.sendRedirect("Salesman");
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                //request.setAttribute("error", "insertionFailed");
                dispatcher.forward(request, response);
            }

        } catch (IOException | ServletException ex) {
            Logger.getLogger(SalesmanServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void doLoad(HttpServletRequest req, HttpServletResponse res) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("salesman/SalesmanUpdate.jsp");
        try {
            int scode = Integer.parseInt(req.getParameter("id"));
            Salesman s = getService().getSalesmanById(scode);
            req.setAttribute("salesman", s);
            dispatcher.forward(req, res);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(SalesmanServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) {
        Salesman s = new Salesman(Integer.parseInt(request.getParameter("id")),
                request.getParameter("sname"),
                request.getParameter("scity"),
                Double.parseDouble(request.getParameter("scomm")));
        boolean updated = getService().update(s);
        try {
            if (updated) {
                listSalesmen(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                dispatcher.forward(request, response);
            }
        } catch (IOException | ServletException ex) {
            Logger.getLogger(SalesmanServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void doRemove(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean deleted = getService().delete(id);
        try {
            if (deleted) {
                listSalesmen(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                dispatcher.forward(request, response);
            }
        } catch (IOException | ServletException ex) {
            Logger.getLogger(SalesmanServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private SalesmanService getService() {
        if (service == null) {
            service = new SalesmanService();
        }
        return service;
    }
}
