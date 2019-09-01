

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
public class Ex1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("file1.dat");
        String text="The quick browwn fox jumped over the lazy dog";
        byte[] textAsbytes=text.getBytes();
        fos.write(textAsbytes);
    }
    
}
