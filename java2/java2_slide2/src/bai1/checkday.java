/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.util.Scanner;

/**
 *
 * @author Pham Thu Trang
 */
public class checkday {
 static  Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Mời nhập day:");
      int day=Integer.parseInt(sc.nextLine());
      
      if(day==weekday.Saturday||day==weekday.Sunday) {
          System.out.println("Ngày cuối tuần !!");
      } 
      else 
            System.out.println("Ngày trong tuần ");
      
      
       
    }
    
}
