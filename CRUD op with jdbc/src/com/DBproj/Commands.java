package com.DBproj;

public class Commands {
   static String insert =  "insert into student (id , name , email )values (?,?,?)";
   static String update = "update student set name = ?, email = ? where id = ?";
   static String delete = "delete from student where id = ?";
   static String read ="select id , name, email from student";
}
