/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fms.servlet;

import com.fms.control.fuelDetailCOntrol;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amal
 */
@WebServlet(name = "addAndUpdateFuelInfo", urlPatterns = {"/addAndUpdateFuelInfo"})
public class addAndUpdateFuelInfo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String saveValue = request.getParameter("save");
            String updateValue = request.getParameter("update");

            String fuelType = request.getParameter("type");
            String qty = request.getParameter("qty");
            String wastage = request.getParameter("wastage");
            String from = request.getParameter("from");
            String note = request.getParameter("note");

            if (saveValue == null) {
                saveValue = "";
            }
            if (updateValue == null) {
                updateValue = "";
            }

            if (saveValue.equalsIgnoreCase("ADD FUEL STOCK INFO")) {
                fuelDetailCOntrol.addFuelDetail(fuelType, new BigDecimal(qty), new BigDecimal(wastage), from, note);
            } else if (updateValue.equalsIgnoreCase("UPDATE FUEL STOCK INFO")) {
                fuelDetailCOntrol.updateFuelDetail(fuelType, new BigDecimal(qty), new BigDecimal(wastage), from, note);
            }
            response.sendRedirect("fuelStockManagement.jsp");

        } catch (SQLException ex) {
            Logger.getLogger(addAndUpdateFuelInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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

}
