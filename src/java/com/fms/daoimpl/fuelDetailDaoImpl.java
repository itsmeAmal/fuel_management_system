/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fms.daoimpl;

import com.fms.control.commonController;
import com.fms.dao.fuelDetailDao;
import com.fms.databaseconnection.DatabaseConnection;
import com.fms.model.FuelDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Amal
 */
public class fuelDetailDaoImpl implements fuelDetailDao {

    private String selectQuery = "select fuel_detail_id, fuel_detail_fuel_type, fuel_detail_add_date, fuel_detail_qty, fuel_detail_wastage, fuel_detail_from, fuel_detail_note from fuel_detail";

    @Override
    public boolean addFuelDetail(FuelDetail fuelDetail) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into fuel_detail(fuel_detail_fuel_type, fuel_detail_add_date, "
                + " fuel_detail_qty, fuel_detail_wastage, fuel_detail_from, fuel_detail_note) values (?,?,?,?,?,?)");
        ps.setString(1, fuelDetail.getFuelType());
        ps.setDate(2, commonController.getCurrentJavaSqlDate());
        ps.setBigDecimal(3, fuelDetail.getQty());
        ps.setBigDecimal(4, fuelDetail.getWastage());
        ps.setString(5, fuelDetail.getFrom());
        ps.setString(6, fuelDetail.getNote());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean deleteFuelDetail(String fuelType) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from fuel_detail where fuel_detail_fuel_type=?");
        ps.setString(1, fuelType);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public ResultSet getFuelDetailByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return new commonDaoImpl().getResultByAttribute(selectQuery, attribute, condition, value);
    }

    @Override
    public boolean updateFuelDetail(FuelDetail fuelDetail) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update fuel_detail set fuel_detail_qty=?, fuel_detail_wastage=?, fuel_detail_from=? where fuel_detail_fuel_type=?");
        ps.setBigDecimal(1, fuelDetail.getQty());
        ps.setBigDecimal(2, fuelDetail.getWastage());
        ps.setString(3, fuelDetail.getFrom());
        ps.setString(4, fuelDetail.getFuelType());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public ResultSet getAllFuelDetalRecords() throws SQLException {
        return new commonDaoImpl().getAllRecords(selectQuery);
    }

}
