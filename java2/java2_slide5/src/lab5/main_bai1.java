/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.io.IOException;

/**
 *
 * @author Pham Thu Trang
 */
public class main_bai1 {
    public static void main(String[] args) throws IOException{
        byte[]data=XFile.read("c:/Temp/a1.txt");
        XFile.write("c:/Temp/b1.txt", data);
    }
    
}
