/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pham Thu Trang
 */
public class main_bai2 {
    public static void main(String[] args) throws IOException {
        
List<Student> list = new ArrayList<>();
list.add(new Student("Tuấn", 5, "CNTT"));
list.add(new Student("Cường", 7.5, "TKTW"));
list.add(new Student("Hạnh", 8.5, "CNTT"));
XFile.writeObject("c:/temp/students.dat", list);
List<Student> list2 =(List<Student>) XFile.readObject("c:/temp/students.dat");
for(Student sv : list){
    System.out.println(">Họ và tên: " + sv.name);
}
}
}

