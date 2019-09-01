/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.ho;

/**
 *
 * @author Pham Thu Trang
 */
public class nhanvien {
        String HoTen;
   protected double luong;
    public nhanvien(String HoTen,double luong){
        this.HoTen=HoTen;
        this.luong=luong;
        
        
    }
    public double getthunhap(){
        return luong*2;
    }
    public void xuat() {
        System.out.println("Họ và tên nhân vien: "+HoTen);
        System.out.println("Lương: "+luong);
        System.out.println("Thu nhập:"+getthunhap());
    
}
}
