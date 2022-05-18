package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class code {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded & registered.");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajv", "root",
                "");
        System.out.println("Connection established.");
        Statement st = con.createStatement();
        System.out.println("Statement created.");
// insert
        String sql = "Insert into EMP12 values(101,'Ganesh',10000)";
        st.executeUpdate(sql);
        System.out.println("1 row created");
//update
        String sql1 = "Update EMP12 set id = 102 where name='Ganesh'";
        st.executeUpdate(sql1);
        System.out.println("1 row updated");
//delete
        String sql2 = "Delete from EMP12 where id = 103";
        st.executeUpdate(sql2);
        System.out.println("1 row deleted");
        st.close();
        con.close();
    }
}
