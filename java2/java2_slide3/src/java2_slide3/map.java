/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2_slide3;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Pham Thu Trang
 */
public class map {
    public static void main(String[] args) {
        Map<String,Double> map=new HashMap<String,Double>();
        map.put("Nokia",500.0);
        map.put("samsung",700.0);
        map.put("iphone",1200.0);
        map.put("sony",1500.0);
        System.out.println(map.toString());
       for(Entry<String,Double>entry:map.entrySet()){ 
           String ten=entry.getKey();
           double diem=entry.getValue();
           System.out.println(ten+" "+diem);
       }
    }
    
}
