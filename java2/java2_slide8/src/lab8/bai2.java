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
public class bai2 {
    public static void main(String[] args) {
        ArrayList<Integer> myarrr = new ArrayList<Integer>();
        for(int i=1;i<=10;i++){
         myarrr.add(i);
            
        }
        
        for(int i=0;i<10;i++){
            int a=myarrr.get(i);
             System.out.println("In ra :"+a);
    }
        System.out.println(myarrr);
    }
    
}
