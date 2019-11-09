package searchroom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PRANJAL
 */
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;*/
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.sql.*;
import java.util.*;

public class Cursor {

    /*public void update_waitTable(String Username, String location, String hotelName){
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:C:\\Users\\Deepak George\\Documents\\NetBeansProjects\\SearchRoom\\Data\\HMS.sqlite";
            conn = DriverManager.getConnection(url);
            Statement stmt = (Statement) conn.createStatement();
            String query = "select * from waitList where Location = '"+location+"' and HotelName = '"+hotelName+"'";
            ResultSet rst = stmt.executeQuery(query);
            while (rst.next()){
                int pref = Integer.parseInt(rst.getString(10));
                String Location = rst.getString(1);
                String HotelName = rst.getString(2);
                String UserID = rst.getString(3);
                String FromDate = rst.getString(4);
                String ToDate = rst.getString(5);
                String Rooms = rst.getString(6);
                String Guests = rst.getString(7);
                String RefNumber = rst.getString(8);
                String Cost = rst.getString(9);
                
                
                System.out.println(pref);
                if (pref == 1){ 
                    conn.close();
                    Connection c1 = null;
                    Statement updateQuery = (Statement) c1.createStatement();
                    String url1 = "jdbc:sqlite:C:\\Users\\Deepak George\\Documents\\NetBeansProjects\\SearchRoom\\Data\\HMS.sqlite";
                    c1 = DriverManager.getConnection(url1);
                    
                    String u_query = "delete from 'waitList' where Location = '"+location+"' and hotelName = '"+hotelName+"' and Preference = '"+Integer.toString(pref)+"'";
                    try{
                        updateQuery.executeUpdate(u_query);
                    }
                    catch(SQLException e){
                        c1.close();
                        System.out.println("catch !!!!!!!");
                    }
                    System.out.println(rst.getString("Location"));
                    String insert_query = "insert into 'GuestData' (Location, HotelName, UserID, FromDate, ToDate, Rooms, Guests, RefNumber, Cost)values ('"+Location+"', '"+HotelName+"', '"+UserID+"', '"+FromDate+"', '"+ToDate+"', '"+Rooms+"', '"+Guests+"', '"+RefNumber+"', '"+Cost+"')";
                    try{
                        insert(insert_query);
                    }
                    catch(Exception e){
                        System.out.println("catch !!!!!!!");
                    }
                    break;
                }
                else {
                    pref --;
                    String u_query = "update 'waitList' Preference = '"+Integer.toString(pref)+"' where Location = '"+location+"' and HotelName = '"+hotelName+"'";
                    Statement stmt1 = (Statement) conn.createStatement();
                    try{
                        stmt1.executeUpdate(u_query);
                    }
                    catch(Exception e){
                        System.out.println("catch !!!!!!!");
                    }
                }
                
            }
            //conn.close();
            //System.out.println("closed");
        }
        catch(SQLException e){
            System.out.println("bahar wala");
            e.printStackTrace();
        }   
    
    }*/

    public void Rating_Update(String rating,String name){
        Connection conn = null;
        try {
            String name1="";
            String name2="";
            String url = "jdbc:sqlite:C:\\Users\\Deepak George\\Documents\\NetBeansProjects\\SearchRoom\\Data\\HMS.sqlite";
            conn = DriverManager.getConnection(url);
            Statement stmt = (Statement) conn.createStatement();
            //String query = "select * from SignUp where 'Username' = '"+Username+"'";
            String query = "select * from HotelData where Name = '"+name+"'";
            ResultSet rst = stmt.executeQuery(query);
            while(rst.next()){
                 name1= rst.getString("TotalReviews");
                 name2 = rst.getString("Rating");                
            }          
            String var1 = Float.toString((((Float.parseFloat(name1))*(Float.parseFloat(name2)))+(Float.parseFloat(rating)))/((Float.parseFloat(name1))+1));
            String var2=Float.toString(Float.parseFloat(name1)+1);
            String query4 = "update HotelData set Rating = '"+var1+"', TotalReviews = '"+var2+"' where Name = '"+name+"'";
            

      
            stmt.executeUpdate(query4);
            //stmt.executeUpdate(query);
            }catch(SQLException e){                
            }
    }
    public void insertinfo(String name,String feedback){
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:C:\\Users\\Deepak George\\Documents\\NetBeansProjects\\SearchRoom\\Data\\HMS.sqlite";
            conn = DriverManager.getConnection(url);
            Statement stmt = (Statement) conn.createStatement();
            //String query = "select * from SignUp where 'Username' = '"+Username+"'";
            String query = "insert into 'ContactUs'(Name,Feedback)values('"+name+"','"+feedback+"')";
            stmt.executeQuery(query);           
            
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally{
           
        }
    }
    
