package p9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args)  throws Exception {
        ServerSocket ss = new ServerSocket(5655);
        Socket s=ss.accept();
        System.out.println("Client Get connected");
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        double rad,area;
        String result;
        rad = Double.parseDouble(br.readLine());
        System.out.println("From Client : "+rad);
        area = 3.14*rad*rad;
        result = "Area is :"+area;
        PrintStream ps = new PrintStream(s.getOutputStream());
        ps.print(result);
        br.close();
        ps.close();
        s.close();
        ss.close();
    }

}
