/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Filereadwrite;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author meta
 */
public class writetofile {
    private FileWriter fstream;
    private BufferedWriter out; 
   
    public void OpenFile(String filename, char mode)
    {
        if(filename.equals("")){
            Logger.getLogger(writetofile.class.getName()).log(Level.WARNING, null, "Give a valid file name");
        }
        try{
            fstream=new FileWriter(filename,false);
            
        }catch(Exception ex){
             Logger.getLogger(writetofile.class.getName()).log(Level.SEVERE, null, ex);
        }
        out=new BufferedWriter(fstream);
    }
    public void Write(String text){
        try {
            out.write(text);
        } catch (IOException ex) {
            Logger.getLogger(writetofile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void CloseFile(){
        try {
            fstream.close();
        } catch (IOException ex) {
            Logger.getLogger(writetofile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
