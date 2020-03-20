package Filereadwrite;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadFromFile {
    private FileReader reader=null;
    private BufferedReader buff=null;
    public void OpenFile(String filename)
    {
        try {
            reader=new FileReader(filename);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFromFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        buff=new BufferedReader(reader);
    }
    public String Read(){
        try {
            String line = null;
            if((line=buff.readLine())!=null)
            {
                return line;
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return "-1";
    }
}
