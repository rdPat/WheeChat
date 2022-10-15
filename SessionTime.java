/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wheechat;
import java.sql.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author rampa
 */
public class SessionTime  {
     public Connection con;
   SessionTime(){
        LocalDate d= LocalDate.now(); 
        LocalTime t= LocalTime.now();
       
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
           String url="jdbc:mysql://localhost:3306/LoginTimeDirectory";
            String username="root";
            String password="root";
            con=DriverManager.getConnection(url,username,password);
              
        }
        catch(Exception e){
            System.out.print(e);
        }
         
    }
   public static void main(String args[]){
       new SessionTime();
   }
    
}