    public ArrayList<ArrayList<String>> getWaitData(String Username){
        Connection conn = null;
        ArrayList<ArrayList<String>> resultArray = new ArrayList<ArrayList<String>>();

        try {
            String url = "jdbc:sqlite:C:\\Users\\Deepak George\\Documents\\NetBeansProjects\\SearchRoom\\Data\\HMS.sqlite";
            conn = DriverManager.getConnection(url);
            Statement stmt = (Statement) conn.createStatement();
            //String query = "select * from SignUp where 'Username' = '"+Username+"'";
            String query = "select * from waitList where UserID = '"+Username+"'";
            ResultSet rst = stmt.executeQuery(query);
            
            
            while (rst.next()){
                
                    ArrayList<String> temp = new ArrayList<String>();
                    
                    temp.add(rst.getString(1));
                    temp.add(rst.getString(2));
                    temp.add(rst.getString(4));
                    temp.add(rst.getString(5));
                    temp.add(rst.getString(6));
                    temp.add(rst.getString(7));
                    temp.add(rst.getString(8));
                    temp.add(rst.getString(9));
                    temp.add(rst.getString(10));
                    
                    resultArray.add(temp);
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return resultArray;
    }
    
    public void modify_detail(String cost, String ref, String fromDate, String room){
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:C:\\Users\\Deepak George\\Documents\\NetBeansProjects\\SearchRoom\\Data\\HMS.sqlite";
            conn = DriverManager.getConnection(url);
            Statement stmt = (Statement) conn.createStatement();
            String query = "update 'GuestData' set Rooms = '"+room+"', FromDate = '"+fromDate+"', Cost = '"+cost+"' where RefNumber = '"+ref+"'";
            stmt.executeUpdate(query);
            conn.close();
            System.out.println("closed");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void delete_row(String ref_number){
        System.out.println(ref_number);
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:C:\\Users\\Deepak George\\Documents\\NetBeansProjects\\SearchRoom\\Data\\HMS.sqlite";
            conn = DriverManager.getConnection(url);
            Statement stmt = (Statement) conn.createStatement();
            String query = "delete from 'GuestData' where RefNumber = '"+ref_number+"'";
            stmt.executeUpdate(query);
            conn.close();
            System.out.println("closed");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<ArrayList<String>> getTransactions(String Username){
        Connection conn = null;
        ArrayList<ArrayList<String>> resultArray = new ArrayList<ArrayList<String>>();

        try {
            String url = "jdbc:sqlite:C:\\Users\\Deepak George\\Documents\\NetBeansProjects\\SearchRoom\\Data\\HMS.sqlite";
            conn = DriverManager.getConnection(url);
            Statement stmt = (Statement) conn.createStatement();
            //String query = "select * from SignUp where 'Username' = '"+Username+"'";
            String query = "select * from GuestData";
            ResultSet rst = stmt.executeQuery(query);
            
            
            while (rst.next()){
                if (rst.getString("UserID").equals(Username) == true) {
                    ArrayList<String> temp = new ArrayList<String>();
                    temp.add("false");
                    temp.add(rst.getString(8));
                    temp.add(rst.getString(1));
                    temp.add(rst.getString(2));
                    temp.add(rst.getString(4));
                    temp.add(rst.getString(5));
                    temp.add(rst.getString(6));
                    temp.add(rst.getString(7));
                    temp.add(rst.getString(9));
                
                    resultArray.add(temp);
                
                }
                
            }
            
            
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return resultArray;
    }
    
    public String[] getUserInfo(String Username){
        Connection conn = null;
        String[] resultArray = new String[4];
        try {
            String url = "jdbc:sqlite:C:\\Users\\Deepak George\\Documents\\NetBeansProjects\\SearchRoom\\Data\\HMS.sqlite";
            conn = DriverManager.getConnection(url);
            Statement stmt = (Statement) conn.createStatement();
            //String query = "select * from SignUp where 'Username' = '"+Username+"'";
            String query = "select * from SignUp";
            ResultSet rst = stmt.executeQuery(query);

            
            resultArray[0] = Username;
            while(rst.next()){
                System.out.println("hi");
                if (rst.getString("Username").equals(Username) == true){
                
                    String emailid = rst.getString("EmailID"); 
                    String contact = rst.getString("Contact");
                    String address = rst.getString("Address");
                
                    resultArray[1] = emailid;
                    resultArray[2] = contact;
                    resultArray[3] = address;
                }
            }
            
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally{
            return resultArray;
        }
    }
    
    public  int login_page(String user,String pass) {
        Connection conn = null;
        
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\Deepak George\\Documents\\NetBeansProjects\\SearchRoom\\Data\\HMS.sqlite";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            Statement stmt = (Statement) conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from SignUp");
            while(rs.next()){
                String s1 = rs.getString("Username"); 
                String s2 = rs.getString("Password");
                if(s1.equals(user)==true && s2.equals(pass)==true){
                    
                    return 1;                    
                }
            }          
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
           
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return 0;
    }
 
    public static int popup_message(String user) {
        Connection conn = null;
        int flag =0;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\Deepak George\\Documents\\NetBeansProjects\\SearchRoom\\Data\\HMS.sqlite";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            Statement stmt = (Statement) conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from SignUp");
            while(rs.next()){
                String s = rs.getString("Username");
                if(s.equals(user)==true){
                    JOptionPane.showMessageDialog(null, "Same Username Try again");
                    return 1;                    
                }
            }          
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
           
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return 0;
    }

    public static void update_table(String query) {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\Deepak George\\Documents\\NetBeansProjects\\SearchRoom\\Data\\HMS.sqlite";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            Statement stmt = (Statement) conn.createStatement();
            
            stmt.execute(query);           
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
        static int[][] d  = new int[][]
                {
                        {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                        {1, 2, 3, 4, 0, 6, 7, 8, 9, 5},
                        {2, 3, 4, 0, 1, 7, 8, 9, 5, 6},
                        {3, 4, 0, 1, 2, 8, 9, 5, 6, 7},
                        {4, 0, 1, 2, 3, 9, 5, 6, 7, 8},
                        {5, 9, 8, 7, 6, 0, 4, 3, 2, 1},
                        {6, 5, 9, 8, 7, 1, 0, 4, 3, 2},
                        {7, 6, 5, 9, 8, 2, 1, 0, 4, 3},
                        {8, 7, 6, 5, 9, 3, 2, 1, 0, 4},
                        {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}
                };
        static int[][] p = new int[][]
                {
                        {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                        {1, 5, 7, 6, 2, 8, 3, 0, 9, 4},
                        {5, 8, 0, 3, 7, 9, 6, 1, 4, 2},
                        {8, 9, 1, 6, 0, 4, 3, 5, 2, 7},
                        {9, 4, 5, 3, 1, 2, 6, 8, 7, 0},
                        {4, 2, 8, 6, 5, 7, 3, 9, 0, 1},
                        {2, 7, 9, 3, 8, 0, 6, 4, 1, 5},
                        {7, 0, 4, 6, 9, 1, 3, 2, 5, 8}
                };
        static int[] inv = {0, 4, 3, 2, 1, 5, 6, 7, 8, 9};

        public static boolean validateVerhoeff(String num){
            int c = 0;
            int[] myArray = StringToReversedIntArray(num);
            for (int i = 0; i < myArray.length; i++){
                c = d[c][p[(i % 8)][myArray[i]]];
            }

            return (c == 0);
        }
        private static int[] StringToReversedIntArray(String num){
            int[] myArray = new int[num.length()];
            for(int i = 0; i < num.length(); i++){
                myArray[i] = Integer.parseInt(num.substring(i, i + 1));
            }
            myArray = Reverse(myArray);
            return myArray;
        }
        private static int[] Reverse(int[] myArray){
            int[] reversed = new int[myArray.length];
            for(int i = 0; i < myArray.length ; i++){
                reversed[i] = myArray[myArray.length - (i + 1)];
            }
            return reversed;
        } 

    public static void insert(String query) {
        Connection conn = null;
        
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\Deepak George\\Documents\\NetBeansProjects\\SearchRoom\\Data\\HMS.sqlite";
            // create a connection to the database
            conn = DriverManager.getConnection(url);            
            Statement stmt = conn.createStatement();
            try{
                ResultSet rs = stmt.executeQuery(query);
            System.out.println("Connection to SQLite has been established.");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
 
            finally{
                stmt.close();
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public static String getPref(String query){
        
         Connection conn = null;
        int pref=1;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\Deepak George\\Documents\\NetBeansProjects\\SearchRoom\\Data\\HMS.sqlite";
            // create a connection to the database
            conn = DriverManager.getConnection(url);            
            Statement stmt = conn.createStatement();
            try{
                ResultSet rs = stmt.executeQuery(query);
            System.out.println("Connection to SQLite has been established.");
            while (rs.next()){
                //int id = rs.getInt("id");
                
                 pref+=1;
        
        // print the results
                
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
 
            finally{
                stmt.close();
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return Integer.toString(pref);
    }
        
        
     
   
    
    
    public String[][] getData(String location) {
        Connection conn = null;
        
        String [][] resultArray = new String[4][9];
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\Deepak George\\Documents\\NetBeansProjects\\SearchRoom\\Data\\HMS.sqlite";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            //PreparedStatement stmt;
            Statement stmt = conn.createStatement();
            try{
                //String query = "select distinct Name,Cost,Rating,Reviews,WiFi,Breakfast,CarRentals,Toiletries from 'HotelData' where Location = '"+location+"'";
                String query = "select distinct * from 'HotelData' where Location = '"+location+"'";
                
                ResultSet rs = stmt.executeQuery(query);
                int counter = 0;
                while (rs.next()){
                    String [] temp = new String[9];
                    temp[0] = "false";
                    temp[1] = rs.getString(2);
                    temp[2] = rs.getString(3);
                    temp[3] = rs.getString(5);
                    temp[4] = rs.getString(6);
                    temp[5] = rs.getString(7);
                    temp[6] = rs.getString(8);
                    temp[7] = rs.getString(9);
                    temp[8] = rs.getString(10);
                    
                    resultArray[counter] = temp;
                    counter ++;
                }
                
            }
            catch (Exception e){
                
                System.out.println(e.getMessage());
            }
 
            finally{
                stmt.close();
            }
            
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultArray;
    }
        
    public static boolean[] roomCount(String query,String noofroomText) {
        Connection conn = null;        
         int[][] roomcount = new int[4][60];
                for(int i=0;i<4;i++){
                    for(int j=0;j<60;j++){
                        roomcount[i][j] = 150;
                    }
                }
               boolean [] availabilityCheck = new  boolean [4];
            for(int y=0;y<4;y++) availabilityCheck[y] = true;
          String[] hotellist = new String[]{"Clairon Hotel","The Mount Regency","Liberty Park","MGM Beach Resorts","Delhi Empire Dx","Radisson Hotel","Grand Heritage Resort",
           "Sri Sri Residency","The LaLit","Mango Hotel","Indana Palace","Souvenir Prime","The Ambassador","Parle International","The Oriental Residency" ,
            "Golden Chariot","Noor-Us-Subah Palace","Jehanuma Palace","Shalimar Deluxe","Golden Lakes Hotel"};
         
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\Deepak George\\Documents\\NetBeansProjects\\SearchRoom\\Data\\HMS.sqlite";
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            try{
                ResultSet rs = stmt.executeQuery(query);
                int counter = 0;
               int noofrooms_int = Integer.parseInt(noofroomText);
               
                
                  
                   
              
            while (rs.next()){                
                String fDate = rs.getString("FromDate");
                String tDate = rs.getString("ToDate");
                String hName = rs.getString("HotelName");
                int noofrooms =rs.getInt("Rooms");       
                  int rowno=0;
                  int roomcount_index=0;
                
                for(int o=0;o<20;o++){
                    if(hotellist[o].equals(hName) == true){
                        rowno=o+1;
                        break;
                    }
                }
                int temp = (rowno)%4;
                    if(temp == 1){
                        roomcount_index = 0;                    
                    }
                    else if(temp == 2){
                        roomcount_index = 1;
                    }else if(temp == 3){
                        roomcount_index = 2;                    
                    }else if(temp == 0){
                        roomcount_index = 3;                    
                    }
                    
                
                int f_date = Integer.parseInt(fDate.split("/", 0)[0]);
                int f_month = Integer.parseInt(fDate.split("/", 0)[1]);
                int t_date = Integer.parseInt(tDate.split("/", 0)[0]);
                int t_month = Integer.parseInt(tDate.split("/", 0)[1]);
                int startindex=0;
                int endindex=0;
                
                if(f_month == 11) startindex = f_date-1;
                else startindex = 29 + f_date;
                
                if(t_month == 11) endindex = t_date-1;
                else endindex = 29 + t_date;
                
                int min=150;
                
                for(int p=startindex;p<=endindex;p++){
                    
                    roomcount[roomcount_index][p] -= noofrooms;
                    if(roomcount[roomcount_index][p] < min){
                        min = roomcount[roomcount_index][p];
                    }
                }
                
                if(min < noofrooms_int){
                    availabilityCheck[roomcount_index] = false;
                }
               
                }

            }
            catch (Exception e){
                System.out.println("Exception exec");
                System.out.println(e.getMessage());
            }
 
            finally{               
                stmt.close();
            }
            
        }
        
        catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }  
            return availabilityCheck;
        }
        
        
    }        

        
 
    public static void main(String args[]){
        String a = "Smit";
        //INSERT INTO GuestData ('Location', 'Hotel Name', 'Account Name') VALUES ('Chennai', 'Clairon Hotel', '"+a+"')
        //connect("DELETE * FROM GuestData");
    }
    
}
