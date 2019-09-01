
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
public class Ex2 {
    public static void main(String[] args) throws  IOException {
        FileInputStream fis=new FileInputStream("file1.dat");
        int c;
        while((c=fis.read())!=-1){
            System.out.print((char) c);
        }
        fis.close();
    }
    
}
