
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pham Thu Trang
 */
public class data1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("filedata.dat");
        DataOutputStream dos=new DataOutputStream(fos);
        final int NUMBER=5;
        dos.write(NUMBER);
        for(int i=0;i<=NUMBER;i++){
            dos.write(i);
        }
        dos.writeUTF("HELLO!");
        dos.writeDouble(100.75);
        dos.flush();
       dos.close();
        
    }
    
}
