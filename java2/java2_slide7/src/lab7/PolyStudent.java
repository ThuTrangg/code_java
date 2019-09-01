/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;
/**
 *
 * @author Pham Thu Trang
 */
public class PolyStudent {
    public String fullname;
    public Caree career;
    

public void print(){
    System.out.println("fullname: "+this.fullname);
    switch (career) {
        case UDPM:
            System.err.println(">>Career: UDPM");
              break;
        case TKTW:
            System.out.println(">Career: Thiết kế trang web");
            break;
        case LTDD: 
            System.out.println(">Career: Lập trình di động");
            break;
        case TKDH:
            System.out.println(">Career: Thiết kế đồ họa");
            break;
    }
}
    public static void main(String[] args) {
        PolyStudent sv = new PolyStudent();
        sv.fullname = "Nguyễn Văn Tèo";
        //sv.career = Career.UDPM;
        sv.career = Caree.valueOf("UDPM");
        sv.print();
}
    }
