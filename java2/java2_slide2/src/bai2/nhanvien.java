/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

/**
 *
 * @author Pham Thu Trang
 */


   public abstract class nhanvien {
private String fullname;
public nhanvien(String fullname){
this.fullname = fullname;
}
public abstract double getSalary();
public void print(){
System.out.println("Fullname: " + this.fullname);
System.out.println("Salary: " + this.getSalary());
}
} 
