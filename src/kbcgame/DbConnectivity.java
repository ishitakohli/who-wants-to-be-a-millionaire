

package kbcgame;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnectivity
{
    
    public static Connection connect()
    {
        Connection con = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql:///db", "KBC", "123");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return con;
    }
}
