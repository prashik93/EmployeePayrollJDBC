package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeePayrollDBServiceConnection {
    public Connection getConnection() throws SQLException {
        String DB_URL = "jdbc:mysql://localhost:3306/employee_payroll_db";
        String USER = "root";
        String PASS = "root";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            if(conn!=null)
            {
                System.out.println("\nConnected to Database..");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }
}
