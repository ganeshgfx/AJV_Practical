package p2;

import java.sql.*;

public class code {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
// FIXME: 5/18/22 RUN
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Driver is loaded and register");
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        Connection con = DriverManager.getConnection(url, "system", "ravi");
        System.out.println("Connection is established: " + con);
//building statement object
        Statement st = con.createStatement();
        System.out.println("Statement object created successfully");
//preparing sql statement
        String sql = "select * from emp";
//submitting sql statement
        ResultSet rs = st.executeQuery(sql);
        System.out.println("ID Name Department");
//processing the result
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
        }
        rs.close();
        st.close();
        con.close();
    }
}
