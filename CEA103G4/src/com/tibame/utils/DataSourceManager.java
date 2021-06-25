package com.tibame.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceManager {

    private static DataSource ds = null;
    static {
        try {
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/admin");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public static DataSource get() {
        return ds;
    }

}
