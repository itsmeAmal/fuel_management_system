/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fms.dao;

import com.fms.model.FuelDetail;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Amal
 */
public interface fuelDetailDao {
    
    public boolean addFuelDetail(FuelDetail fuelDetail)throws SQLException;
    
    public boolean deleteFuelDetail(String fuelDetailId)throws SQLException;
    
    public ResultSet getFuelDetailByOneAttribute(String attribute, String condition, String value)throws SQLException;
    
    public boolean updateFuelDetail(FuelDetail fuelDetail)throws SQLException;
    
}
