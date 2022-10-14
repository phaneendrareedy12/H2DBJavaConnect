package com.h2.connect;

import java.sql.*;

public class ConnectToH2Database {

    //driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    //credentials
    static final String USER = "sa";
    static final String PASS = "";

    public static void main(String[] args) {
        //createTable();
        insertData();
        fetchData();
    }

    static void createTable() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql =  "CREATE TABLE EMPLOYEE " +
                    "(id INTEGER not NULL, " +
                    " name VARCHAR(255), " +
                    " salary INTEGER, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            System.out.println("table created ************");
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            }
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    static void insertData() {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            String sql = "INSERT INTO EMPLOYEE " + "VALUES (1, 'Ramesh', 2000)";

            stmt.executeUpdate(sql);
            sql = "INSERT INTO EMPLOYEE " + "VALUES (2, 'Suresh', 7000)";

            stmt.executeUpdate(sql);
            sql = "INSERT INTO EMPLOYEE " + "VALUES (3, 'Veeresh', 2500)";

            stmt.executeUpdate(sql);
            sql = "INSERT INTO EMPLOYEE " + "VALUES (4, 'Sukesh', 1000)";

            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table ******");

            stmt.close();
            conn.close();
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            }
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
    }

    static void fetchData() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql = "SELECT id, name, salary FROM EMPLOYEE";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                int salary = rs.getInt("salary");

                System.out.print("ID: " + id);
                System.out.print(", Age: " + name);
                System.out.print(", Salary: " + salary);
                System.out.println();
            }
            rs.close();
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            }
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }

    }
}
}
