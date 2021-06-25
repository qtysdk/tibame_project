package com.tibame.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUpdater {

    static interface PreparedStatementSetter {
        public void configure(PreparedStatement preparedStatement);
    }

    public void execute(String sql, PreparedStatementSetter preparedStatementSetter) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DataSourceManager.getDataSource().getConnection();
            pstmt = con.prepareStatement(sql);
            preparedStatementSetter.configure(pstmt);
            pstmt.executeUpdate();

            // Handle any SQL errors
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
                    + se.getMessage());
            // Clean up JDBC resources
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }

}
