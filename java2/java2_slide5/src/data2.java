
import java.io.DataInputStream;
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
public class data2 {
    public static void main(String[] args) throws  IOException {
        FileInputStream fis=new FileInputStream("filedata.dat");
        DataInputStream dis=new DataInputStream(fis);
        int items=dis.readInt();
        for(int i=0;i<=items;i++){
            int n=dis.readInt();
            System.out.print(n+ " ");
        }
        System.out.println(dis.readUTF());
        System.out.println(dis.readDouble());
        dis.close();
    }
    
}
