package p3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class code {
    public static void main(String[] args) throws ClassNotFoundException, SQLException,
            IOException {
        int i, sid;
        float cpi;
        String sname;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Driver is loaded and register");
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        Connection con = DriverManager.getConnection(url, "system", "ravi");
        System.out.println("Connection is established : " + con);
        PreparedStatement ps1 = con.prepareStatement("insert into stud1 values(?,?,?)");
        PreparedStatement ps2 = con.prepareStatement("delete from stud1 where sid=?");
        System.out.println("Prepared Statement Successfully Created...");
        Scanner sr = new Scanner(System.in);
        do {
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("0. Exit");
            System.out.println("Enter Your Choice");
            i = sr.nextInt();
            if (i == 1) {
                System.out.println("Enter Student ID:");
                sid = sr.nextInt();
                System.out.println("Enter Student Name");
                sname = sr.next();
                System.out.println("Enter Student CPI");
                cpi = sr.nextFloat();
                ps1.setInt(1, sid);
                ps1.setString(2, sname);
                ps1.setFloat(3, cpi);
                ps1.executeUpdate();
                System.out.println("Data is Inserted");

            } else if (i == 2) {
                System.out.println("Enter the Student ID");
                sid = sr.nextInt();
                ps2.setInt(1, sid);
                ps2.executeUpdate();
                System.out.println("Selected Row is Deleted");
            } else if (i != 0) {
                System.out.println("Invalid Choice....!!!");
            } else {
                System.out.println("Exit...!!!!");
            }
        } while (i != 0);
        sr.close();
        ps2.close();
        ps1.close();
        con.close();
    }
}
