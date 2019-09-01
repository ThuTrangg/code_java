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
abstract public class sinhvienfpoly {
   public  String Hoten;
   public String nganh;
   abstract public double getdiem();
   
  public sinhvienfpoly(String Hoten,String nganh){
 this.Hoten=Hoten;
 this.nganh=nganh;

    
       
   }
  public String gethocluc(){
      String hocLuc;
      if(getdiem()<5){
          hocLuc="Yếu";}
      else if(getdiem()>=5&&getdiem()<6.5){
          hocLuc="TB";}
      else if(getdiem()>=6.5&&getdiem()<7.5){
          hocLuc="Khá";}
      else if(getdiem()>=7.5&&getdiem()<9){
          hocLuc="G";}
      else{
          hocLuc="Xuất sắc";}
     return hocLuc;
     
      }
  public void xuat(){
             System.out.println("Họ và tên :"+Hoten);
             System.out.println("Ngành :"+nganh);
             System.out.println("Điểm :"+getdiem());
             System.out.println("Học lực :"+gethocluc());
  }  
}
