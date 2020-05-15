/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fms.control;

import com.fms.daoimpl.fuelDetailDaoImpl;
import com.fms.model.FuelDetail;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Amal
 */
public class fuelDetailCOntrol {

    public static boolean addFuelDetail(String fuelType, BigDecimal qty, BigDecimal wastage, String from, String note) throws SQLException {
        FuelDetail fuelDetail = new FuelDetail();
        fuelDetail.setFuelType(fuelType);
        fuelDetail.setQty(qty);
        fuelDetail.setWastage(wastage);
        fuelDetail.setFrom(from);
        fuelDetail.setNote(note);
        return new fuelDetailDaoImpl().addFuelDetail(fuelDetail);
    }

    public static ResultSet getAllFuelDetails() throws SQLException {
        return new fuelDetailDaoImpl().getAllFuelDetalRecords();
    }

    public static boolean updateFuelDetail(String fuelType, BigDecimal qty, BigDecimal wastage, String from, String note) throws SQLException {
        FuelDetail fuelDetail = new FuelDetail();
        fuelDetail.setFuelType(fuelType);
        fuelDetail.setQty(qty);
        fuelDetail.setWastage(wastage);
        fuelDetail.setFrom(from);
        fuelDetail.setNote(note);
        return new fuelDetailDaoImpl().updateFuelDetail(fuelDetail);
    }
    
    public static boolean deleteFuelDetail(String fuelType)throws SQLException{
        return new fuelDetailDaoImpl().deleteFuelDetail(fuelType);
    }
}
