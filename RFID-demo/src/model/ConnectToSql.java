package model;

/**
 *
 * @author Dev
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ConnectToSql {

    public static Connection con;

    public static ResultSet select(String sql) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String pathNameSQL=model.FileIO.readPathNameSQL();
            //System.out.println(pathNameSQL);
            //LANGDUONG-PC\\SQLEXPRESS
            con = DriverManager.getConnection("jdbc:sqlserver://"+pathNameSQL+":1433;databaseName=CHECKIN;integratedSecurity=true");
            java.sql.Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);

            return rs;
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return null;
    }

    public static boolean update(String sql) {
        boolean flag = false;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://LANGDUONG-PC\\SQLEXPRESS:1433;databaseName=CHECKIN;integratedSecurity=true");
            java.sql.Statement s = con.createStatement();
            s.executeUpdate(sql);
            flag = !flag;
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return flag;
    }
}
