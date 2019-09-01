/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2_slide3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;





/**
 *
 * @author Pham Thu Trang
 */
public class demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> names=new ArrayList<>(); 
        names.add("Tuấn");
        names.add("Hằng");
        names.add("Anh");
        names.add("Phương");
        names.set(1,"Khánh");
        names.remove("Trang");
        System.out.println(names.toString());
        System.out.println("-----");
        System.out.println("---c1---");
        for(int i=0;i<names.size();i++){
            String name=names.get(i);
            System.out.println(">>name:"+name);
            
            
        }
        System.out.println("---c2---");
        for(String name:names){
            System.out.println(">>name"+name);
            
        }
        Iterator<String> iterator=names.iterator();
        while(iterator.hasNext()){
            String name=iterator.next();
            System.out.println(">>name"+name);
        }
    }
}
        
        
        
  
