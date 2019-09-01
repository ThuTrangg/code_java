
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pham Thu Trang
 */
public class ObjectExWrite {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileOutputStream fos=new FileOutputStream("fileobject.dat");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        Strock[] strocks={new Strock(101,"CDC ROw",100.00,10),
            new Strock(102,"DRAM",200.00,30),
            new Strock(103,"P4",200.00,100),
            new Strock(104,"CA",57.00,90),
            new Strock(105,"HP",75.00,320),
            
        };
        oos.writeObject(strocks);
        oos.close();
    }
    
}
