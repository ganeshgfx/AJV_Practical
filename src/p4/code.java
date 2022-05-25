package p4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class code {
    public static void main(String[] args) throws ClassNotFoundException, SQLException,
            Exception {
// TODO Auto-generated method stub
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Driver is loaded and register.");
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        Connection con = DriverManager.getConnection(url, "system", "ravi");
        System.out.println("Connection is established : " + con);
        java.sql.CallableStatement cst = con.prepareCall("{call proc1(?,?)}");
        cst.registerOutParameter(2, Types.VARCHAR);
        cst.setInt(1, 002);
        cst.execute();
        String str = cst.getString(2);
        System.out.println("Employee Name: " + str);
    }
}
