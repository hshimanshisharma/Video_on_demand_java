

import java.sql.*;

public class DBLoader {
    static ResultSet executeQuery(String sql) throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver Loaded");
        
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vod","root","system");
        System.out.println("connection done");
        
        Statement stmt= conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        System.out.println("Statement done");
        
        ResultSet rs= stmt.executeQuery(sql);
        System.out.println("ResultSet created");
        
        return rs;
    }
}
