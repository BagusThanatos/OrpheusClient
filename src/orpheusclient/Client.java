/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orpheusclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BagusThanatos (github.com/BagusThanatos)
 */
public class Client {
    private static Client c = new Client();
    private Socket s;
    BufferedReader br = null;
    private Client(){
        try {
            this.s=new Socket("127.0.0.1", 10000);
            br= new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Client getInstance(){
        return c;
    }
    public void sendData(String string){
        PrintWriter pw = null;
        
        try {
            pw= new PrintWriter(s.getOutputStream(),true);
            pw.println(string+"\n");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public String getData(){
        
        String ss=null;
        try {
            
            ss= br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ss;
    }
}
