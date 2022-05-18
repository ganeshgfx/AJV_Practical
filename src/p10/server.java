package p10;

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

        double a,b,sum;
        String result;

        a = Double.parseDouble(br.readLine());
        System.out.println("From Client : "+a);

        b = Double.parseDouble(br.readLine());
        System.out.println("From Client : "+b);

        sum = a+b;
        result = "Sum of "+a+" and "+b+" is "+sum;

        PrintStream ps = new PrintStream(s.getOutputStream());
        ps.print(result);

        br.close();
        ps.close();
        s.close();
        ss.close();
    }

}
