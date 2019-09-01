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
public class svBiz extends sinhvienfpoly {
    double marketting,sales;
   public svBiz(String Hoten,String nganh,double marketting,double sales){
       super(Hoten,nganh);
      this.marketting=marketting;
      this.sales=sales;}

public double getdiem(){
    return (marketting*2+sales)/3;
}
    
}
