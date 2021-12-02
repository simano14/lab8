/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bai5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author phamv
 */
public class echoSever {

    /**
     * @param args the command line arguments
     */
    public final static int echoPort = 7;
    public static void main ()
    {
            ServerSocket theServerSocket;
            Socket theConnectionSocket;
            BufferedReader in;
            PrintWriter out;
            try{
            theServerSocket = new ServerSocket(echoPort);
            System.out.println("EchoServer ready at port "+ echoPort);
            while (true) {
            theConnectionSocket = theServerSocket.accept();
            try {
            System.out.println("Request arrived!");
             in = new BufferedReader(new  InputStreamReader(theConnectionSocket.getInputStream()));
             out = new PrintWriter(theConnectionSocket.getOutputStream(),true);
            while(true) {
            String readText = in.readLine();
            out.println(readText);
            }
            }
            catch (IOException e) {
            theConnectionSocket.close();
            }
            }
            }
            catch (IOException e) {
                System.out.println(e);
      
            }
    }
    
}
