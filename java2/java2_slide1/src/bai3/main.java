/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;

/**
 *
 * @author Pham Thu Trang
 */
public class main {
     public static void main(String[] args) {
        sinhvienfpoly IT=new svIT("Nguyễn Văn A","UD",10,8,9);
        sinhvienfpoly Biz=new svBiz("Phạm Thu Trang","LT",5,9);
        IT.xuat();
        System.out.println("----");
        Biz.xuat();
    }
}
