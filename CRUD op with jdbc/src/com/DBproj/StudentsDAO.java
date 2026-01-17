package com.DBproj;

import java.sql.*;
import java.util.ArrayList;

public class StudentsDAO {
    public static void createStudent(students stnd) throws SQLException {
        Connection conn = DB.dbconn();
        String query = Commands.insert;
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, stnd.getId());
        ps.setString(2,stnd.getName());
        ps.setString(3,stnd.getEmail());

        System.out.println(ps);
        ps.execute();
        ps.close();

    }
    public static ArrayList<students> readStudents() throws SQLException {
        ArrayList<students> stdlist = new ArrayList<>();
        Connection conn = DB.dbconn();
        String query = Commands.read;
        PreparedStatement ps = conn.prepareStatement(query);
        System.out.println(ps);
        ResultSet rs = ps.executeQuery(query);

        while (rs.next()){
            students std = new students(rs.getInt(1),rs.getString(2),rs.getString(3));
            stdlist.add(std);
        }
        ps.close();
        return stdlist;

    }

    public static void updateStudents(int id , String name,String email) throws SQLException {
        Connection conn = DB.dbconn();
        String query = Commands.update;
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(3,id);
        ps.setString(1,name);
        ps.setString(2,email);
        System.out.println(ps);
        ps.execute();
        ps.close();
    }

    public static void deleteStudent(int id) throws SQLException {
        Connection conn = DB.dbconn();
        String query = Commands.delete;
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);

        System.out.println(ps);
        ps.execute();
        ps.close();
    }
}
