/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bai4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author phamv
 */
public class daytimeServer {

    /**
     * @param args the command line arguments
     */
    public final static int daytimePort = 13;
    public static void main(String[] args) 
    {
        ServerSocket theServerSocket;
        Socket theConnectionSocket;
        PrintWriter out;
        try {
        theServerSocket = new ServerSocket(daytimePort);
        System.out.println("TimeServer ready at port "+daytimePort);
        try {
        while (true) {
        theConnectionSocket = theServerSocket.accept();
        System.out.println("Request arrived!");
        out = new PrintWriter(theConnectionSocket.getOutputStream(), true);
        out.println(new Date());
        theConnectionSocket.close();
        }
        }
        catch (IOException e) {
        theServerSocket.close();
        InterruptedException(e);
        }
         }
        catch (IOException e) {
        InterruptedException(e);
        }
    }

    private static void InterruptedException(IOException e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
