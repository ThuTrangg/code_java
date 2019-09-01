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
public class EmployeeManager {
    public static void main(String[] args) {
        nhanvien e1 = new nhanvien("Trang"){
         public double getSalary() {
         return 7000000;}
        };

e1.print();   
        
    
}}
