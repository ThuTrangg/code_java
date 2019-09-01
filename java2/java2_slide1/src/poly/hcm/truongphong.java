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
public class truongphong extends nhanvien{
    private  double trachnhiem;
   
    public truongphong(String HoTen,double luong,double trachnhiem){
        super(HoTen,luong);
        this.trachnhiem=trachnhiem;
        

        
    }
    public double getThuNhap(){
        return super.luong*10+this.trachnhiem;
    }
    public void xuat(){
        super.xuat();
        System.out.println("Trách nhiệm:"+this.trachnhiem);
        System.out.println("Thu nhập :"+getThuNhap());
    }
    
}
