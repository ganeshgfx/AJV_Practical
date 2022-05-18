package p9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class client {
    public static void main(String[] args)  throws Exception {
        Socket s = new Socket("localhost",5655);
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        String rad;
        System.out.println("Enter the radius of Circle");
        rad = br1.readLine();
        PrintStream ps = new PrintStream(s.getOutputStream());
        ps.println(rad);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String result = br.readLine();
        System.out.println("From server :"+result);
        br.close();
        br1.close();
        ps.close();
        s.close();
    }

}
