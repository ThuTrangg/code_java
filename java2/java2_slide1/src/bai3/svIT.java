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
public class svIT  extends sinhvienfpoly{
   
   double diem1,diem2,diem3;
   public svIT(String Hoten,String nganh,double diem1,double diem2,double diem3){
    super(Hoten,nganh);
    this.diem1=diem1;
     this.diem2=diem2;
      this.diem3=diem3;
   }
   public double getdiem(){
       return (diem1*2+diem2+diem3)/4;
    
       
   }
    
}
