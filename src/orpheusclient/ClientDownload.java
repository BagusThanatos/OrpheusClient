/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orpheusclient;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BagusThanatos (github.com/BagusThanatos)
 */
public class ClientDownload {
    private static ClientDownload c= new ClientDownload();
    Socket s;
    private Downloading d;
    public ClientDownload(){
        try {
            s= new Socket("127.0.0.1", 10001);
        } catch (IOException ex) {
            Logger.getLogger(ClientDownload.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static ClientDownload getInstance(){
        return c;
    }
    public void setGUI(Downloading d){
        this.d=d;
    }
    public void download(){
        try {
            PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
            pw.println(d.getU().getEmail()+" "+d.getA().getId_album());
            System.out.println("here");
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            int size= 50000000;
            System.out.println("here");
            byte [] mybytearray  = new byte [size];
            File f= new File("/albums/"+d.getA().getNamaAlbum()+".zip");
            
            f.createNewFile();
            System.out.println(f.getAbsolutePath());
            InputStream is = s.getInputStream();
            FileOutputStream fos = new FileOutputStream(f);
            System.out.println("here");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            int bytesRead = is.read(mybytearray,0,mybytearray.length);
            //pw.print("s");
            int current = bytesRead;
            do {
                bytesRead =is.read(mybytearray, current, (mybytearray.length-current));
                if(bytesRead >= 0) current += bytesRead;
            } while(bytesRead > -1);
            bos.write(mybytearray, 0 , current);
            bos.flush();
        } catch (IOException ex) {
            Logger.getLogger(ClientDownload.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
