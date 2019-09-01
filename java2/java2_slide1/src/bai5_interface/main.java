/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai5_interface;

/**
 *
 * @author Pham Thu Trang
 */
public class main {
    public static void main(String[] args) {
        DbAction db1 = new products();
        DbAction db2 = new order();
db1.insert();
        System.out.println("------");
db2.insert();
    }  
}
