package com.fms.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fms.control.commonConstatns.commonConstants;
import com.fms.dao.commonDao;
import com.fms.databaseconnection.DatabaseConnection;

public class commonDaoImpl implements commonDao {

    @Override
    public ResultSet getResultByAttribute(String selectQuery, String attribute, String condition, String value) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement(selectQuery + commonConstants.Sql.WHERE + attribute + condition
                + commonConstants.Sql.PARAMETER);

        ps.setString(1, value);
        ResultSet rst = ps.executeQuery();
        return rst;
    }

    @Override
    public ResultSet getAllRecords(String selectQuery) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement(selectQuery);
        ResultSet rst = ps.executeQuery();
        return rst;
    }

}
