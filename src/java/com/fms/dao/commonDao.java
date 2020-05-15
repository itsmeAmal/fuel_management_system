package com.fms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface commonDao {

    ResultSet getResultByAttribute(String selectQuery, String attribute, String condition, String value) throws
            SQLException;

    ResultSet getAllRecords(String selectQuery) throws SQLException;

}
