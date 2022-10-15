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
public class LogInSession extends SessionTime {
    
    LogInSession(){
        LocalDate d= LocalDate.now(); 
        LocalTime t= LocalTime.now();
        System.out.print("inserted");
        try{
            
            String q="insert into Session(date,logintime)values('"+d+"','"+t+"')";
            PreparedStatement pstmt=con.prepareStatement(q);
            pstmt.executeUpdate();
            System.out.println("Inserted");
            
        }
        catch(Exception e){
            System.out.print(e);
        }
         
    }
    
}
