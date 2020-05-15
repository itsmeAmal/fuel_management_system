/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fms.control;

import java.math.BigDecimal;

/**
 *
 * @author Amal
 */
public class commonController {

    public static java.sql.Date getCurrentJavaSqlDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public static java.sql.Time getCurrentJavaSqlTime() {
        java.util.Date date = new java.util.Date();
        return new java.sql.Time(date.getTime());
    }

    public static BigDecimal getBigDecimalOrZeroFromString(String value) {
        if (value != null) {
            value = value.replaceAll(",", "");
        }
        if (isBigDecimal(value)) {
            return new BigDecimal(value);
        } else {
            return BigDecimal.ZERO;
        }
    }

    public static boolean isBigDecimal(String value) {
        try {
            if (value != null) {
                value = value.replaceAll(",", "");
            }
            new BigDecimal(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
