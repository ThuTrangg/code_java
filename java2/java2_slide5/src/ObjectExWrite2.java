
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pham Thu Trang
 */
public class ObjectExWrite2 {
    public static void main(String[] args) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try{
            fis =new FileInputStream("fileobject.dat");
        ois=new ObjectInputStream(fis);
        Strock[] strocks1=(Strock[])ois.readObject();
        for(Strock s:strocks1){
                System.out.println(s);
        }
        ois.close();
        fis.close();
    }
    catch(Exception e){
            System.out.println("Co loi:"+e);
}
}
}