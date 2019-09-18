package com.soft.tools;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;

public class DBHelper {


    private static Connection conn = null;
    private static ComboPooledDataSource dataSource;

    static {
        dataSource = new ComboPooledDataSource("myc3p0");
    }

    public static synchronized QueryRunner getQueryRunner() {

        QueryRunner queryRunner = new QueryRunner(dataSource);
        return queryRunner;

    }

}
