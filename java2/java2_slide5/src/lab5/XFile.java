/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Pham Thu Trang
 */
public class XFile {   
  public static byte[] read(String path)throws  IOException {  
      
      try{
          FileInputStream fis=new FileInputStream(path);
          int n =fis.available();
          byte[] data=new byte[n];
       fis.read(data);
       fis.close();
       return data;
      }
      catch(Exception e){
       throw new RuntimeException(e);   
      }
  }
  public  static void write(String path,byte[] data) {
   try{
       FileOutputStream fos=new FileOutputStream(path);
       fos.write(data);
       fos.close();
   }
   catch(Exception e2){
       //throw new RuntimeException(e2);
       System.out.println(e2);
   }
  }

   public static Object readObject(String path) throws IOException {
    try {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        Object object = ois.readObject();
        ois.close();
        return object;
    }
    catch (Exception e3) {
    throw new RuntimeException(e3);
    }
}
public static void writeObject(String path, Object object) {
    try {
           ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream(path));
           oos.writeObject(object);
           oos.close();
   }
   catch (Exception e4) {
      // throw new RuntimeException(e4);
       System.out.println(e4);
   }
}

}
