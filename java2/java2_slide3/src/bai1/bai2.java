/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Pham Thu Trang
 */
public class bai2 {
    public static void main(String[] args) {
        Map<String, Student> map = new HashMap<>();
        Student sv1 = new Student();
        sv1.name = "Tuấn";
        sv1.major = "CNTT";
        sv1.marks = 7.0;
        map.put(sv1.name, sv1);
        Set<String> keys = map.keySet();
        for(String name : keys){
        Student sv = map.get(name);
        System.out.println(">Họ và tên: " + sv.name);
        System.out.println(">Học lực: " + sv.getGrade());
}
    }
    
}
