package Database;



import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    public static String result = "";
    private static Connection connection() //throws InstantiationException, IllegalAccessException
    {

        String databaseName = "suppliers_parts_23";
        String userName = "root";
        String password = "root";
        String URL2 = "com.mysql.jdbc.Driver";
        //String URL2 = "com.mysql.cj.jdbc.Driver";
        Connection con = null;
        try {// Load Sun's jdbc driver
            Class.forName(URL2).newInstance();
            System.out.println("JDBC Driver loaded!");
        } catch (Exception e) // driver not found
        {
            System.err.println("Unable to load database driver");
            System.err.println("Details : " + e);
            return null;
        }
        String ip = "localhost"; //internet connection
        String url = "jdbc:mysql://" + ip + ":8889/" + databaseName;
        try {
            con = DriverManager.getConnection(url, userName, password);
            con.setReadOnly(false);
        } catch (Exception e) {
            System.err.println(e.toString());
            return null;
        }
        System.out.println("connection successfull");
        return con;
    }

    public static void closeDatabaseConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            result = e.toString();
            e.printStackTrace();
        }
    }

    public static void listAllSuppliers() {
        Connection con = connection();
        if (con == null) {
            result = "cannot connect to database";
            return;
        }
        String table = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlStr = "SELECT  *  FROM supplier";
        try {
            //prepare statement
            ps = con.prepareStatement(sqlStr);
            //execute
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                String sNumber = rs.getString(1) + " ";
                String sName = rs.getString(2) + " ";
                String sDate = rs.getDate(3).toString() + " ";
                Date d = sqldateToJavaDate(sDate);
                String status = rs.getInt(4) + " ";
                String city = rs.getString(5) + " ";
                table += sNumber + sName + d + status + city + "\n";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                closeDatabaseConnection(con);
                // close the resources 
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        result = table;
    }
    public static Date sqldateToJavaDate (String s){
       int minus1 = s.indexOf("-");
       int minus2 = s.lastIndexOf("-");
       Date d = new Date(0);
       d.setYear(Integer.parseInt(s.substring(0, minus1)));
       d.setMonth(Integer.parseInt(s.substring(minus1+1, minus2)));
       d.setDate(Integer.parseInt(s.substring(minus2 + 1, minus2+2)));
       
       return d;
    }
    
    
    public static void main(String[] args) {
        //Database.connection();
        Database.listAllSuppliers();
        System.out.println(Database.result);
    }



}
