/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

import java.util.ArrayList;

/**
 *
 * @author Pham Thu Trang
 */
public class bai1 {
    public static void main(String[] args) {
    ArrayList a1=new  ArrayList();
    a1.add("Trang");
    a1.add(10);
    a1.add(10.22f);
    a1.add(true);
    String str = (String)a1.get(0);
        System.out.println(str);
    int a = (Integer)a1.get(1);
        System.out.println(a);
    
    float c=(Float)a1.get(2);
        System.out.println(c);
        boolean b=(Boolean)a1.get(3);
        System.out.println(b);
//    float c = (Float)a1.get(3);
//        System.out.println("");    
}
}
