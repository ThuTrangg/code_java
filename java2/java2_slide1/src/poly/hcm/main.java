/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.hcm;

import poly.ho.nhanvien;

/**
 *
 * @author Pham Thu Trang
 */
public class main {
     public static void main(String[] args) {
        nhanvien nv=new nhanvien("Phạm Thu Trang",5000);
        truongphong tp=new truongphong("Trần văn A",3000,700);
        nv.xuat();
        System.out.println("");
        System.out.println("--------------------");
        System.out.println("");
        tp.xuat();
    }
}
