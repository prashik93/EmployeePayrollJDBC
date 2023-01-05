package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayroll {
    EmployeePayrollDBServiceConnection conn = new EmployeePayrollDBServiceConnection();

    public static void main(String[] args) {
        EmployeePayroll employeePayroll = new EmployeePayroll();
        List<EmployeePayrollData> employeePayrollData = employeePayroll.readData();
        employeePayroll.showEmployee(employeePayrollData);
    }
    public List<EmployeePayrollData> readData() {
        String sql = "SELECT * FROM employee_Payroll";
        List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

        try{
            Connection connection = conn.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                double basicSalary = resultSet.getDouble("employee_salary");
                LocalDate startDate = resultSet.getDate("start_date").toLocalDate();
                employeePayrollList.add(new EmployeePayrollData(id, name, basicSalary, startDate));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeePayrollList;
    }

    public void showEmployee(List<EmployeePayrollData> employeePayrollData) {
        for(int i = 0; i < employeePayrollData.size(); i++) {
            System.out.print("ID : " + employeePayrollData.get(i).employeeId + ", " + "Name : " + employeePayrollData.get(i).employeeName + ", " +
                            "Salary : " + employeePayrollData.get(i).employeeSalary + ", " + "Start_Date : " + employeePayrollData.get(i).startDate);
            System.out.println();
        }
    }
}
